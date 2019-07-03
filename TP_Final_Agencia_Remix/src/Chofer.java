public class Chofer extends Empleado {

    private int CantViajes;
    private float salarioFinal;
    private final float porcentajeComision= 0.075f;

    public Chofer(String nombre, String apellido, int dni, String turno, String jornadaLaboral, float sueldoBase, String fechaIngreso) {
        super(nombre, apellido, dni, turno, jornadaLaboral, sueldoBase, fechaIngreso);
        this.CantViajes = 0;
    }



    public int getCantViajes() {
        return CantViajes;
    }

    private void setCantViajes(int cantViajes) {
        CantViajes = cantViajes;
    }


    public float getSalarioFinal() {
        return salarioFinal;
    }

    private void setSalarioFinal(float salarioFinal) {
        this.salarioFinal = salarioFinal;
    }

    public void calcularSalario(float total){
        setSalarioFinal(getSueldoBase()+(total * porcentajeComision));
    }

    public void sumaViajes(){
        setCantViajes(getCantViajes()+1);
    }

    @Override
    public String toString() {
        String mensaje = "Nombre: %s Apellido: %s - Cantidad de viajes: %d";
        return String.format(mensaje,getNombre(),getApellido(),getCantViajes());
    }
}
