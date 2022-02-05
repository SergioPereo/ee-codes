
public class Encuesta {
	
	private ConjuntoADT<Alumno> tabletas;
	private ConjuntoADT<Alumno> laptops;
	private ConjuntoADT<Alumno> cuadernos;
	
	public Encuesta() {
		this.tabletas = new ConjuntoA<Alumno>();
		this.laptops = new ConjuntoA<Alumno>();
		this.cuadernos = new ConjuntoA<Alumno>();
	}
	
	
	//0 - tabletas, 1 - laptop, 2 - cuadernos
	public void agregaAlumno(Alumno a, int apuntes) {
		if(apuntes == 0) {
			tabletas.agrega(a);
		} else if(apuntes == 1) {
			laptops.agrega(a);
		} else if(apuntes == 2) {
			cuadernos.agrega(a);
		}
	}

}
