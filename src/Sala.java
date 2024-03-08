import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

public class Sala {
    public String nombre;
    public String codSala;
    public ArrayList reservas;

    public Sala(String nombre,String codSala){
        this.nombre = nombre;
        this.codSala=codSala;
        reservas = new ArrayList();
    }

    public void reservar(String nombreSala, LocalDateTime fecha, Duration duracion,String nombreDepReservador){
        Reserva r1 = new Reserva(nombreSala,fecha,duracion,nombreDepReservador);
        Sala s1 = Administrador.buscarSalaID(nombreSala);
        if (!buscarResIgualTrue(nombreSala,fecha)) {
            s1.reservas.add(r1);
        }else{
            System.out.println("Ya hay una reserva esa hora");
            System.out.println("Proxima reserva disponible dentro de: " + duracion);
        }
    }

    public void listarReservas() {
        System.out.println("Reservas de la sala " + nombre + ":");
        if (reservas!=null) {
            Iterator iterator = reservas.iterator();
            while (iterator.hasNext()) {
                Reserva r1 = (Reserva) iterator.next();
                if (r1 != null) {
                    System.out.println(r1);
                }
            }
        }
    }

    public boolean buscarResIgualTrue(String nombreSala, LocalDateTime fecha) {
        boolean esigual = Administrador.buscarSalaTrue(nombreSala);
        if (esigual == true && reservas!=null) {
            Iterator iterator = reservas.iterator();
            while (iterator.hasNext()) {
                Reserva r1 = (Reserva) iterator.next();
                if (r1.getNombreSala().equalsIgnoreCase(nombreSala) && r1.getFechaReserva().equals(fecha)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        String sala = "Sala: " + nombre+":"+codSala;
        return sala;
    }
    public static boolean compararSiEstaFechaTrue(String nombreSala,LocalDateTime fechaReserva){
        Sala s1 = Administrador.buscarSalaID(nombreSala);
        if (s1.reservas!=null) {
            Iterator iterator = s1.reservas.iterator();
            while (iterator.hasNext()) {
                Reserva r2 = (Reserva) iterator.next();
                //Si la fecha de reserva  esta despues de la fecha reservada de r2
                //Y la fecha reservada   esta antes que la fecha reservada mas su duracion de r2
                if (fechaReserva.isAfter(r2.getFechaReserva()) && fechaReserva.isBefore(r2.getFechaReserva().plus(r2.getDuracion()))) {
                    return true;
                }
            }
        }
        return false;
        }

}
