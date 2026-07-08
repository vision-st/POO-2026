package model;

public class LibroFisico extends MaterialBiblioteca implements Prestable {
    private final int paginas;
    private boolean prestado;

    public LibroFisico(String titulo, String codigo, String autor, int paginas) {
        super(titulo, codigo, autor);
        this.paginas = paginas;
    }

    @Override
    public String describirResumen() {
        return "[Libro Fisico] " + getTitulo() + " | Autor: " + getAutor() +
                " | Paginas: " + paginas + " | Prestado: " + prestado;
    }

    @Override
    public String prestar() {
        if (prestado) {
            return "El libro '" + getTitulo() + "' ya estaba prestado.";
        }
        prestado = true;
        return "Libro prestado: " + getTitulo();
    }

    @Override
    public String devolver() {
        if (!prestado) {
            return "El libro '" + getTitulo() + "' no estaba prestado.";
        }
        prestado = false;
        return "Libro devuelto: " + getTitulo();
    }

    @Override
    public boolean estaPrestado() {
        return prestado;
    }
}
