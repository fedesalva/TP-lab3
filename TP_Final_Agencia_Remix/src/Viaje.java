import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Viaje implements Serializable {

    private int id;
    private Chofer chofer;
    private Cliente cliente;
    private Unidad unidad;
    private int origenYdestino[];
    private static int idCont=1;
    private final float precioCuadra = 15.5f;
    private float costoViaje;

    public Viaje(Chofer chofer, Cliente cliente, Unidad unidad) {
        setId();
        setChofer(chofer);
        setCliente(cliente);
        setUnidad(unidad);
        nuevoViaje();
        costoViaje();
        chofer.sumaViajes();
    }



    public int getId() {
        return id;
    }


    public Chofer getChofer() {
        return chofer;
    }

    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public float getCostoViaje() {
        return costoViaje;
    }

    private void setCostoViaje(float costoViaje) {
        this.costoViaje = costoViaje;
    }

    public void setOrigenYdestino(int [] origenYdestino) {
        this.origenYdestino = origenYdestino;
    }

    public int[] getOrigenYdestinoDestino() {
        return origenYdestino;
    }


    private void setId (){this.id  = idCont++;
    }
    private void nuevoViaje(){

        Scanner scan = new Scanner(System.in);
        int aux[] = {0,0,0,0};
        String control = "s";
        System.out.println("Origen y destino del viaje\nSu origen es calles: "+getCliente().getDireccion()[0]+" y "+getCliente().getDireccion()[1]+"\nSi / No");
        String opcion = scan.next();
        if ((opcion.equals("S") || opcion.equals("s")) && getCliente().getDireccion() != null) {
                    aux[0] = getCliente().getDireccion()[0];
                    aux[1] = getCliente().getDireccion()[1];
            } else {
            while (control.equals("s")) {
                scan = new Scanner(System.in);
                try {

                    System.out.print("Ingrese nuevo origen\nCalle: ");
                    aux[0] = scan.nextInt();
                    System.out.print("\nCalle: ");
                    aux[1] = scan.nextInt();
                    control = "n";

                } catch (InputMismatchException e) {
                    System.out.println("Solo puede ingresar numeros");
                }
            }
        }
            while (control.equals("s")) {
                scan = new Scanner(System.in);
                try {

                    System.out.print("Ingrese Destino\nCalle: ");
                    aux[2] = scan.nextInt();
                    System.out.print("\nCalle: ");
                    aux[3] = scan.nextInt();
                    control = "n";
                } catch (InputMismatchException e) {
                    System.out.println("Solo puede ingresar numeros");
                }

            }


        setOrigenYdestino(aux);

    }

    private void costoViaje(){

         setCostoViaje(calcularDistancia() * precioCuadra);

    }

    public int calcularDistancia(){
        int distancia = 0;
        if (origenYdestino != null){
            distancia = Math.abs((getOrigenYdestinoDestino()[0] - getOrigenYdestinoDestino()[2]) + (getOrigenYdestinoDestino()[1] - getOrigenYdestinoDestino()[3]));
        }

        return distancia;
    }

    @Override
    public String toString() {
        return ("Id: " + getId() + "\nChofer: " + getChofer() + "\nCliente: " + getCliente() + "\nOrigen: " + getOrigenYdestinoDestino()[0]+" y "+getOrigenYdestinoDestino()[1] + "\nDestino: " + getOrigenYdestinoDestino()[2]+" y "+getOrigenYdestinoDestino()[3] + "\nUnidad -  " + getUnidad());
    }
}
