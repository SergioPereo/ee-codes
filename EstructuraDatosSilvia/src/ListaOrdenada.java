public class ListaOrdenada <T extends Comparable<T>> extends Lista<T> implements ListaOrdenadaADT<T>{

	private NodoTL<T> buscaDato(T dato, NodoTL<T> actual){
		if(actual != null)
			if(actual.getDato().compareTo(dato) >= 0)
				return actual;
			else
				return buscaDato(dato, actual.getSiguiente());
		else
			return null;
	}
	
	@Override
	public boolean agrega(T dato) {
		boolean resp = false;
		if(estaVacia()) {
			resp = true;
			primero = new NodoTL<T>(dato);
			ultimo = primero;
		} else {
			NodoTL<T> aux = primero;
			if(primero.getDato().compareTo(dato) > 0) {
				resp = true;
				NodoTL<T> newNode = new NodoTL<T>(dato);
				newNode.setSiguiente(primero);
				primero.setAnterior(newNode);
				primero = newNode;
			} else {
				if(ultimo.getDato().compareTo(dato) < 0) {
					resp = true;
					NodoTL<T> newNode = new NodoTL<T>(dato);
					newNode.setAnterior(ultimo);
					ultimo.setSiguiente(newNode);
					ultimo = newNode;
				} else {
					NodoTL<T> position = this.buscaDato(dato, primero);
					if(!position.getDato().equals(dato)) {
						resp = true;
						NodoTL<T> newNode = new NodoTL<T>(dato);
						newNode.setAnterior(position.getAnterior());
						newNode.setSiguiente(position);
						position.getAnterior().getAnterior().setSiguiente(newNode);
						position.setAnterior(newNode);
					}
				}
			}
		}
		return resp;
	}
	
	public boolean contiene(T dato) {
		NodoTL<T> position = this.buscaDato(dato, primero);
		return position != null && position.getDato().equals(dato);
	}
	
	public T quitaDato(T dato) {
		T resultado = null;
		NodoTL<T> position = this.buscaDato(dato, primero);
		if(position != null && position.getDato().equals(dato)) {
			if(primero.getDato().equals(dato))
				resultado = this.quitaPrimero();
			else
				if(ultimo.getDato().equals(dato))
					resultado = this.quitaUltimo();
				else {
					resultado = position.getDato();
					position.getAnterior().setSiguiente(position.getSiguiente());
					position.getSiguiente().setAnterior(position.getAnterior());
					position.setAnterior(null);
					position.setSiguiente(null);
				}
		}
		return resultado;
	}

}
