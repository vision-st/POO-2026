package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import data.GestorBiblioteca;
import model.MaterialBiblioteca;

public class BibliotecaFrame extends JFrame {
    private final GestorBiblioteca gestor;
    private final DefaultListModel<String> modeloLista;
    private final JList<String> listaMateriales;
    private final JTextArea areaDetalle;
    private final JTextArea areaBitacora;

    public BibliotecaFrame(GestorBiblioteca gestor) {
        this.gestor = gestor;
        this.modeloLista = new DefaultListModel<>();
        this.listaMateriales = new JList<>(modeloLista);
        this.areaDetalle = new JTextArea();
        this.areaBitacora = new JTextArea();
        inicializar();
    }

    private void inicializar() {
        setTitle("Biblioteca Hibrida - Interfaz Grafica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(980, 620));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(12, 12));

        listaMateriales.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaMateriales.addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) {
                actualizarDetalle();
            }
        });

        areaDetalle.setEditable(false);
        areaDetalle.setLineWrap(true);
        areaDetalle.setWrapStyleWord(true);

        areaBitacora.setEditable(false);
        areaBitacora.setLineWrap(true);
        areaBitacora.setWrapStyleWord(true);

        JPanel panelCentro = new JPanel(new GridLayout(1, 2, 12, 12));
        panelCentro.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        panelCentro.add(crearPanelLista());
        panelCentro.add(crearPanelDetalle());

        add(panelCentro, BorderLayout.CENTER);
        add(crearPanelBotones(), BorderLayout.SOUTH);

        cargarLista();
        if (!modeloLista.isEmpty()) {
            listaMateriales.setSelectedIndex(0);
        }
    }

    private JPanel crearPanelLista() {
        JPanel panel = new JPanel(new BorderLayout(8, 8));
        panel.setBorder(BorderFactory.createTitledBorder("Catalogo"));
        panel.add(new JScrollPane(listaMateriales), BorderLayout.CENTER);
        return panel;
    }

    private JPanel crearPanelDetalle() {
        JPanel panel = new JPanel(new GridLayout(2, 1, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder());

        JPanel detalle = new JPanel(new BorderLayout());
        detalle.setBorder(BorderFactory.createTitledBorder("Detalle del material"));
        detalle.add(new JScrollPane(areaDetalle), BorderLayout.CENTER);

        JPanel bitacora = new JPanel(new BorderLayout());
        bitacora.setBorder(BorderFactory.createTitledBorder("Bitacora de acciones"));
        bitacora.add(new JScrollPane(areaBitacora), BorderLayout.CENTER);

        panel.add(detalle);
        panel.add(bitacora);
        return panel;
    }

    private JPanel crearPanelBotones() {
        JPanel panel = new JPanel(new GridLayout(1, 5, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 12, 12, 12));

        JButton btnPrestar = new JButton("Prestar");
        JButton btnDevolver = new JButton("Devolver");
        JButton btnDescargar = new JButton("Descargar");
        JButton btnMuestra = new JButton("Reproducir muestra");
        JButton btnTipo = new JButton("Ver tipo real");

        btnPrestar.addActionListener(e -> ejecutarAccion(TipoAccion.PRESTAR));
        btnDevolver.addActionListener(e -> ejecutarAccion(TipoAccion.DEVOLVER));
        btnDescargar.addActionListener(e -> ejecutarAccion(TipoAccion.DESCARGAR));
        btnMuestra.addActionListener(e -> ejecutarAccion(TipoAccion.MUESTRA));
        btnTipo.addActionListener(e -> ejecutarAccion(TipoAccion.TIPO));

        panel.add(btnPrestar);
        panel.add(btnDevolver);
        panel.add(btnDescargar);
        panel.add(btnMuestra);
        panel.add(btnTipo);
        return panel;
    }

    private void cargarLista() {
        modeloLista.clear();
        List<MaterialBiblioteca> materiales = gestor.obtenerMateriales();
        for (MaterialBiblioteca material : materiales) {
            modeloLista.addElement(material.getCodigo() + " - " + material.getTitulo());
        }
    }

    private void actualizarDetalle() {
        int indice = listaMateriales.getSelectedIndex();
        if (indice < 0) {
            areaDetalle.setText("Seleccione un material.");
            return;
        }
        areaDetalle.setText(gestor.describirMaterial(indice));
    }

    private void ejecutarAccion(TipoAccion accion) {
        int indice = listaMateriales.getSelectedIndex();
        if (indice < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un material primero.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String resultado;
        switch (accion) {
            case PRESTAR -> resultado = gestor.prestarMaterial(indice);
            case DEVOLVER -> resultado = gestor.devolverMaterial(indice);
            case DESCARGAR -> resultado = gestor.descargarMaterial(indice);
            case MUESTRA -> resultado = gestor.reproducirMuestra(indice);
            case TIPO -> resultado = gestor.describirTipoReal(indice);
            default -> throw new IllegalStateException("Accion no soportada");
        }

        areaBitacora.append(resultado + "\n");
        actualizarDetalle();
        listaMateriales.repaint();
    }

    public static void abrir(GestorBiblioteca gestor) {
        SwingUtilities.invokeLater(() -> new BibliotecaFrame(gestor).setVisible(true));
    }

    private enum TipoAccion {
        PRESTAR,
        DEVOLVER,
        DESCARGAR,
        MUESTRA,
        TIPO
    }
}
