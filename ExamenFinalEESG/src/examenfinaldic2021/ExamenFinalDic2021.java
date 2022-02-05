
package examenfinaldic2021;

/**
 *
 * @author Sergio P.
 */
public class ExamenFinalDic2021 {

	
	public static <T> int cuentaPorTipo(Nodo<T> aux, String tipo){
		int resp = 0;
		if(aux != null) {
			while(aux != null) {
				if(aux.getDato() != null) {
					if(aux.getDato() instanceof Planta) {
						Planta act = (Planta) aux.getDato();
						if(act.getTipo().equals(tipo))
							resp++;
					}
				}
				aux = aux.getDirec();
			}
		}
		return resp;
	}
    
    public static void main(String[] args) {
    	Nodo<Integer> nodoInt1 = null;
    	System.out.println(cuentaPorTipo(nodoInt1, "Verdura"));
        nodoInt1 = new Nodo<Integer>(1);
        Nodo<Integer> nodoInt2 = new Nodo<Integer>(3);
        Nodo<Integer> nodoInt3 = new Nodo<Integer>(5);
        nodoInt1.setDirec(nodoInt2);
        nodoInt2.setDirec(nodoInt3);
        
        System.out.println(cuentaPorTipo(nodoInt1, "Verdura"));
        
        Nodo<Planta> nodoPlanta1 = new Nodo<Planta>(new Planta("Melón", "Fruta"));
        Nodo<Planta> nodoPlanta2 = new Nodo<Planta>(new Planta("Sandía", "Fruta"));
        Nodo<Planta> nodoPlanta3 = new Nodo<Planta>(new Planta("Zanahoria", "Verdura"));
        nodoPlanta1.setDirec(nodoPlanta2);
        nodoPlanta2.setDirec(nodoPlanta3);
        
        System.out.println(cuentaPorTipo(nodoPlanta1, "Verdura"));
        
    }
    
}
