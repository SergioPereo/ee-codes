
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Guardati
 */
public class IteradorArreglo <T> implements Iterator<T>{
    private int total;
    private int actual;
    private T[] coleccion;

    public IteradorArreglo(int total, T[] coleccion) {
        this.total = total;
        this.coleccion = coleccion;
        this.actual = 0;
    }
    
    public boolean hasNext(){
        return actual < total;
    }
    
    public T next(){
        if (hasNext()){
           T visitado = coleccion[actual];
           actual++;
           return visitado;
        }
        else
            throw new NoSuchElementException();
    }
    
}

