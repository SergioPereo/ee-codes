import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorTL<T> implements Iterator<T>{
	
	NodoTL<T> primero;
	
	public IteratorTL(NodoTL<T> primero) {
		this.primero = primero;
	}

	@Override
	public boolean hasNext() {
		return primero != null;
	}

	@Override
	public T next() {
		if(!hasNext())
			throw new NoSuchElementException();
		T dato = primero.getDato();
		primero = primero.getSiguiente();
		return dato;
	}
}
