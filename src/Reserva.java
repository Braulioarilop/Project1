import java.time.Duration;
import java.time.LocalDateTime;

public class Reserva {
    private String nombreSala;
    private LocalDateTime fechaReserva;
    private Duration duracionReserva;
    private String codDepReservador;


    public Reserva(String nombreSala, LocalDateTime fechaReserva, Duration duracionReserva, String codDepReservador){
        this.nombreSala = nombreSala;
        this.fechaReserva = fechaReserva;
        this.duracionReserva = duracionReserva;
        this.codDepReservador = codDepReservador;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public Duration getDuracion() {
        return duracionReserva;
    }

    public String getCodDepReservador() {
        return codDepReservador;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "nombreSala='" + nombreSala + '\'' +
                ", fecha=" + fechaReserva +
                ", duracion=" + duracionReserva.toHours() + " horas" +
                '}';
    }


}
