
package examenfinaldic2021;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Guardati
 */
public class IteradorNodos <T> implements Iterator<T>{
    private Nodo<T> actual;

    public IteradorNodos(Nodo<T> actual) {
        this.actual = actual;
    }    
    
    @Override
    public boolean hasNext() {
        return actual != null;
    }

    @Override
    public T next() {
        if (hasNext()){
            T dato = actual.getDato();
            actual = actual.getDirec();
            return dato;
        }
        throw new NoSuchElementException();
    }
    
}
