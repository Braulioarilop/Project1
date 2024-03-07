import java.time.Duration;
        import java.time.LocalDateTime;
        import java.util.ArrayList;
        import java.util.List;

public class Sala {
    private String nombre;
    private final List<Reserva> listaReservas;

    public Sala(String nombre) {
        this.nombre = nombre;
        this.listaReservas = new ArrayList<>();
    }

    public void reservar(String nombreSala, LocalDateTime fecha, Duration duracion) {
        Reserva reserva = new Reserva(nombreSala, fecha, duracion);
        listaReservas.add(reserva);
        System.out.println("Realizo la reserva  en la sala " + nombreSala + " para el " + fecha + " durante " + duracion.toHours() + " horas ");
    }

    public void cancelar(String nombreSala, LocalDateTime fecha) {
        listaReservas.removeIf(reserva -> reserva.getNombreSala().equals(nombreSala) && reserva.getFecha().equals(fecha));
        System.out.println("Reserva cancelada en la sala " + nombreSala + " para el " + fecha + ".");
    }

    public void listarReservas() {
        System.out.println("Reservas de la sala " + nombre + ":");
        for (Reserva reserva : listaReservas) {
            System.out.println(reserva);
        }
    }

    public static void main(String[] args) {
        Sala sala = new Sala("Sala de reuniones");
        sala.reservar("Sala de reuniones", LocalDateTime.now(), Duration.ofHours(2));
        sala.listarReservas();
        sala.cancelar("Sala de reuniones", LocalDateTime.now());
        sala.listarReservas();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

