import java.util.Iterator;

/**
 *
 * @author S Pereo
 */
public class SegundoParcialEDnov2021_G2_E2 {
	
	private static void analizaAlumnosEBPR(Iterator<Alumno> it, ConjuntoADT<Alumno> resp) {
		Alumno a;
		if(it.hasNext()) {
			a = it.next();
			if(a.getPromedio() > 8.5) {
				resp.agrega(a);
			}
			analizaAlumnosEBPR(it, resp);
		}
	}
	
	public static String analizaAlumnosEBP(ConjuntoADT<Alumno> tabletas, ConjuntoADT<Alumno> laptops, ConjuntoADT<Alumno> cuadernos) {
		ConjuntoADT<Alumno> resp = new ConjuntoA<Alumno>();
		analizaAlumnosEBPR(tabletas.iterator(), resp);
		analizaAlumnosEBPR(laptops.iterator(), resp);
		return resp.toString();
	}
	
	private static <T> boolean equals(Iterator<T> it, ConjuntoADT<T> otro) {
		if(it.hasNext()) {
			if(otro.contiene(it.next())) {
				return equals(it, otro);
			} else {
				return false;
			}
		} else {
			return true;
		}
	}
	
	public static int analizaAlumnosCYL(ConjuntoADT<Alumno> tabletas, ConjuntoADT<Alumno> laptops, ConjuntoADT<Alumno> cuadernos) {
		int resp = -1;
		if(cuadernos.getCardinalidad() != 0) {
			if(equals(cuadernos.iterator(), laptops)) {
				resp = cuadernos.getCardinalidad();
			}
		}
		return resp;
	}
	
	public static void main(String[] args) {
		
		ConjuntoADT<Alumno> tabletas = new ConjuntoA<Alumno>();
		ConjuntoADT<Alumno> laptops = new ConjuntoA<Alumno>();
		ConjuntoADT<Alumno> cuadernos = new ConjuntoA<Alumno>();
		
		//Sin alumnos
		System.out.println(analizaAlumnosEBP(tabletas, laptops, cuadernos));
		tabletas.agrega(new Alumno("Liz", "Actuaria", 8.2));
		
		//Hay alumnos pero no ocurrencias
		System.out.println(analizaAlumnosEBP(tabletas, laptops, cuadernos));
		
		tabletas.agrega(new Alumno("Fernando", "Actuaria", 8.8));
		tabletas.agrega(new Alumno("Lucas", "Ciencia de datos", 9.2));
		
		//Sin alumnos en cuadernos ni laptops
		System.out.println(analizaAlumnosCYL(tabletas, laptops, cuadernos));
		
		laptops.agrega(new Alumno("Fernando", "Actuaria", 8.8));
		laptops.agrega(new Alumno("Ricardo", "Ciencia de datos", 8.6));
		laptops.agrega(new Alumno("Enrique", "Economia", 8.2));
		
		//Hay alumnos y ocurrencias
		System.out.println(analizaAlumnosEBP(tabletas, laptops, cuadernos));
		
		//Sin alumnos en cuadernos
		System.out.println(analizaAlumnosCYL(tabletas, laptops, cuadernos));
		
		cuadernos.agrega(new Alumno("Fernando", "Actuaria", 8.8));
		cuadernos.agrega(new Alumno("Ricardo", "Ciencia de datos", 8.6));
		
		// Con alumnos en cuadernos donde laptops contiene a cuadernos y hay 2 ocurrencias
        System.out.println(analizaAlumnosCYL(tabletas, laptops, cuadernos));
        
        cuadernos.agrega(new Alumno("Felipe", "Actuaria", 7.2));
        
        // Con alumnos en cuadernos donde hay 2 ocurrencias pero laptops no contiene a cuadernos
        System.out.println(analizaAlumnosCYL(tabletas, laptops, cuadernos));
    }
}
