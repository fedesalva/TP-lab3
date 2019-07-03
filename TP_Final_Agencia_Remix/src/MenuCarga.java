import java.util.List;
import java.util.Scanner;

public class MenuCarga {

    Agencia agencia = new Agencia();


    public List<Empleado> cargaEmpleado (){

        String control = "s";
        Scanner scanner = new Scanner(System.in);
        int opcion;
        while (control.equals("s")) {
            System.out.println("Ingrese los datos del empleado");

            System.out.print("Ingrese Dni: ");
            int dni = scanner.nextInt();
            System.out.print("Ingrese nombre: ");
            String nombre = scanner.next();
            System.out.print("Ingrese apellido: ");
            String apellido = scanner.next();
            System.out.print("Ingrese turno: ");
            String turno = scanner.next();
            System.out.print("Ingrese teléfono: ");
            int tel = scanner.nextInt();
            System.out.print("Ingrese fecha de ingreso: ");
            String fechaIngreso = scanner.next();
            System.out.print("Ingrese salario base: ");
            float salarioBase = scanner.nextFloat();
            System.out.print("Ingrese jornada laboral: ");
            String jornada = scanner.next();


            System.out.println("Elija tipo de empleado a cargar: 1. Chofer - 2. Administrativo");
            opcion = scanner.nextInt();


            switch (opcion) {
                case 1:
                    //System.out.println("Ingrese porcentaje de comisión:");
                    //float porcentajeComision = scanner.nextFloat();

                    Chofer chofer = new Chofer(nombre,apellido,dni,turno,jornada,salarioBase,fechaIngreso);
                    agencia.agregar(chofer);
                    break;

                case 2:
                    System.out.println("Ingrese el cargo: ");
                    String cargo = scanner.next();
                    Administrativo admin = new Administrativo(nombre,apellido,dni,turno,jornada,salarioBase,fechaIngreso,cargo);
                    agencia.agregar(admin);
                    break;


                default:
                    System.out.println("la opcion ingresada es incorrecta");
                    break;

            }



            System.out.println("Desea cargar otro empleado? s/n");
            control = scanner.next();



        }
        return agencia.getEmpleados();
    }

    public List<Cliente> cargaCliente (){

        String control = "s";
        Scanner scanner = new Scanner(System.in);
        int opcion;
        int aux[] = {0,0};
        while (control.equals("s")) {
            System.out.println("Ingrese los datos del Cliente");

            System.out.print("Ingrese Dni: ");
            int dni = scanner.nextInt();
            System.out.print("Ingrese nombre: ");
            String nombre = scanner.next();
            System.out.print("Ingrese apellido: ");
            String apellido = scanner.next();
            System.out.print("Ingrese teléfono: ");
            int tel = scanner.nextInt();
            System.out.print("Ingrese direccion\nCalle: ");
            aux[0] = scanner.nextInt();
            System.out.print("\nCalle: ");
            aux[1] = scanner.nextInt();

            Cliente cliente = new Cliente(nombre,apellido,dni,aux[0],aux[1],tel);
            agencia.agregar(cliente);

            System.out.println("Desea cargar otro cliente? s/n");
            control = scanner.next();



        }
        return agencia.getClientes();
    }

    public List<Unidad> cargaUnidad (){

        String control = "s";
        Scanner scanner = new Scanner(System.in);
        int opcion;
        while (control.equals("s")) {
            System.out.println("Ingrese los datos del vehiculo");

            System.out.print("Ingrese Dominio: ");
            String dominio = scanner.next();
            System.out.print("Ingrese marca: ");
            String marca = scanner.next();
            System.out.print("Ingrese modelo:");
            String modelo = scanner.next();
            System.out.print("Ingrese fecha de ingreso: ");
            String fechaIngreso = scanner.next();

            System.out.println("Elija tipo de unidad a cargar: 1. Urbana - 2. Rural");
            opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese cantidad de plazas: ");
                        int plazas = scanner.nextInt();

                        Unidad coche = new Urbano(dominio,marca,modelo,fechaIngreso,plazas);
                        agencia.agregar(coche);
                        break;

                    case 2:
                        System.out.println("Ingrese si es de transporte de carga S / N");
                        String carga = scanner.next();
                        Unidad cocheRural = new Rural(dominio,marca,modelo,fechaIngreso,carga.equals("s"));
                        agencia.agregar(cocheRural);
                        break;


                    default:
                        System.out.println("la opcion ingresada es incorrecta");
                        break;

                }



            System.out.println("Desea cargar otra unidad? s/n");
            control = scanner.next();



        }
        return agencia.getUnidades();
    }

    public void cargarViaje (){

    }
}
