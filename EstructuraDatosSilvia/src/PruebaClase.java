
public class PruebaClase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EE<Integer> e1 = new EE<Integer>();
		if(e1.estaVacia())
			System.out.println("Esta vacia");
		e1.agregaInicio(25);
		e1.agregaInicio(10);
		e1.agregaInicio(18);
		e1.agregaInicio(21);
		System.out.println("\nLuego de agregar 4 números: \n" + e1);
		System.out.println("\nElemento quitado: " + e1.quitaPrimero());
		System.out.println("\nLuego de quitar el primero: \n" + e1);
		e1.agregaFinal(105);
		System.out.println("\nLuego de agregar el 105: \n" + e1);
		System.out.println("\nElemento quitado: " + e1.quitaUltimo());
		System.out.println("\nLuego de quitar el último: \n" + e1);
		System.out.println("\nContiene el elemento 18 (iterativo)? " + e1.buscaDato(18));
		System.out.println("\nContiene el elemento 18 (recursivo)? " + e1.buscaDatoR(18));
		System.out.println("\nContiene el elemento 322 (iterativo)? " + e1.buscaDato(322));
		System.out.println("\nContiene el elemento 322 (recursivo)? " + e1.buscaDatoR(322));
		
		System.out.println("\nElemento eliminado: " + e1.quitaDato(10));
		System.out.println("\nLuego de quitar el 10:\n" + e1);
		System.out.println("\nElemento eliminado: " + e1.quitaDato(374));
		System.out.println("\nLuego de quitar el 374:\n" + e1);
	}

}
