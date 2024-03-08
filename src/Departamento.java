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

    public static void menuDep() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        boolean logout =false;
        String opcionDep;
        do {
            System.out.println("\n Menú del Departamento");
            System.out.println("1. Añadir reserva");
            System.out.println("2. Cancelar reserva");
            System.out.println("3. Listar todas las reservas");
            System.out.println("4. Cerrar sesion");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    logout=true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (!logout);
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

    public void listarSalasConReservas(){
        Administrador.listarSalas();
    }
}
