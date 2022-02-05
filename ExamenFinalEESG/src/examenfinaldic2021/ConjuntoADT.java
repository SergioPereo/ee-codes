
package examenfinaldic2021;

import java.util.Iterator;

/**
 *
 * @author Guardati
 */
public interface ConjuntoADT <T> extends Iterable<T>{
    public boolean agrega(T nuevo);    
    public boolean contiene(T dato);
    public int getCardinalidad();
    public Iterator<T> iterator();
    public ConjuntoADT<T> union(ConjuntoADT<T> otro);
    public boolean esSubconjuntoDe(ConjuntoADT<T> otro);
    
    // estaVacio(): boolean;
    // public String toString();
    // public T quita(T dato);   
    // public ConjuntoADT<T> interseccion(ConjuntoADT<T> otro);
    // public ConjuntoADT<T> diferencia(ConjuntoADT<T> otro);        
}
