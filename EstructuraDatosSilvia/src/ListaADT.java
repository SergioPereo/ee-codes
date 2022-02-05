import java.util.Iterator;

public interface ListaADT <T> extends Iterable<T>{

	public Iterator<T> iterator();
	public boolean estaVacia();
	public T quitaPrimero();
	public T quitaUltimo();
	public T quita(T dato);
	public String toString();
	public boolean contiene(T dato);
	public int size();
	public T obtienePrimero();
	public T obtieneUltimo();
	
}
