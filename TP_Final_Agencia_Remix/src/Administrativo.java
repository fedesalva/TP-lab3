public class Administrativo extends Empleado {
    private String cargo;

    public Administrativo(String nombre, String apellido, int dni, String turno, String jornadaLaboral, float sueldoBase, String fechaIngreso, String cargo) {
        super(nombre, apellido, dni, turno, jornadaLaboral, sueldoBase, fechaIngreso);
        setCargo(cargo);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return (super.toString() + " Cargo: " + getCargo());
    }
}
