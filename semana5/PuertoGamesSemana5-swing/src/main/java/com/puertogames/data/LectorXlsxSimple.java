package com.puertogames.data;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class LectorXlsxSimple {

    public List<List<String>> leerFilas(String resourcePath) throws IOException {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath)) {
            if (inputStream == null) {
                throw new IOException("No se encontro el archivo: " + resourcePath);
            }

            Map<String, byte[]> entries = readZipEntries(inputStream);
            List<String> sharedStrings = readSharedStrings(entries.get("xl/sharedStrings.xml"));
            return readSheet(entries.get("xl/worksheets/sheet1.xml"), sharedStrings);
        } catch (Exception e) {
            throw new IOException("No fue posible leer el archivo XLSX: " + e.getMessage(), e);
        }
    }

    private Map<String, byte[]> readZipEntries(InputStream inputStream) throws IOException {
        Map<String, byte[]> entries = new HashMap<>();
        try (ZipInputStream zipInputStream = new ZipInputStream(inputStream)) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                entries.put(entry.getName(), zipInputStream.readAllBytes());
            }
        }
        return entries;
    }

    private List<String> readSharedStrings(byte[] xmlBytes) throws Exception {
        List<String> sharedStrings = new ArrayList<>();
        if (xmlBytes == null) {
            return sharedStrings;
        }

        Document document = parseXml(xmlBytes);
        NodeList items = document.getElementsByTagNameNS("*", "si");
        for (int i = 0; i < items.getLength(); i++) {
            Element si = (Element) items.item(i);
            sharedStrings.add(textFromSi(si));
        }
        return sharedStrings;
    }

    private String textFromSi(Element si) {
        NodeList texts = si.getElementsByTagNameNS("*", "t");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < texts.getLength(); i++) {
            builder.append(texts.item(i).getTextContent());
        }
        return builder.toString();
    }

    private List<List<String>> readSheet(byte[] xmlBytes, List<String> sharedStrings) throws Exception {
        if (xmlBytes == null) {
            throw new IOException("No se encontro la hoja principal del archivo XLSX.");
        }

        List<List<String>> rows = new ArrayList<>();
        Document document = parseXml(xmlBytes);
        NodeList rowNodes = document.getElementsByTagNameNS("*", "row");

        for (int i = 0; i < rowNodes.getLength(); i++) {
            Element rowElement = (Element) rowNodes.item(i);
            NodeList cellNodes = rowElement.getElementsByTagNameNS("*", "c");
            List<String> rowValues = new ArrayList<>();
            int currentColumn = 0;

            for (int j = 0; j < cellNodes.getLength(); j++) {
                Element cell = (Element) cellNodes.item(j);
                int targetColumn = columnIndexFromRef(cell.getAttribute("r"));
                while (currentColumn < targetColumn) {
                    rowValues.add("");
                    currentColumn++;
                }
                rowValues.add(readCellValue(cell, sharedStrings));
                currentColumn++;
            }
            rows.add(rowValues);
        }

        return rows;
    }

    private String readCellValue(Element cell, List<String> sharedStrings) {
        String type = cell.getAttribute("t");
        NodeList valueNodes = cell.getElementsByTagNameNS("*", "v");
        if (valueNodes.getLength() == 0) {
            return "";
        }

        String rawValue = valueNodes.item(0).getTextContent();
        if ("s".equals(type)) {
            int index = Integer.parseInt(rawValue);
            return index >= 0 && index < sharedStrings.size() ? sharedStrings.get(index) : "";
        }
        return rawValue;
    }

    private int columnIndexFromRef(String cellRef) {
        int result = 0;
        for (int i = 0; i < cellRef.length(); i++) {
            char ch = cellRef.charAt(i);
            if (Character.isLetter(ch)) {
                result = result * 26 + (Character.toUpperCase(ch) - 'A' + 1);
            } else {
                break;
            }
        }
        return Math.max(result - 1, 0);
    }

    private Document parseXml(byte[] xmlBytes) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        try (ByteArrayInputStream input = new ByteArrayInputStream(xmlBytes)) {
            return factory.newDocumentBuilder().parse(input);
        }
    }
}
