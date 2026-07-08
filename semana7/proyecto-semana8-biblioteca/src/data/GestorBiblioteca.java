package data;

import java.util.ArrayList;
import java.util.List;

import model.Audiolibro;
import model.Descargable;
import model.Ebook;
import model.MaterialBiblioteca;
import model.Prestable;
import model.Reproducible;
import model.RevistaFisica;
import model.LibroFisico;

public class GestorBiblioteca {
    private final Catalogo<MaterialBiblioteca> catalogo;

    public GestorBiblioteca() {
        this.catalogo = new Catalogo<>();
    }

    public void cargarDatosDemo() {
        if (!catalogo.obtenerTodos().isEmpty()) {
            return;
        }
        catalogo.agregar(new LibroFisico("Clean Code", "L-101", "Robert Martin", 450));
        catalogo.agregar(new RevistaFisica("Java Magazine", "R-202", "Oracle", 58));
        catalogo.agregar(new Ebook("Patrones de Diseno", "E-303", "GoF", 12.5));
        catalogo.agregar(new Audiolibro("El Principito", "A-404", "Antoine de Saint-Exupery", 96));
    }

    public List<MaterialBiblioteca> obtenerMateriales() {
        return new ArrayList<>(catalogo.obtenerTodos());
    }

    public String describirMaterial(int indice) {
        return obtenerPorIndice(indice).describirResumen();
    }

    public String describirTipoReal(int indice) {
        MaterialBiblioteca material = obtenerPorIndice(indice);
        if (material instanceof Ebook) {
            return material.getTitulo() + " es un Ebook.";
        }
        if (material instanceof Audiolibro) {
            return material.getTitulo() + " es un Audiolibro.";
        }
        if (material instanceof Prestable) {
            return material.getTitulo() + " es un material fisico prestable.";
        }
        return material.getTitulo() + " es un material no clasificado.";
    }

    public String prestarMaterial(int indice) {
        MaterialBiblioteca material = obtenerPorIndice(indice);
        if (material instanceof Prestable prestable) {
            return prestable.prestar();
        }
        return material.getTitulo() + " no se puede prestar.";
    }

    public String devolverMaterial(int indice) {
        MaterialBiblioteca material = obtenerPorIndice(indice);
        if (material instanceof Prestable prestable) {
            return prestable.devolver();
        }
        return material.getTitulo() + " no requiere devolucion.";
    }

    public String descargarMaterial(int indice) {
        MaterialBiblioteca material = obtenerPorIndice(indice);
        if (material instanceof Descargable descargable) {
            return descargable.descargar();
        }
        return material.getTitulo() + " no es descargable.";
    }

    public String reproducirMuestra(int indice) {
        MaterialBiblioteca material = obtenerPorIndice(indice);
        if (material instanceof Reproducible reproducible) {
            return reproducible.reproducirMuestra();
        }
        return material.getTitulo() + " no tiene muestra reproducible.";
    }

    public void mostrarCatalogo() {
        for (MaterialBiblioteca material : catalogo.obtenerTodos()) {
            material.mostrarResumen();
        }
    }

    public void procesarPrestamos() {
        for (MaterialBiblioteca material : catalogo.obtenerTodos()) {
            if (material instanceof Prestable prestable) {
                System.out.println(prestable.prestar());
            }
        }
    }

    public void procesarDescargas() {
        for (MaterialBiblioteca material : catalogo.obtenerTodos()) {
            if (material instanceof Descargable descargable) {
                System.out.println(descargable.descargar());
            }
        }
    }

    public void reproducirMuestras() {
        for (MaterialBiblioteca material : catalogo.obtenerTodos()) {
            if (material instanceof Reproducible reproducible) {
                System.out.println(reproducible.reproducirMuestra());
            }
        }
    }

    public void mostrarTiposReales() {
        for (int i = 0; i < catalogo.obtenerTodos().size(); i++) {
            System.out.println(describirTipoReal(i));
        }
    }

    private MaterialBiblioteca obtenerPorIndice(int indice) {
        if (indice < 0 || indice >= catalogo.obtenerTodos().size()) {
            throw new IllegalArgumentException("Indice fuera de rango: " + indice);
        }
        return catalogo.obtenerTodos().get(indice);
    }
}
