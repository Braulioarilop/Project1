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
            System.out.println("3. \t Crear nueva sala");
            System.out.println("4. \t Eliminar sala");
            System.out.println("5. \t Añdir Departamento");
            System.out.println("6. \t Cerrar sesion");
            opcionAdmin = in.nextLine();
            switch(opcionAdmin){
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
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
    public void AnadirDep(String nombre, String codigo, String representante){
        Departamento d1 = new Departamento(nombre,codigo,representante);
        departamentos.add(d1);
    }
    public void EliminarDep(String nombre){
        departamentos.remove(nombre);
    }
    public void ListarDep(){
        for (Object o : departamentos) {
            System.out.println(o);
        }
    }
    public static int buscar(String nombre) {
        Iterator iterador;
        if (iterador)
        return departamentos.indexOf(d1.getNombre());
    }
}


