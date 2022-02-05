
package examenfinaldic2021;

/**
 *
 * @author Guardati
 */
public class Planta {
    private String nombre;
    private String tipo;

    public Planta() {
    }

    public Planta(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }   

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Planta de nombre= " + nombre + ", y tipo= " + tipo;
    }
    
}
