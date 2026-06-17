package com.puertogames.ui;

import com.puertogames.data.GestorVideojuegos;
import com.puertogames.model.Videojuego;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class PuertoGamesFrame extends JFrame {
    private final GestorVideojuegos gestor;
    private final DefaultTableModel tableModel;
    private final JTextField txtBusqueda;
    private final JLabel lblEstado;

    public PuertoGamesFrame() {
        this.gestor = new GestorVideojuegos();
        this.tableModel = new DefaultTableModel(new String[]{"Codigo", "Nombre", "Genero", "Plataforma", "Precio", "Stock"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.txtBusqueda = new JTextField(12);
        this.lblEstado = new JLabel("Cargando datos...");

        setTitle("PuertoGames Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(820, 420);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        add(buildTopPanel(), BorderLayout.NORTH);
        add(buildCenterPanel(), BorderLayout.CENTER);
        add(buildBottomPanel(), BorderLayout.SOUTH);

        cargarDatos();
    }

    private JPanel buildTopPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnRecargar = new JButton("Recargar");
        JButton btnBuscar = new JButton("Buscar codigo");
        JButton btnMostrarTodos = new JButton("Mostrar todos");

        btnRecargar.addActionListener(e -> cargarDatos());
        btnBuscar.addActionListener(e -> buscarPorCodigo());
        btnMostrarTodos.addActionListener(e -> mostrarTodos());

        panel.add(new JLabel("Codigo:"));
        panel.add(txtBusqueda);
        panel.add(btnBuscar);
        panel.add(btnMostrarTodos);
        panel.add(btnRecargar);
        return panel;
    }

    private JScrollPane buildCenterPanel() {
        JTable table = new JTable(tableModel);
        table.setRowHeight(24);
        return new JScrollPane(table);
    }

    private JPanel buildBottomPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(lblEstado);
        return panel;
    }

    private void cargarDatos() {
        try {
            gestor.cargarDesdeExcel("videojuegos.xlsx");
            mostrarEnTabla(gestor.listarTodos());
            lblEstado.setText("Registros cargados: " + gestor.totalRegistros());
        } catch (IOException e) {
            lblEstado.setText("Error al cargar datos");
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarPorCodigo() {
        String codigo = txtBusqueda.getText().trim();
        if (codigo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un codigo para buscar.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        gestor.buscarPorCodigo(codigo)
                .ifPresentOrElse(
                        videojuego -> {
                            mostrarEnTabla(List.of(videojuego));
                            lblEstado.setText("Se encontro 1 registro para el codigo " + codigo);
                        },
                        () -> {
                            clearTable();
                            lblEstado.setText("No se encontro el codigo " + codigo);
                            JOptionPane.showMessageDialog(this, "No se encontro el videojuego.", "Busqueda", JOptionPane.INFORMATION_MESSAGE);
                        }
                );
    }

    private void mostrarTodos() {
        mostrarEnTabla(gestor.listarTodos());
        lblEstado.setText("Mostrando todos los registros: " + gestor.totalRegistros());
    }

    private void mostrarEnTabla(List<Videojuego> videojuegos) {
        clearTable();
        for (Videojuego videojuego : videojuegos) {
            tableModel.addRow(new Object[]{
                    videojuego.getCodigo(),
                    videojuego.getNombre(),
                    videojuego.getGenero(),
                    videojuego.getPlataforma(),
                    videojuego.getPrecio(),
                    videojuego.getStock()
            });
        }
    }

    private void clearTable() {
        tableModel.setRowCount(0);
    }
}
