
public class Nodo<T> {
	private T dato;
	  private Nodo<T> direc;
	  public Nodo(){

	  }
	  public Nodo(T dato){
	    this.dato = dato;
	    this.direc = null;
	  }
	public T getDato() {
		return dato;
	}
	public void setDato(T dato) {
		this.dato = dato;
	}
	public Nodo<T> getDirec() {
		return direc;
	}
	public void setDirec(Nodo<T> direc) {
		this.direc = direc;
	}
}
