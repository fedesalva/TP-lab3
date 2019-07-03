import File.PersistenceCollecion;

import java.util.List;

public class Main {
    public static void main(String args[]){

        try {
        //archivo
        String empleadosFile = "Empleados";
        String clientesFile = "CLientes";
        String unidadesFile = "Unidades";
        String viajesFile = "Viajes";


        Agencia agencia=new Agencia();

        //Carga
        MenuCarga menu = new MenuCarga();
        agencia.getEmpleados().addAll(menu.cargaEmpleado());
        agencia.getClientes().addAll(menu.cargaCliente());
        agencia.getUnidades().addAll(menu.cargaUnidad());




        //Carga de viajes
        Viaje viaje_1 =  new Viaje((Chofer)agencia.getEmpleados().get(0),agencia.getClientes().get(0),agencia.getUnidades().get(0));
        Viaje viaje_2 =  new Viaje((Chofer)agencia.getEmpleados().get(0),agencia.getClientes().get(0),agencia.getUnidades().get(0));
        Viaje viaje_3 =  new Viaje((Chofer)agencia.getEmpleados().get(0),agencia.getClientes().get(0),agencia.getUnidades().get(0));


        agencia.agregar(viaje_1);
        agencia.agregar(viaje_2);
        agencia.agregar(viaje_3);

        //listas

        System.out.println("----------Empleados---------");
        agencia.listarEmpleados();
        try{
            Thread.sleep(3000);
        }catch (Exception e ) { System.out.println("Thread Interrupted");}

        System.out.println("----------Viajes---------");
        agencia.listarViajes();
        try{
            Thread.sleep(3000);
        }catch (Exception e ) { System.out.println("Thread Interrupted");}

        System.out.println("----------Clientes---------");
        agencia.listarClientes();
        try{
            Thread.sleep(3000);
        }catch (Exception e ) { System.out.println("Thread Interrupted");}

        System.out.println("----------Unidades---------");
        agencia.listarUnidades();
        try{
            Thread.sleep(3000);
        }catch (Exception e ) { System.out.println("Thread Interrupted");}


        //Costos

        System.out.println("Costo viaje num - 1 : " + viaje_1.getCostoViaje());
        System.out.println("Costo viaje num - 2 : " + viaje_2.getCostoViaje());
        System.out.println("Costo viaje num - 3 : " + viaje_3.getCostoViaje());

        //recaudacion total
        agencia.calcularRecaudacion();
        System.out.println("Recaudacion de la Agencia: " + agencia.getRecaudacion());

        //Salario del chofer
        Chofer aux = ((Chofer) agencia.getEmpleados().get(0));
        aux.calcularSalario(agencia.sumarViajeChofer(aux.getLegajo()));
        System.out.println("Salario del chofer: "+aux.getSalarioFinal());
        System.out.println("Cantidad de viajes del chofer: " + aux.getCantViajes());


        //carga en archvo

             PersistenceCollecion<Empleado> empleadoPersistenceCollecion = new PersistenceCollecion<>();

            empleadoPersistenceCollecion.WriteIntoFile(agencia.getEmpleados(),empleadosFile);

        }catch (Exception e) {
            System.out.println("ERROR de programa");
        }

    }
}
