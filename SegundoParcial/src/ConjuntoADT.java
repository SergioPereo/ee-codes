import java.util.Iterator;

/**
 *
 * @author Guardati
 */
public interface ConjuntoADT <T> extends Iterable <T>{
    public boolean agrega(T nuevo);
    public T quita(T dato);
    public boolean contiene(T dato);
    public ConjuntoADT<T> union(ConjuntoADT<T> otro);
    public ConjuntoADT<T> interseccion(ConjuntoADT<T> otro);
    public ConjuntoADT<T> diferencia(ConjuntoADT<T> otro);
    public Iterator<T> iterator();
    public String toString();
    public int getCardinalidad();
}
