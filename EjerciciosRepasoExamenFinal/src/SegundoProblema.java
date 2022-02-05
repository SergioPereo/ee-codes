import java.util.ArrayList;
/**
 * 000199751
 * Sergio Andre Lopez Pereo
 * Clase ejecutable del segundo problema de genericos
 */
public class SegundoProblema {
	
	//Funcion main con la logica del segundo problema
	public static void main(String args[]) {
		
		//Inicializacion e instanciacion de variables
		String[][] a = {
				{"dos", "uno", "sos", "mal", "luz"},
				{"mar", "sol", "tos", "dos", "sol"},
				{"mi", "mil", "mil", "mil", "tul"},
				{"dos", "no", "pan", "pez", "por"},
				{"las", "pez", "si", "ama", "nos"}
		};
		String[][] b = {
				{"cero", "tres", "tos", "sal", "nos"},
				{"cal", "luz", "zaz", "tos", "sun"},
				{"uno", "que", "pos", "zoo", "la"},
				{"tos", "paz", "roz", "si", "voz"},
				{"los", "tres", "dos", "ala", "los"}
		};
		
		//Imprime el resultado de la funcion
		System.out.println(ManejadorMatricesGenerico.menoresDiagonales(a, b));
		
	}

}
