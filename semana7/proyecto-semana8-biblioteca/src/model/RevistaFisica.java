package model;

public class RevistaFisica extends MaterialBiblioteca implements Prestable {
    private final int numeroEdicion;
    private boolean prestada;

    public RevistaFisica(String titulo, String codigo, String autor, int numeroEdicion) {
        super(titulo, codigo, autor);
        this.numeroEdicion = numeroEdicion;
    }

    @Override
    public String describirResumen() {
        return "[Revista Fisica] " + getTitulo() + " | Edicion: " + numeroEdicion +
                " | Responsable: " + getAutor() + " | Prestada: " + prestada;
    }

    @Override
    public String prestar() {
        if (prestada) {
            return "La revista '" + getTitulo() + "' ya se encuentra prestada.";
        }
        prestada = true;
        return "Revista prestada: " + getTitulo();
    }

    @Override
    public String devolver() {
        if (!prestada) {
            return "La revista '" + getTitulo() + "' ya estaba disponible.";
        }
        prestada = false;
        return "Revista devuelta: " + getTitulo();
    }

    @Override
    public boolean estaPrestado() {
        return prestada;
    }
}
