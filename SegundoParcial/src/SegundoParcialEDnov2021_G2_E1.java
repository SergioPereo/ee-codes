
/**
 *
 * @author S Pereo
 */
public class SegundoParcialEDnov2021_G2_E1 {
	
	public static <T>  boolean analizaCola(ColaADT<T> cola) {
		boolean resp = true;
		T dato = null;
		if(cola.estaVacia()) {
			throw new RuntimeException("La cola esta vacia");
		}
		ColaADT<T> aux = new ColaA<T>();
		while(!cola.estaVacia() && resp) {
			if(dato == null) {
				dato = cola.quita();
			} else {
				if(dato.equals(cola.consultaPrimero())) {
					resp = false;
				}
				aux.agrega(dato);
				dato = null;
			}
		}
		while(!cola.estaVacia()) {
			aux.agrega(cola.quita());
		}
		if(dato != null) {
			aux.agrega(dato);
		}
		while(!aux.estaVacia()) {
			cola.agrega(aux.quita());
		}
		return resp;
	}

    
    public static void main(String[] args) {
    	
    	ColaADT<Integer> cola = new ColaA<Integer>();

    	//Sin elementos, esto arroja una excepcion
    	//System.out.println(analizaCola(cola));
    	//System.out.println(cola.toString());
    	
    	cola.agrega(1);
    	cola.agrega(3);
    	cola.agrega(2);

    	//Sin elementos repetidos
    	System.out.println(analizaCola(cola));
    	System.out.println(cola.toString());
    	
    	cola.agrega(2);
    	cola.agrega(5);
    	
    	//Con elementos repetidos
    	System.out.println(analizaCola(cola));
    	System.out.println(cola.toString());
    	
        
    }
    
}
