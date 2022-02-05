import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteradorEE<T> implements Iterator<T> {
	
	Nodo<T> actual;
	
	public IteradorEE(Nodo<T> actual) {
		this.actual = actual;
	}

	@Override
	public boolean hasNext() {
		return actual != null;
	}

	@Override
	public T next() {
		if(!hasNext())
			throw new NoSuchElementException();
		T dato = actual.getDato();
		actual = actual.getDirec();
		return dato;
	}

}
