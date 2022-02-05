
package examenfinaldic2021;

/**
 *
 * @author Guardati
 */
public class Nodo <T>{
    private T dato;
    private Nodo<T> direc;

    public Nodo() {
    }

    public Nodo(T dato) {
        this.dato = dato;
        this.direc = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getDirec() {
        return direc;
    }

    public void setDirec(Nodo<T> direc) {
        this.direc = direc;
    }

    @Override
    public String toString() {
        return "\n" + dato;
    }
}
