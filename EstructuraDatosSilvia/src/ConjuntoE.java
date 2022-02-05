import java.util.Iterator;

public class ConjuntoE<T> implements ConjuntoADT<T>{

	private Nodo<T> conjunto;
	
	public ConjuntoE() {
		
	}
	
	@Override
	public boolean agrega(T nuevo) {
		return false;
	}

	@Override
	public T quita(T dato) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contiene(T dato) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ConjuntoADT<T> union(ConjuntoADT<T> otro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConjuntoADT<T> interseccion(ConjuntoADT<T> otro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConjuntoADT<T> diferencia(ConjuntoADT<T> otro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCardinalidad() {
		// TODO Auto-generated method stub
		return 0;
	}

}
