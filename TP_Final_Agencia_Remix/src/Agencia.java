import java.util.ArrayList;
import java.util.List;


public class Agencia implements Listados {

    private int codigoAgencia;
    private List<Empleado> empleados;
    private List<Cliente> clientes;
    private List<Viaje> viajes;
    private List<Unidad>unidades;
    private float recaudacion;
    private static int codAgenciaCont=1;

    public Agencia() {
        this.codigoAgencia = getCodAgenciaCont();
        this.empleados = new ArrayList<>();
        this.viajes = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.unidades=new ArrayList<>();
        this.recaudacion = 0;
    }

    private static int getCodAgenciaCont(){
        codAgenciaCont++;
        return codAgenciaCont;
    }

    public int getCodigoAgencia() {
        return codigoAgencia;
    }


    public List<Empleado> getEmpleados() {
        return empleados;
    }


    public List<Viaje> getViajes() {
        return viajes;
    }

    public  List<Cliente> getClientes(){return clientes;}

    public List<Unidad> getUnidades() {
        return unidades;
    }

    public double getRecaudacion() {
        return recaudacion;
    }

    private void setRecaudacion(float recaudacion) {
        this.recaudacion = recaudacion;
    }

    public void calcularRecaudacion (){
        float recaudacion=0;
        if (!getViajes().isEmpty()){
            for (Viaje viaje: viajes){
                recaudacion+=viaje.getCostoViaje();
            }
        }
        setRecaudacion(recaudacion);
    }


    @Override
    public void agregar(Object obj) {
        if (obj != null) {
            if (obj instanceof Empleado) {
                if (!buscar(obj)) {
                    getEmpleados().add((Empleado) obj);
                }

            } else {
                if (obj instanceof Viaje) {
                    if (!buscar(obj)) {
                        getViajes().add((Viaje) obj);
                    }
                } else {
                    if (obj instanceof Cliente) {
                        if (!buscar(obj)) {
                            getClientes().add((Cliente) obj);
                        }
                    }
                    else{
                        if (obj instanceof Unidad){
                            if(!buscar(obj))
                                getUnidades().add((Unidad)obj);
                        }
                    }
                }


            }
        }
    }

    @Override
    public void eliminar(Object obj) {
        int pos=-1;
        if (obj!=null){
            if(obj instanceof Cliente){
                for (Cliente cliente: clientes){
                    if(cliente.getDni()==((Cliente) obj).getDni()){
                        pos=clientes.indexOf(cliente);
                    }
                }
                if(pos!=-1)
                    clientes.remove(pos);
            }
            else{
                if (obj instanceof Unidad){
                    for (Unidad unidad: unidades){
                        if(unidad.getId()==((Unidad) obj).getId()){
                            pos=unidades.indexOf(unidad);
                        }
                    }
                    if(pos!=-1){
                        unidades.remove(pos);
                    }
                }else{
                    if(obj instanceof Viaje){
                        for(Viaje viaje: viajes){
                            if(viaje.getId()==((Viaje) obj).getId()){
                                pos=viajes.indexOf(viaje);
                            }
                        }
                        if(pos!=-1){
                            viajes.remove(pos);
                        }
                    }
                    else{
                        if(obj instanceof Empleado){
                            for(Empleado empleado: empleados){
                             if(empleado.getLegajo()==((Empleado) obj).getLegajo()){
                                 pos=empleados.indexOf(empleado);
                             }
                            }
                            if(pos!=-1){
                                empleados.remove(pos);
                            }
                        }
                    }
                }
            }
        }


    }

    @Override
    public void listarViajes() {
        if(!getViajes().isEmpty()){
            for (Viaje viaje: viajes) {
                System.out.println(viaje.toString());

            }
        }


    }

    public void listarEmpleados(){
        if(!getEmpleados().isEmpty()){
            for (Empleado empleado: empleados) {
                System.out.println(empleado.toString());

            }
        }
    }

    @Override
    public void listarClientes() {
        if(!getClientes().isEmpty()){
            for (Cliente cliente: clientes) {
                System.out.println(cliente.toString());

            }
        }
    }

    @Override
    public void listarUnidades() {
        if(!getUnidades().isEmpty()){
            for (Unidad unidad: unidades) {
                System.out.println(unidad.toString());

            }
        }
    }

    @Override
    public void modificar(Object obj) {

    }

    @Override
    public boolean buscar(Object obj) {
        boolean flag=false;
        if(obj!=null&&empleados!=null){
            if (obj instanceof Empleado){
                for (Empleado i:empleados) {
                   if(i.getDni()==(((Empleado) obj).getDni())){
                       flag=true;
                   }

                }
            }
        }
        else{
        if(obj!=null&&viajes!=null){
            if(obj instanceof Viaje){
                for (Viaje v: viajes) {
                    if(v.getId()==(((Viaje) obj).getId())){
                        flag=true;
                    }
                }

                }
            }else {
            if(obj!=null&&empleados!=null){
                if (obj instanceof Cliente){
                    for (Cliente i:clientes) {
                        if(i.getDni()==(((Cliente) obj).getDni())){
                            flag=true;
                        }

                    }
                }
                else{
                    if(obj instanceof Unidad){
                        for (Unidad unidad: unidades){
                            if(unidad.getId()==(((Unidad)obj).getId())){
                                flag=true;
                            }
                        }

                    }
                }
            }
        }
        }
        return flag;
    }

    public float sumarViajeChofer(int legajo){
        float total=0;
        if(!getViajes().isEmpty()){
            for (Viaje viaje: viajes){
                if(legajo==viaje.getChofer().getLegajo()){
                    total+=viaje.getCostoViaje();
                }

            }
    }
       return total;
    }


}

