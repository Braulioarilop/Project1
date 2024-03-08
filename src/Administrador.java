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
            System.out.println("7. \t Cerrar sesion");
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
                    eliminarDep(codigopru);
                    break;
                case "3":
                    listarDep();
                    break;
                case "4":
                    String nombresala;
                    System.out.println("Indicame el nombre de la sala");
                    nombresala = in.nextLine();
                    if (!buscarSalaTrue(nombresala)){
                        Sala s1 = new Sala(nombresala);
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
                        System.out.println("Sala ya existente");
                    }
                    break;
                case "6":
                    break;
                case "7":
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

    public static void eliminarDep(String codigo) {
        if (buscarCodDep(codigo) != null) {
            Departamento d1 = buscarCodDep(codigo);
            departamentos.remove(d1);
            System.out.println("Borrado exitoso");

        } else {
            System.out.println("No se a encontrado el departamento");
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
}


