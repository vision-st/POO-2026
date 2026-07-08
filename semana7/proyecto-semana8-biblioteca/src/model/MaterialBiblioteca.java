package model;

public abstract class MaterialBiblioteca {
    private final String titulo;
    private final String codigo;
    private final String autor;

    protected MaterialBiblioteca(String titulo, String codigo, String autor) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getAutor() {
        return autor;
    }

    public void mostrarResumen() {
        System.out.println(describirResumen());
    }

    public abstract String describirResumen();
}
