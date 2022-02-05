/**
*	Class that runs the program
* 	@author Sergio Pereo
*/

public class CalculatorStage {

	public static void main(String[] args) {
		//Inicializacion del calendario
		CalculatorController miCalculadora;
		
		//Instanciacion del calendario
		miCalculadora = new CalculatorController();
		miCalculadora.pack();
		miCalculadora.setVisible(true);
	}
	
}
