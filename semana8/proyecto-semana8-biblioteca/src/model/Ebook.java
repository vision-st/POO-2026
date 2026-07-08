package model;

public class Ebook extends MaterialBiblioteca implements Descargable, Reproducible {
    private final double tamanoMb;

    public Ebook(String titulo, String codigo, String autor, double tamanoMb) {
        super(titulo, codigo, autor);
        this.tamanoMb = tamanoMb;
    }

    @Override
    public String describirResumen() {
        return "[Ebook] " + getTitulo() + " | Autor: " + getAutor() +
                " | Tamano: " + tamanoMb + " MB";
    }

    @Override
    public String descargar() {
        return "Descargando ebook: " + getTitulo() + "...";
    }

    @Override
    public String reproducirMuestra() {
        return "Abriendo vista previa del ebook: " + getTitulo();
    }
}
