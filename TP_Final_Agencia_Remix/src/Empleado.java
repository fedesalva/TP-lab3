public abstract class Empleado extends Persona{

    private int legajo;
    private static int contLegajo = 1000;
    private String turno;
    private String jornadaLaboral;
    private float sueldoBase;
    private String fechaIngreso;
    private boolean activo;

    public Empleado(String nombre, String apellido, int dni, String turno, String jornadaLaboral, float sueldoBase, String fechaIngreso) {
        super(nombre, apellido, dni);
        setLegajo();
        setTurno(turno);
        setJornadaLaboral(jornadaLaboral);
        setSueldoBase(sueldoBase);
        setFechaIngreso(fechaIngreso);
        setActivo(true);
    }



    private void setLegajo() {
        this.legajo = contLegajo++;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getJornadaLaboral() {
        return jornadaLaboral;
    }

    public void setJornadaLaboral(String jornadaLaboral) {
        this.jornadaLaboral = jornadaLaboral;
    }

    public float getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(float sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getLegajo(){return this.legajo;};



    @Override
    public String toString() {
        return ("Legajo: " + getLegajo() + " Turno: " + getTurno() + " JornadaLaboral: " + getJornadaLaboral() + " Sueldo Base: " + getSueldoBase() + " Fecha de Ingreeso: " +getFechaIngreso() + " Activo: " + isActivo());
    }
}
