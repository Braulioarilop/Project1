import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collection;
public class Administrador {
    public static final String contraseña = "1234A";
    public static ArrayList departamentos = new ArrayList();

    public static void menuadmin(){
        Scanner in = new Scanner(System.in);
        boolean logout=false;
        String opcionAdmin;
        do{
            System.out.println("Acceso: Administrador");
            System.out.println("1. \t Añdir Departamento");
            System.out.println("2. \t Eliminar Departamento");
            System.out.println("3. \t Listar Departamentos");
            System.out.println("4. \t Crear nueva sala");
            System.out.println("5. \t Eliminar sala");
            System.out.println("6. \t Añdir Departamento");
            System.out.println("7. \t Cerrar sesion");
            opcionAdmin = in.nextLine();
            switch(opcionAdmin){
                case "1":
                    String nombre;
                    String codigo;
                    String represent;
                    System.out.println("Creacion de departamento");
                    System.out.println("Nombre de departamento");
                    nombre= in.nextLine();
                    System.out.println("Codigo de departamento");
                    codigo = in.nextLine();
                    System.out.println("Representante de departamento");
                    represent = in.nextLine();
                    anadirDep(nombre,codigo,represent);
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
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    System.out.println("Cerrando sesion...");
                    logout=true;
                    break;
                default:
                    System.out.println("Opcion de administrador no correcta \n Introduzca una opcion valida");
                    break;
            }
        }while(!logout);
        in.close();
    }
    public static void anadirDep(String nombre, String codigo, String representante){
        Departamento d1 = new Departamento(nombre,codigo,representante);
        departamentos.add(d1);
    }
    public static void eliminarDep(String nombre){
        departamentos.remove();

    }
    public static void listarDep(){
        for (Object o : departamentos) {
            System.out.println(o);
        }
    }
    public static Departamento buscar(String codigo) {
        Iterator iterador = departamentos.iterator();
        boolean esIgual=false;
        do {
            Departamento d1 =(Departamento) iterador.next();
            if (d1.getCodigo().equalsIgnoreCase(codigo)){
                esIgual=true;
            }
        }while(iterador.hasNext());
        return esIgual;
    }
    public static
}


