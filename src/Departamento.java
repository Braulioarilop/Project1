import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Departamento {
    private static String nombre;
    public static String codigo ="123B1";
    private static String representante;

    public Departamento(String nombre, String codigo, String representante) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.representante = representante;
    }

    public static  void menuDep() {
        Scanner in = new Scanner(System.in);
        boolean logout =false;
        
        int opcionDep = 0;

        do {
            System.out.println("\nMenú del Departamento " + nombre);
            System.out.println("1. Ver información del departamento");
            System.out.println("2. Cambiar representante");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
           
            switch (opcionDep) {
                case 1:
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Código: " + codigo);
                    System.out.println("Representante: " + representante);
                    break;
                case 2:
                    System.out.print("Ingrese el nuevo representante: ");
                    in.nextLine();
                    representante = in.nextLine();
                    System.out.println("Representante cambiado con éxito a: " + representante);
                    break;
                case 3:
                    System.out.println("Saliendo del Menú del Departamento...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcionDep!=3);
        in.close();
    }

    public static void main(String[] args) {
        Departamento departamento = new Departamento("Departamento de informatica", "INF1", "Jorge Sanchez");
        departamento.menuDep();
    }

    public String getNombre() {
        return null;
    }

    public String getCodigo() {
        return null;
    }
}
