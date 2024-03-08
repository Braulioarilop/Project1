import java.util.Scanner;
public class Departamento {
    private String nombre;
    private String codigo;
    private String representante;

    public Departamento(String nombre, String codigo, String representante) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.representante = representante;
    }

    public void menuDep() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        boolean logout =false;
        String opcionDep;
        do {
            System.out.println("\n Menú del Departamento " + nombre);
            System.out.println("1. Ver información del departamento");
            System.out.println("2. Cambiar representante");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Código: " + codigo);
                    System.out.println("Representante: " + representante);
                    break;
                case 2:
                    System.out.print("Ingrese el nuevo representante: ");
                    scanner.nextLine(); // Limpiar el buffer del scanner
                    representante = scanner.nextLine();
                    System.out.println("Representante cambiado con éxito a: " + representante);
                    break;
                case 3:
                    System.out.println("Saliendo del Menú del Departamento...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 3);
    }


    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        String DepartaCom = "Nombre de departamento: "+ nombre +
                            "\n Codigo de departamento: "+ codigo +
                            "\n Representante: " + representante;
        return DepartaCom;
    }
}
