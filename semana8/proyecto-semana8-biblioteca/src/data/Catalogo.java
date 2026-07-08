package data;

import java.util.ArrayList;
import java.util.List;

public class Catalogo<T> {
    private final List<T> elementos;

    public Catalogo() {
        this.elementos = new ArrayList<>();
    }

    public void agregar(T elemento) {
        elementos.add(elemento);
    }

    public List<T> obtenerTodos() {
        return elementos;
    }
}
