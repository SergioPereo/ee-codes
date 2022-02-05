package examenfinaldic2021;

import java.util.Iterator;
/**
*
* @author Sergio P.
*/
public class ConjuntoEnlazado <T> implements ConjuntoADT<T>{

	Nodo<T> primero = null;
	int cardinalidad;
	
	public ConjuntoEnlazado() {
		cardinalidad = 0;
	}
	
	@Override
	public boolean agrega(T nuevo) {
		boolean resp = true;
		if(primero == null) {
			primero = new Nodo<T>(nuevo);
			cardinalidad++;
		} else {
			Nodo<T> aux = primero, nuevoNodo;
			while(aux.getDirec() != null && resp) {
				resp = !aux.getDato().equals(nuevo);
				aux = aux.getDirec();
			}
			if(resp && !aux.getDato().equals(nuevo)) {
				nuevoNodo = new Nodo<T>(nuevo);
				aux.setDirec(nuevoNodo);
				cardinalidad++;
			} else {
				resp = false;
			}
		}
		return resp;
	}
	
	@SuppressWarnings("unused")
	private boolean contieneI(T dato) {
		boolean resp = false;
		if(primero != null){
			Nodo<T> aux = primero;
			while(aux != null && !resp) {
				resp = aux.getDato().equals(dato);
				aux = aux.getDirec();
			}
		}
		return resp;
	}
	
	private boolean contieneR(Nodo<T> aux, T dato, boolean resp) {
		if(aux != null && !resp) {
			return contieneR(aux.getDirec(), dato, aux.getDato().equals(dato));
		} else {
			return resp;
		}
	}

	@Override
	public boolean contiene(T dato) {
		return contieneR(primero, dato, false);
	}

	@Override
	public int getCardinalidad() {
		return cardinalidad;
	}

	@Override
	public Iterator<T> iterator() {
		return new IteradorNodos<T>(primero);
	}

	@Override
	public ConjuntoADT<T> union(ConjuntoADT<T> otro) {
		if(otro == null)
			throw new RuntimeException("Conjunto vacío");
		ConjuntoADT<T> aux = new ConjuntoEnlazado<T>();
		Iterator<T> miIterador = this.iterator(), otroIterador = otro.iterator();
		while(miIterador.hasNext()) {
			aux.agrega(miIterador.next());
		}
		while(otroIterador.hasNext()) {
			aux.agrega(otroIterador.next());
		}
		return aux;
	}
	
	private boolean esSubconjuntoDeR(Nodo<T> aux, ConjuntoADT<T> otro) {
		if(aux != null) {
			if(otro.contiene(aux.getDato())) {
				return esSubconjuntoDeR(aux.getDirec(), otro);
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	@Override
	public boolean esSubconjuntoDe(ConjuntoADT<T> otro) {
		if(otro == null)
			throw new RuntimeException("Conjunto vacío");
		return esSubconjuntoDeR(primero, otro);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Nodo<T> aux = primero;
		while(aux != null) {
			sb.append(" " + aux.toString());
			aux = aux.getDirec();
		}
		return sb.toString();
	}

}
