

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

/**
 *
 * @author eliascamacho, Sergio Pereo
 */
public class Calculator {
	public Calculator() {

	}

	/**
	 * Con una operación dada en notación infija, la agarra y la convierte a posfija para despues evaluarla
	 * @param infija operación en notacion infija
	 * @see convertir, evaluarPosfija
	 * @return 
	 */ 

	public static double resultado (String infija) {

		ArrayList<String> posfija = convierteAPosfija(infija);
		return resuelvePosfija(posfija);
	}

	/**
	 * 
	 * @param infija String de la operacion infija
	 * @return posfija array con la operacion en formato posfijo
	 */ 
	private static  ArrayList<String> convierteAPosfija (String infija) { 
		ArrayList<String> posfija = new ArrayList<String>(); 
		ArrayList<String> l = new ArrayList();
		String dig = "";
		PilaA  pila = new PilaA();

		for (int i = 0; i < infija.length(); i++) {
			String digitos = "" +infija.charAt(i);
			if(digitos.equals("0")||digitos.equals("1")||digitos.equals("2")||digitos.equals("3")||digitos.equals("4")
					||digitos.equals("5")||digitos.equals("6")||digitos.equals("7")
					||digitos.equals("8")||digitos.equals("9")||digitos.equals(".")){


				dig += digitos;

			} else if (esOperador(digitos)) { 
				l.add(dig);
				l.add(digitos);
				dig = "";
			}
		}

		l.add(dig);   

		for (int i = 0; i < l.size(); i++) {  
			dig = l.get(i);

			if (esOperador(dig)) {  

				if (pila.isEmpty()) {

					pila.push(dig);
				} else {

					int priorOp = prioridadOp(dig);
					int priorPi = prioridadPi((String) pila.peek());

					if (priorOp > priorPi) { 

						pila.push(dig); 

					} else {
						if (dig.equals(")")) {

							while (!pila.peek().equals("(")) {
								posfija.add((String) pila.pop());
							}
							pila.pop();

						} else {
							posfija.add((String) pila.pop());
							pila.push(dig);
						}
					}
				}
			} else {
				posfija.add(dig);  

			}
		}

		while (!pila.isEmpty()) {
			posfija.add((String) pila.pop());
		}
		return posfija;
	}
	
	/**
	 * 
	 * @param posfija array con la operacion en formato de posfija
	 * @return posfija array con la operacion en posfija
	 */ 
	private static double resuelvePosfija(ArrayList<String> posfija) { 

		PilaA  pila = new PilaA();

		for (int i = 0; i < posfija.size(); i++) {

			if (!posfija.get(i).equals("")) { 
				String op = "" + posfija.get(i); 
				if (!esOperador(op)) { 

					double num = new Double(op + "");  
					pila.push(num); 

				} else {

					double numA = (double) pila.pop();

					double numB = (double) pila.pop();

					double numC = operacion(op, numB, numA);

					pila.push(numC);
				}
			}

		}

		return (double) pila.peek();
	}
	
	/**
	 * 
	 * @param dig String de del digito a evaluar
	 * @return regresa un booleano que indica si es operador
	 */ 

	private static boolean esOperador(String dig) {

		if (dig.equals("*") || dig.equals("/") || dig.equals("+")
				|| dig.equals("-") || dig.equals("(") || dig.equals(")")) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param operador String que contiene el operador
	 * @return regresa el valor de la prioridad del operador
	 */ 
	private static int prioridadOp(String operador) {

		if (operador.equals("*") || operador.equals("/")) {
			return 2;
		}
		if (operador.equals("+") || operador.equals("-")) {
			return 1;
		}
		if (operador.equals("(")) {
			return 5;
		}
		return 0;
	}

	private static int prioridadPi(String operador) {

		if (operador.equals("*") || operador.equals("/")) {
			return 2;
		}
		if (operador.equals("+") || operador.equals("-")) {
			return 1;
		}
		if (operador.equals("(")) {
			return 0;
		}
		return 0;
	}

	/**
	 * 
	 * @param dig String que contiene el operador
	 * @return regresa el valor de la prioridad del operador
	 */ 
	private static double operacion(String dig, double numA, double numB) {

		if (dig.equals("/")) {
			return numA / numB;
		}
		if (dig.equals("*")) {
			return numA * numB;
		}
		if (dig.equals("+")) {
			return numA + numB;
		}
		if (dig.equals("-")) {
			return numA - numB;
		}
		else
			return 0;

	}
	
	/**
	 * 
	 * @param c: caracter a validar
	 * @return true si c es *, /, +, false en caso contrar 
	 */ 
	private static boolean isOperator(char c) {
		boolean resp = true;
		switch(c) {
			case '*':
			case '/':
			case '+':
			case '-':
				break;
			default:
				resp = false;
				break;
		}
		return resp;
	}
	
	/**
	 * 
	 * @param s: string a verificar
	 * @return true si la sintaxis es correcta, false en caso contrario
	 */ 
	public static boolean verifySyntax(String s) {
		boolean resp = true;
		int i = 0;
		PilaADT<Character> pila = new PilaA<Character>();
		boolean wasOperator = false;
		boolean wasOpen = false;
		boolean wasPoint = false;
		boolean onePInNumber = false;
		while(i<s.length() && resp) {
			if(s.charAt(i)=='(') {
				if(wasPoint) resp = false;
				pila.push(s.charAt(i));
				wasOpen = true;
			} else if(s.charAt(i) == ')') {
				if(wasOperator || wasPoint) resp = false;
				try {
					pila.pop();
				} catch(Exception e) {
					resp = false;
				}
			} else if(isOperator(s.charAt(i))) {
				if(wasOperator || wasOpen || wasPoint) resp = false;
				wasOperator = true;
				onePInNumber = false;
			} else if(s.charAt(i) == '.') {
				if(wasOperator || wasPoint || onePInNumber) resp = false;
				wasPoint = true;
				onePInNumber = true;
			} else {
				wasOpen = false;
				wasOperator = false;
				wasPoint = false;
			}
			i++;
		}
		return resp && pila.isEmpty();
	}
	
	@Test
	public void testSyntax() {
		assertEquals(false, verifySyntax("(-5.2312 + 32)+(2*5)+5-123"));
		assertEquals(false, verifySyntax("(5.23.12 + 32)+(2*5)+5-123"));
		assertEquals(true, verifySyntax("(523.12 + 32)+(2*5)+5-123"));
		assertEquals(false, verifySyntax("523.12 + 32)+(2*5)+5-123"));
		assertEquals(true, verifySyntax("((523.12 + 32))+(2*5)+5-123"));
		assertEquals(false, verifySyntax("(523.12 + 32)+*(2*5)+5-123"));
		assertEquals(false, verifySyntax("(523. + 32)+*(2*5)+5-123"));
		assertEquals(false, verifySyntax("(5+)(523.12 + 32)*(2*5)+5-123"));
		assertEquals(false, verifySyntax("(5.3 + 2.) - (523.12 + 32)*(2*5)+5-123"));
		assertEquals(true, verifySyntax("(5.3 + 2.2) - (523.12 + 32)*(2*5)+5-123"));
		assertEquals(true, verifySyntax("(5+2)-(523.12 + 32)*(2*5)+5-123"));
	}
	
	@Test
	public void testCalculator() {
		assertEquals(-70.8, resultado("(5.2 + 32)+(2*5)+5-123"), 0.01);
		assertEquals(447.12, resultado("(523.12 + 32)+(2*5)+5-123"), 0.01);
		assertEquals(447.12, resultado("((523.12 + 32))+(2*5)+5-123"), 0.01);
		assertEquals(43, resultado("(5+2)+(22)*(2+5)+5-123"), 0.01);
		assertEquals(-559, resultado("(5+2)-(22+42)*(2+5)+5-123"), 0.01);
	}

}

