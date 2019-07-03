import java.io.Serializable;
import java.util.Objects;

public abstract class Persona implements Serializable {

    private String nombre;
    private String apellido;
    private int dni;

    public Persona(String nombre, String apellido, int dni) {

        setNombre(nombre);
        setApellido(apellido);
        setDni(dni);

    }





    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return getDni() == persona.getDni();
    }



    @Override
    public String toString() {
        return ("Nombre: " + getNombre() + " Apellido: " + " DNI: " + getDni());


    }
}
