import java.util.Iterator;

public class EE <T> implements Iterable<T>{
	private Nodo<T> primero;
	
	public EE() {
		primero = null;
	}
	
	public boolean estaVacia() {
		return primero == null;
	}
	
	public void agregaInicio(T dato) {
		Nodo<T> nuevo = new Nodo<T>(dato);
		nuevo.setDirec(primero);
		primero = nuevo;
	}
	
	public void agregaFinal(T dato) {
		Nodo<T> nuevo = new Nodo<T>(dato);
		if(estaVacia())
			primero = nuevo;
		else {
			Nodo<T> aux = primero;
			while(aux.getDirec() != null)
				aux = aux.getDirec();
			aux.setDirec(nuevo);
		}
	}
	
	public T quitaPrimero() {
		if(estaVacia()) {
			throw new RuntimeException("No hay datos");
		}
		T eliminado = primero.getDato();
		Nodo<T> aux = primero;
		primero = primero.getDirec();
		aux.setDirec(null);
		return eliminado;
	}
	
	public T quitaUltimo() {
		T eliminado;
		if(estaVacia()) {
			throw new RuntimeException("No hay datos");
		}
		if(primero.getDirec() == null) {
			eliminado = primero.getDato();
			primero = null;
		} else {
			Nodo<T> aux = primero.getDirec(), preaux = primero;
			while(aux.getDirec() != null) {
				preaux = aux;
				aux = aux.getDirec();
			}
			eliminado = aux.getDato();
			preaux.setDirec(null);	
		}
		return eliminado;
	}
	
	private boolean buscaDatoR(T dato, Nodo<T> aux) {
		if(aux != null) {
			if(aux.getDato().equals(dato))
				return true;
			else
				return buscaDatoR(dato, aux.getDirec());
		} else 
			return false;
	}
	
	public boolean buscaDatoR(T dato) {
		return buscaDatoR(dato, primero);
	}
	
	public boolean buscaDato(T dato) {
		boolean resp = false;
		Nodo<T> aux = primero;
		while(aux != null && !resp) {
			if(aux.getDato().equals(dato))
				resp = true;
			aux = aux.getDirec();
		}
		return resp;
	}
	
	public T quitaDato(T dato) {
		T eliminado = null;
		Nodo<T> aux, preaux;
		preaux = null;
		aux = primero;
		while(aux != null && !aux.getDato().equals(dato)) {
			preaux = aux;
			aux = aux.getDirec();
		}
		if(aux != null) {
			if(aux.equals(primero))
				primero = primero.getDirec();
			else 
				preaux.setDirec(aux.getDirec());
			eliminado = aux.getDato();	
			aux.setDirec(null);
		}
		return eliminado;
	}
	
	/*
	public String toString() {
		StringBuilder sB = new StringBuilder();
		Nodo<T> aux = primero;
		while(aux != null) {
			sB.append(aux.getDato()).append("\n");
			aux = aux.getDirec();
		}
		return sB.toString();
	}
	*/
	
	private String toString(Nodo<T> actual, StringBuilder sB) {
		if(actual == null) {
			return sB.toString();
		} else {
			sB.append(actual.getDato()).append("\n");
			return toString(actual.getDirec(), sB);
		}
	}
	
	public String toString() {
		return toString(primero, new StringBuilder());
	}
	
	public boolean eliminaSiguiente(T dato) {
		boolean resp = false;
		if(!estaVacia()) {
			Nodo<T> aux = primero, eliminado;
			while(aux.getDirec() != null && !aux.getDato().equals(dato))
				aux = aux.getDirec();
			if(aux.getDato().equals(dato)) {
				if(aux.getDirec()!=null) {
					eliminado = aux.getDirec();
					aux.setDirec(aux.getDirec().getDirec());
					eliminado.setDirec(null);
					resp = true;
				}
			}
		}
		return resp;
	}
	
	public boolean eliminaAnterior(T dato) {
		boolean resp = false;
		if(!this.estaVacia())
			if(!primero.getDato().equals(dato)) {
				Nodo<T> preaux = null, aux = primero;
				while(aux.getDirec() != null && !aux.getDirec().getDato().equals(dato)) {
					preaux = aux;
					aux = aux.getDirec();
				}
				if(aux.getDirec() != null) {
					resp = true;
					if(preaux == null)
						primero = aux.getDirec();
					else
						preaux.setDirec(aux.getDirec());
					aux.setDirec(null);
				}
			}
		return resp;
	}
	
	public boolean insertaAntes(T refer, T nuevo) {
		boolean resp = false;
		if(!estaVacia()) {
			Nodo<T> anterior = null, actual = primero;
			while(actual != null && !actual.getDato().equals(refer)) {
				anterior = actual;
				actual = actual.getDirec();
			}
			if(actual != null) {
				resp = true;
				Nodo<T> insertar = new Nodo<T>(nuevo);
				insertar.setDirec(actual);
				if(anterior != null) {
					anterior.setDirec(insertar);
				} else {
					primero = insertar;
				}
			}
		}
		return resp;
	}
	
	public int eliminaTodosRepetidosOrdenado() {
		int resp = 0;
		if(!estaVacia()) {
			Nodo<T> aux = primero, deleted;
			while(aux.getDirec() != null) {
				if(aux.getDato().equals(aux.getDirec().getDato())) {
					deleted = aux.getDirec();
					aux.setDirec(aux.getDirec().getDirec());
					deleted.setDirec(null);
					resp++;
				} else {
					aux = aux.getDirec();	
				}
			}
		}
		return resp;
	}
	
	private boolean contiene(Nodo<T> list, T element) {
		boolean resp = false;
		if(list != null) {
			Nodo<T> aux = list;
			while(aux.getDirec() != null && !resp) {
				resp = aux.getDato().equals(element);
				aux = aux.getDirec();
			}
			if(aux.getDirec() == null) {
				resp = aux.getDato().equals(element);
			}
		}
		return resp;
	}
	
	public int eliminaTodosRepetidosDesordenado() {
		int resp = 0;
		if(!estaVacia()) {
			Nodo<T> preaux = null, aux = primero, deleted;
			while(aux.getDirec() != null) {
				if(contiene(aux.getDirec(), aux.getDato())) {
					resp++;
					if(preaux == null) {
						deleted = aux;
						aux = aux.getDirec();
						deleted.setDirec(null);
						primero = aux;
					} else {
						deleted = aux;
						aux = aux.getDirec();
						preaux.setDirec(aux);
						deleted.setDirec(null);
					}
				} else {
					preaux = aux;
					aux = aux.getDirec();
				}
			}
		}
		return resp;
	}
	
	public void combine(EE<T> other) {
		if(other == null) {
			throw new RuntimeException("Other cannot be null");
		}
		if(!other.estaVacia()) {
			Iterator<T> it = other.iterator();
			Nodo<T> aux = primero, newElement, nextTo;
			while(it.hasNext()) {
				newElement = new Nodo<T>(it.next());
				if(estaVacia()) {
					primero = newElement;
					aux = primero;
				} else {
					nextTo = aux.getDirec();
					if(nextTo != null) {
						aux.setDirec(newElement);
						newElement.setDirec(nextTo);	
						aux = nextTo;
					} else {
						aux.setDirec(newElement);
						aux = aux.getDirec();
					}
				}
			}
		}
	}
	
	public void combineNN(EE<T> other) {
		if(other == null) {
			throw new RuntimeException("Other cannot be null");
		}
		if(!other.estaVacia()) {
			boolean resp = false;
			Nodo<T> aux = primero, nextTo, auxOther, otherList = other.getPrimero();
			while(otherList != null && !resp) {
				if(estaVacia()) {
					primero = otherList;
					resp = true;
				} else {
					nextTo = aux.getDirec();
					if(nextTo != null) {
						auxOther = otherList;
						otherList = otherList.getDirec();
						aux.setDirec(auxOther);
						auxOther.setDirec(nextTo);
						aux = nextTo;
					} else {
						aux.setDirec(otherList);
						resp = true;
					}
				}
			}
		}
	}
	
	
	public T consultaPorPosicion(int n) {
		T resp = null;
		int i = 1;
		if(!estaVacia()) {
			Nodo<T> aux = primero;
			while(aux.getDirec()!=null && resp == null) {
				if(i == n) {
					resp = aux.getDato();
				}
				i++;
				aux = aux.getDirec();
			}
		}
		return resp;
	}
	
	public boolean equals(Object obj) {
		boolean resp = false;
		if(obj instanceof EE) {
			EE<?> ee = (EE<?>)obj;
			Iterator<?> it = ee.iterator();
			if(!estaVacia()) {
				Nodo<T> aux = primero;
				while(it.hasNext() && aux.getDirec()!=null && resp) {
					resp = aux.getDato().equals(it.next());
					aux = aux.getDirec();
				}
				if((it.hasNext() || aux.getDirec() != null) && resp) {
					resp = false;
				}
			} else {
				resp = !it.hasNext();
			}
		}	
		return resp;
	}
	
	public Nodo<T> getPrimero(){
		return primero;
	}

	@Override
	public Iterator<T> iterator() {
		return new IteradorEE<T>(primero);
	}
}
