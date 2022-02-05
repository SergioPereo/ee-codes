
/**
 *
 * @author S Guardati
 */
public class ColaA <T> implements ColaADT<T>{
    private T[] pendientes;
    private int inicio;
    private int fin;
    private final int MAX = 20;

    public ColaA() {
        pendientes = (T[]) new Object[MAX];
        inicio = -1;  // Indica cola vacía
        fin = -1;
    }
    
    public ColaA(int maximo) {
        pendientes = (T[]) new Object[maximo];
        inicio = -1;  // Indica cola vacía
        fin = -1;
    }
    
    public boolean estaVacia(){
        return inicio == -1;
    }
    
    public T consultaPrimero(){
        if (estaVacia())
            throw new RuntimeException("No hay datos en la cola");
        return pendientes[inicio];
    }
    
    private boolean estaLlena(){
        return inicio == 0 && fin == pendientes.length - 1 || fin + 1 == inicio;
    }
    
    private void expande(){
        T[] masGrande = (T[]) new Object[pendientes.length * 2];
        int n = pendientes.length;
        
        for (int i = 0; i < n; i++)
            masGrande[i] = pendientes[(inicio + i) % n];
        inicio = 0;
        fin = n - 1;
        pendientes = masGrande;        
    }
    
    public void agrega(T nuevo){
        if (this.estaLlena())
            expande();
        fin = (fin + 1) % pendientes.length;
        pendientes[fin] = nuevo;
        if (inicio == -1)   // La cola estaba vacía
            inicio = 0;
    }
    
    public T quita(){
        if (this.estaVacia())
            throw new RuntimeException("No hay datos en la cola");
        T eliminado = pendientes[inicio];
        pendientes[inicio] = null;
        if (inicio == fin){  // Había 1 solo elemento
            inicio = -1;    // Indican que la cola qudó vacía
            fin = -1;
        }
        else
            inicio = (inicio + 1) % pendientes.length;        
        return eliminado;
    }
    
    public String toString(){
        StringBuilder sB = new StringBuilder();
        
        if (!this.estaVacia()){
            int distancia, n, indice;
            
            distancia = fin - inicio;
            n = pendientes.length;
            if (distancia < 0)
                distancia += n;
            for (int i = 0; i <= distancia; i++){
                indice = (inicio + i) % n;
                sB.append(pendientes[indice]).append(" ");
            }                
        }
        return sB.toString();
    }
    
}
