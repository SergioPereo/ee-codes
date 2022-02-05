package examenfinaldic2021;

public class PruebaEstructuraEnlazada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConjuntoEnlazado<Integer> ce = null;
		ConjuntoEnlazado<Integer> ce2 = new ConjuntoEnlazado<Integer>();
		

		//System.out.println(ce2.esSubconjuntoDe(ce));
		ce = new ConjuntoEnlazado<Integer>();
		//System.out.println(ce);
		System.out.println(ce.contiene(12));
		System.out.println(ce.agrega(1));
		//System.out.println(ce);
		System.out.println(ce.agrega(1));
		//System.out.println(ce);
		System.out.println(ce.agrega(5));
		System.out.println(ce.agrega(6));
		System.out.println(ce.agrega(5));
		System.out.println(ce.agrega(7));
		System.out.println(ce.agrega(12));
		//System.out.println(ce);
		System.out.println(ce.contiene(1));
		System.out.println(ce.contiene(12));
		System.out.println(ce.contiene(52));

		ce2.agrega(1);
		ce2.agrega(7);
		
		System.out.println(ce.union(ce2));
		System.out.println(ce2.esSubconjuntoDe(ce));
		

		ce2.agrega(34);
		ce2.agrega(314);
		ce2.agrega(134);
		
		System.out.println(ce.union(ce2));
		System.out.println(ce2.esSubconjuntoDe(ce));

	}

}
