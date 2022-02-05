import java.util.Iterator;

/**
 *
 * @author Guardati
 */
public class ConjuntoA <T> implements ConjuntoADT<T>{
    private T[] elementos;
    private int cardinalidad;
    private final int MAX = 50;

    public ConjuntoA() {
        elementos = (T[]) new Object[MAX];
        cardinalidad = 0;
    }
    
    public ConjuntoA(int maximo) {
        elementos = (T[]) new Object[maximo];
        cardinalidad = 0;
    }

    @Override
    public boolean agrega(T nuevo) {
        boolean resp = false;
        
        if (!contiene(nuevo)){
            resp = true;
            if (cardinalidad == elementos.length)
                expande();
            elementos[cardinalidad] = nuevo;
            cardinalidad++;
        }
        return resp;
    }
    
    private void expande(){
        T[] masGrande = (T[]) new Object[elementos.length * 2];
        
        for (int i= 0; i < cardinalidad; i++)
            masGrande[i] = elementos[i];
        elementos = masGrande;
    }
    
    private int buscaElemento(T dato, int i){
        if (i == cardinalidad)
            return -1;
        else
            if (dato.equals(elementos[i]))
                return i;
            else
                return buscaElemento(dato, i+1);
    }

    @Override
    public T quita(T dato) {
        int pos;
        
        pos = buscaElemento(dato, 0);
        if (pos < 0)
            throw new RuntimeException("Dato no encontrado");
        T eliminado = elementos[pos];
        elementos[pos] = elementos[cardinalidad - 1];
        cardinalidad--;
        return eliminado;
    }

    @Override
    public boolean contiene(T dato) {
       return buscaElemento(dato, 0) >= 0;
    }
    
    @Override
    public ConjuntoADT<T> union(ConjuntoADT<T> otro) {
        if (otro == null)
            throw new RuntimeException();
        ConjuntoADT<T> res = new ConjuntoA();
        union(res, otro.iterator());
        union(res, this.iterator());
        return res;
    }
    
    private void union(ConjuntoADT<T> res, Iterator<T> it) {
        if (it.hasNext()){
            res.agrega(it.next());
            union(res, it);
        }
    }

    @Override
    public ConjuntoADT<T> interseccion(ConjuntoADT<T> otro) {
        if (otro == null)
            throw new RuntimeException();
        ConjuntoADT<T> res = new ConjuntoA();
    
        for (int i = 0; i < cardinalidad; i++)
            if (otro.contiene(this.elementos[i]))
                res.agrega(this.elementos[i]);        
        return res;
    }
    
    @Override
    public ConjuntoADT<T> diferencia(ConjuntoADT<T> otro) {
        if (otro == null)
            throw new RuntimeException();
        ConjuntoADT<T> difer = new ConjuntoA();      
        diferencia(0, otro, difer);
        return difer;
    }
    
    private void diferencia(int i, ConjuntoADT<T> conj, ConjuntoADT<T> difer){
        if (i < cardinalidad){
            T dato = this.elementos[i];
            if (!conj.contiene(dato))
                difer.agrega(dato);
            diferencia(i + 1, conj, difer);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorArreglo(cardinalidad, elementos);
    }

    public int getCardinalidad() {
        return cardinalidad;
    }
    
    public String toString(){
        return toString(0, new StringBuilder());
    }
    
    private String toString(int i, StringBuilder sB){
        if (i == cardinalidad)
            return sB.toString();
        else {
            sB.append(elementos[i]).append("\n");
            return toString(i+1, sB);
        }
    }
    
}
