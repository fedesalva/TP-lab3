public class Rural extends Unidad {

    private boolean transporteCarga;

    public Rural(String dominio, String marca, String modelo, String fechaIngreso,boolean transporteCarga) {
        super(dominio, marca, modelo, fechaIngreso);
        setTransporteCarga(transporteCarga);
    }

    public boolean isTransporteCarga() {
        return transporteCarga;
    }

    public void setTransporteCarga(boolean transporteCarga) {
        this.transporteCarga = transporteCarga;
    }
}
