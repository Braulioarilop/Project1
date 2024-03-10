import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
public class Administrador {
    public static final String contraseña = "1234A";
    public static ArrayList departamentos = new ArrayList();
    public static ArrayList salas = new ArrayList();

    public static void menuadmin() {
        Scanner in = new Scanner(System.in);
        boolean logout = false;
        String opcionAdmin;
        do {
            System.out.println("Acceso: Administrador");
            System.out.println("1. \t Añdir Departamento");
            System.out.println("2. \t Eliminar Departamento");
            System.out.println("3. \t Listar Departamentos");
            System.out.println("4. \t Crear nueva sala");
            System.out.println("5. \t Eliminar sala");
            System.out.println("6. \t Listar Salas");
            System.out.println("7. \t Listar Reservas");
            System.out.println("8. \t Cerrar sesion");
            opcionAdmin = in.nextLine();
            switch (opcionAdmin) {
                case "1":
                    String nombre;
                    String codigo;
                    String represent;
                    System.out.println("Creacion de departamento");
                    System.out.println("Nombre de departamento");
                    nombre = in.nextLine();
                    System.out.println("Codigo de departamento");
                    codigo = in.nextLine();
                    System.out.println("Representante de departamento");
                    represent = in.nextLine();
                    anadirDep(nombre, codigo, represent);
                    break;
                case "2":
                    String codigopru;
                    System.out.println("Dime el codigo del departamento");
                    codigopru = in.nextLine();

                    if (buscarCodDep(codigopru) != null) {
                        Departamento d1 = buscarCodDep(codigopru);
                        departamentos.remove(d1);
                        System.out.println("Borrado de departamento exitoso");
                        Reserva r1;
                        Reserva r2 = null;
                        
                        ArrayList reservasAEliminar = null;
                        Iterator iteradorSalas = salas.iterator();
                        
                        while (iteradorSalas.hasNext()) {
                            Sala s1 = (Sala) iteradorSalas.next();
                            if (s1 != null) {
                                Iterator iteradorReser = s1.reservas.iterator();
                                while (iteradorReser.hasNext()){
                                    reservasAEliminar= new ArrayList();
                                    r1 = (Reserva) iteradorReser.next();
                                    if (r1!=null){
                                        if (r1.getCodDepReservador().equalsIgnoreCase(codigopru)){
                                            reservasAEliminar.add(r1);
                                        }
                                    }
                                }
                                if (reservasAEliminar!=null){
                                    s1.reservas.removeAll(reservasAEliminar);
                                }

                            }
                        }
                        System.out.println("Sus reservas se han eliminado correctamente");
                    } else {
                        System.out.println("No se a encontrado el departamento");
                    }
                    break;
                case "3":
                    listarDep();
                    break;
                case "4":
                    String nombresala;
                    String codSala;
                    System.out.println("Indicame el nombre de la sala");
                    nombresala = in.nextLine();
                    System.out.println("Indicame el codigo de la sala");
                    codSala = in.nextLine();
                    if (!buscarSalaTrue(nombresala)){
                        Sala s1 = new Sala(nombresala,codSala);
                        salas.add(s1);
                    }else{
                        System.out.println("Sala ya existente");
                    }
                    break;
                case "5":
                    String salaAEliminar;
                    System.out.println("Indicame el nombre de la sala a eliminar");
                    salaAEliminar = in.nextLine();
                    if (buscarSalaTrue(salaAEliminar)){
                        salas.remove(buscarSalaID(salaAEliminar));
                    }else{
                        System.out.println("La sala indicada no existe");
                    }
                    break;
                case "6":
                    listarSalas();
                    break;
                case "7":
                    listarSalasConReservas();
                    break;
                case "8":
                    System.out.println("Cerrando sesion...");
                    logout = true;
                    
                    break;
                default:
                    System.out.println("Opcion de administrador no correcta \n Introduzca una opcion valida");
                    break;
            }
        } while (!logout);
        //in.close();
    }

    public static void anadirDep(String nombre, String codigo, String representante) {
        if (!buscarNomDep(nombre)) {
            Departamento d1 = new Departamento(nombre, codigo, representante);
            departamentos.add(d1);
        } else {
            System.out.println("Nombre ya existente");
        }
    }

    public static void listarDep() {
        for (Object o : departamentos) {
            System.out.println(o);
        }
    }

    public static Departamento buscarCodDep(String codigo) {
        Iterator iterador = departamentos.iterator();
        while (iterador.hasNext()){
            Departamento d1 = (Departamento) iterador.next();
            if (d1.getCodigo().equalsIgnoreCase(codigo)) {
                return d1;
            }
        }
        return null;
    }

    public static boolean buscarNomDep(String nombre) {
        Iterator iterador = departamentos.iterator();
        while (iterador.hasNext()) {
            Departamento d1 = (Departamento) iterador.next();
            if (d1.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    public static boolean buscarSalaTrue(String nombre) {
        Iterator iterador = salas.iterator();
        while (iterador.hasNext()) {
            Sala s1 = (Sala) iterador.next();
            if (s1.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    public static Sala buscarSalaID(String nombre) {
        Iterator iterador = salas.iterator();
        do {
            Sala s1 = (Sala) iterador.next();
            if (s1.getNombre().equalsIgnoreCase(nombre)) {
                return s1;
            }
        } while (iterador.hasNext());
        return null;
    }

    public static void listarSalas(){
        for (Object o : salas) {
            System.out.println(o);
        }
    }
    public static void listarSalasConReservas(){
            Iterator iterator = salas.iterator();
            while (iterator.hasNext()) {
                Sala s1 = (Sala) iterator.next();
                if (s1 != null) {
                    s1.listarReservas();
                }
            }
    }
}


