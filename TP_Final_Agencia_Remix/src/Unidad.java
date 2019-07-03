import java.io.Serializable;

public abstract class Unidad implements Serializable {
    private int id;
    private String dominio;
    private String marca;
    private String modelo;
    private String fechaIngreso;
    private boolean activo;
    private static int idCont=0;

    public Unidad(String dominio, String marca, String modelo, String fechaIngreso) {
        this.id = getIdCont();
        setDominio(dominio);
        setMarca(marca);
        setModelo(modelo);
        setFechaIngreso(fechaIngreso);
        setActivo(true);
    }

    public int getId() {
        return id;
    }


    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
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

    private static int getIdCont() {
        idCont++;
        return idCont;
    }

    public void modificarEstado(boolean estado){
        setActivo(estado);
    }

    @Override
    public String toString() {
        return ("Dominio: " + getDominio() + "\nMarca: " + getMarca() + " Modelo: " + getModelo() + " Fecha de Ingreso: " + getFechaIngreso() + " Estado: " + isActivo());
    }
}
