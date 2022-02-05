/**
 * Interface para definir el comportamiento de una Pila.
 * @author Silvia Guardati
 */
public interface PilaADT <T>{
    public T pop();
    public T peek();
    public boolean isEmpty();
    public void push(T dato);
}
