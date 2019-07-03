public class Cliente extends Persona {

    private int direccion[];
    private long numTelefono;
    private int id;
    private static int idCont=1;

    public Cliente(String nombre, String apellido, int dni, int calle_1,int calle_2, long numTelefono) {
        super(nombre, apellido, dni);
        this.id=getIdCont();
        setDireccion(calle_1,calle_2);
        setNumTelefono(numTelefono);
    }

    private static int getIdCont() {
        idCont++;
        return idCont;
    }


    public int[] getDireccion() {
        return direccion;
    }

    public void setDireccion(int calle_1,int calle_2) {
        this.direccion = new int[] {calle_1,calle_2};
    }

    public long getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(long numTelefono) {
        this.numTelefono = numTelefono;
    }

    @Override
    public String toString() {
        return (super.toString() + " Direccion -  Calle: " +getDireccion()[0]+" y Calle: "+getDireccion()[1] + " Telefono: " + getNumTelefono());
    }


}
