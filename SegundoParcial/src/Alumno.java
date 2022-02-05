import java.util.Objects;

/**
 *
 * @author sguardati
 */
public class Alumno {
    private String nombre, carrera;
    private double promedio;
    
    public Alumno(String nombre, String carrera, double promedio) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.promedio = promedio;
    }

    public Alumno() {
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " estudia: " + carrera + "\nPromedio: " + promedio;
    }

    public double getPromedio() {
        return promedio;
    }

    public String getNombre() {
        return nombre;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    
}