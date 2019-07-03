public class Urbano extends Unidad {
    private int plazas;

    public Urbano(String dominio, String marca, String modelo, String fechaIngreso, int plazas) {
        super(dominio, marca, modelo, fechaIngreso);
        setPlazas(plazas);
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    @Override
    public String toString() {
        return (super.toString() + " Numero de plazas: " + getPlazas());
    }
}
