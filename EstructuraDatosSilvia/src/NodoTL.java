
public class NodoTL <T>{
	
	private T dato;
	private NodoTL<T> anterior;
	private NodoTL<T> siguiente;
	
	public NodoTL() {
		anterior = null;
		siguiente = null;
	}
	
	public NodoTL(T dato) {
		this();
		this.dato = dato;
	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public NodoTL<T> getAnterior() {
		return anterior;
	}

	public void setAnterior(NodoTL<T> anterior) {
		this.anterior = anterior;
	}

	public NodoTL<T> getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoTL<T> siguiente) {
		this.siguiente = siguiente;
	}

}
