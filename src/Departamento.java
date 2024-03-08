import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;
public class Departamento {
    private String nombre;
    private String codigo;
    private String representante;
    public static String codMenuDep;

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
                    String salaAReservar;
                    LocalDateTime fechaDeReserva;
                    int mes;
                    int dia;
                    int horaR;
                    int horaD;
                    Duration durationDeReserva;
                    System.out.println("Dime la sala en la cual quieras realizar una reserva:");
                    salaAReservar = scanner.nextLine();
                    if (Administrador.buscarSalaTrue(salaAReservar)){
                        Sala s1 = Administrador.buscarSalaID(salaAReservar);

                        System.out.println("Datos de Reserva");
                        System.out.println("Mes: (Febrero = 2,etc):");
                        mes= Integer.parseInt(scanner.nextLine());
                        System.out.println("Dia: (Numerico)");
                        dia= Integer.parseInt(scanner.nextLine());
                        System.out.println("Hora: (Disponible desde las 9 hasta las 14 horas)");
                        horaR= Integer.parseInt(scanner.nextLine());
                        while (horaR<9 || horaR>14){
                            System.out.println("Hora de trabajo no disponible");
                            System.out.println("Hora: (Disponible desde las 9 hasta las 14 horas)");
                            horaR= Integer.parseInt(scanner.nextLine());
                        }

                        System.out.println("Duracion de la reserva: ");
                        horaD = Integer.parseInt(scanner.nextLine());
                        durationDeReserva = Duration.ofHours(horaD);
                        fechaDeReserva = LocalDateTime.of(2024,mes,dia,horaR,0);
                        if (!s1.buscarResIgualTrue(salaAReservar,fechaDeReserva)) {
                            s1.reservar(salaAReservar, fechaDeReserva, durationDeReserva,codMenuDep);
                        }else{
                            System.out.println("Reserva igual ya existente");
                        }
                    }else{
                        System.out.println("La sala a reservar no existe");
                    }
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


}
