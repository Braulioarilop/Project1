import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

public class Sala {
    public String nombre;
    public ArrayList reservas;

    public Sala(String nombre){
        this.nombre = nombre;
        ArrayList reservas = new ArrayList();
    }

    public void reservar(String nombreSala, LocalDateTime fecha, Duration duracion){
        Reserva r1 = new Reserva(nombreSala,fecha,duracion);
        if (!buscarResIgualTrue(nombreSala,fecha)) {
            reservas.add(r1);
        }else{
            System.out.println("Ya hay una reserva esa hora");
            System.out.println("Proxima reserva disponible dentro de: " + duracion);
        }
    }

    public void listarReservas() {
        System.out.println("Reservas de la sala " + nombre + ":");
        for (Object o : reservas) {
            System.out.println(o);
        }
    }

    public boolean buscarResIgualTrue(String nombreSala, LocalDateTime fecha){
        boolean esigual = Administrador.buscarSalaTrue(nombreSala);
        if (esigual==true) {
            Iterator iterator = reservas.iterator();
            while (iterator.hasNext()){
                Reserva r1 = (Reserva) iterator.next();
                if (r1.getNombreSala().equalsIgnoreCase(nombreSala) && r1.getFechaReserva().equals(fecha)){
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
        String sala = "Nombre de la sala: " + nombre;
        return sala;
    }
}
