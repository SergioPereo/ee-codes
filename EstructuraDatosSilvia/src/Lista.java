import java.util.Iterator;

public abstract class Lista <T> implements ListaADT<T>{
	protected NodoTL<T> primero;
	protected NodoTL<T> ultimo;
	
	protected Lista() {
		primero = null;
		ultimo = null;
	}
	
	public boolean estaVacia() {
		return primero == null;
	}
	
	public T quitaPrimero() {
		if(estaVacia())
			throw new RuntimeException("Lista vacía");
		T eliminado = primero.getDato();
		primero = primero.getSiguiente();
		if(primero == null)
			ultimo = null;
		else {
			primero.getAnterior().setSiguiente(null);
			primero.setAnterior(null);
		}
		return eliminado;
	}
	
	public T quitaUltimo() {
		if(estaVacia())
			throw new RuntimeException("Lista vacía");
		T eliminado = ultimo.getDato();
		ultimo = ultimo.getAnterior();
		if(ultimo == null)
			primero = null;
		else {
			ultimo.getSiguiente().setAnterior(null);
			ultimo.setSiguiente(null);
		}
		return eliminado;
	}
	
	public T quita(T dato) {
		if(estaVacia())
			throw new RuntimeException("Lista vacía");
		T eliminado = null;
		if(primero.getDato().equals(dato))
			eliminado = quitaPrimero();
		else
			if(ultimo.getDato().equals(dato))
				eliminado = quitaUltimo();
			else {
				NodoTL<T> aux = primero.getSiguiente();
				while(aux != null && !aux.getDato().equals(dato)) {
					aux = aux.getSiguiente();
				}
				if(aux != null) {
					aux.getAnterior().setSiguiente(aux.getSiguiente());
					aux.getSiguiente().setAnterior(aux.getAnterior());
					aux.setAnterior(null);
					aux.setSiguiente(null);
					eliminado = aux.getDato();
				}
			}
		
		return eliminado;
	}
	
	private int size(NodoTL<T> ultimo, int i) {
		if(ultimo != null)
			return size(ultimo.getAnterior(), i+1);
		else
			return i;
	}
	
	public int size() {
		return size(ultimo, 0);
	}
	
	private String toString(NodoTL<T> actual, StringBuilder sB) {
		if(ultimo != null) {
			sB.append(actual.getDato().toString());
			return toString(ultimo.getAnterior(), sB);	
		}
		else
			return sB.toString();
	}
	
	public String toString() {
		return toString(ultimo, new StringBuilder());
	}
	
	public T obtienePrimero() {
		if(this.estaVacia())
			throw new RuntimeException("No hay datos");
		return primero.getDato();
	}
	
	public T obtieneUltimo() {
		if(this.estaVacia())
			throw new RuntimeException("No hay datos");
		return ultimo.getDato();
	}
	
	private boolean contiene(NodoTL<T> actual, T dato) {
		if(actual == null) 
			return false;
		else
			if(actual.getDato().equals(dato))
				return true;
			else
				return contiene(actual.getSiguiente(), dato);
	}
	
	public boolean contiene(T dato) {
		return contiene(primero, dato);
	}

	public Iterator<T> iterator(){
		return new IteratorTL<T>(primero);
	}
	
}
