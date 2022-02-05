import java.util.ArrayList;
/**
 * 000199751
 * Sergio Andre Lopez Pereo
 * Clase ejecutable del primer problema de genericos
 */
public class PrimerProblema {
	
	public static <T> boolean contiene(ArrayList<String> arr, T obj) {
		for(int i = 0 ; i < arr.size() ; i++) {
			if(obj.toString().equals(arr.get(i))) {
				return true;
			}
		}
		return false;
	}
	
	//Funcion para sacar el array interseccion
	public static <T> ArrayList<String> interseccionArrays(ArrayList<T> arrayA, ArrayList<T> arrayB) {
		int i = 0, j = 0, aN = 0, bN = 0;
		ArrayList<String> resultado;
		resultado = new ArrayList<String>();
		aN = arrayA.size();
		bN = arrayB.size();
		for(i = aN-1 ; i >= 0 ; i--) {
			for(j = bN-1 ; j >= 0 ; j--) {
				if(arrayA.get(i).equals(arrayB.get(j))) {
					if(!contiene(resultado, arrayA.get(i))) {
						resultado.add(arrayA.get(i).toString());
					}
				}
			}
		}
		
		return resultado;
	}
	
	//Funcion main con la logica del primer problema
	public static void main(String args[]) {
		//Inicializacion de variables
		ArrayList<String> a;
		ArrayList<String> b;
		ArrayList<String> interseccion;
		
		//Instanciacion de variables
		a = new ArrayList<String>();
		b = new ArrayList<String>();
		interseccion = new ArrayList<String>();
		
		//Se agregan los campos de los arrays de prueba
		a.add("Alma");
		a.add("Carlos");
		a.add("Georgina");
		a.add("Pedro");
		a.add("Renata");
		a.add("Sebastian");
		a.add("Pilar");
		
		b.add("Regina");
		b.add("Carmen");
		b.add("Gregorio");
		b.add("Alma");
		b.add("Patricia");
		b.add("Max");
		
		//Se realiza la interseccion y se imprime
		interseccion = interseccionArrays(a, b);
		System.out.println(interseccion.toString());
		
	}

}
