import java.util.Iterator;

public class ColaE<T> implements ColaADT<T> {

	private EE<T> cola;
	
	public ColaE() {
		cola = new EE<T>();
	}

	@Override
	public void agrega(T dato) {
		cola.agregaFinal(dato);
	}

	@Override
	public T quita() {
		if(this.estaVacia())
			throw new RuntimeException("Colección vacía");
		return cola.quitaPrimero();
	}

	@Override
	public boolean estaVacia() {
		return cola.estaVacia();
	}

	@Override
	public T consultaPrimero() {
		if(this.estaVacia())
			throw new RuntimeException("Colección vacía");
		return cola.iterator().next();
	}
	
	public T consultaUltimo() {
		if(this.estaVacia())
			throw new RuntimeException("Colección vacía");
		Iterator<T> it = cola.iterator();
		T dato = null;
		while(it.hasNext())
			dato = it.next();
		return dato;
	}

}
