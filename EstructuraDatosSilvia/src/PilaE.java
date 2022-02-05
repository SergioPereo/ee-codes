import java.util.Iterator;

public class PilaE<T> implements PilaADT<T> {

	private EE<T> pila;
	
	public PilaE() {
		pila = new EE<T>();
	}
	
	@Override
	public T pop() {
		if(this.isEmpty())
			throw new RuntimeException("Colección vacía");
		return pila.quitaPrimero();
	}

	@Override
	public T peek() {
		if(this.isEmpty())
			throw new RuntimeException("Colección vacía");
		return pila.iterator().next();
	}

	@Override
	public boolean isEmpty() {
		return pila.estaVacia();
	}

	@Override
	public void push(T dato) {
		pila.agregaInicio(dato);
	}

}
