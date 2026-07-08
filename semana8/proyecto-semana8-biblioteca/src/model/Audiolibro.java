package model;

public class Audiolibro extends MaterialBiblioteca implements Descargable, Reproducible {
    private final int duracionMinutos;

    public Audiolibro(String titulo, String codigo, String autor, int duracionMinutos) {
        super(titulo, codigo, autor);
        this.duracionMinutos = duracionMinutos;
    }

    @Override
    public String describirResumen() {
        return "[Audiolibro] " + getTitulo() + " | Autor: " + getAutor() +
                " | Duracion: " + duracionMinutos + " min";
    }

    @Override
    public String descargar() {
        return "Descargando audiolibro: " + getTitulo() + "...";
    }

    @Override
    public String reproducirMuestra() {
        return "Reproduciendo muestra del audiolibro: " + getTitulo();
    }
}
