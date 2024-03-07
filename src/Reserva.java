import java.time.Duration;
import java.time.LocalDateTime;

public class Reserva {
    private String nombreSala;
    private LocalDateTime fechaReserva;
    private Duration duracionReserva;


    public Reserva(String nombreSala, LocalDateTime fechaReserva, Duration duracionReserva){
        this.nombreSala = nombreSala;
        this.fechaReserva = fechaReserva;
        this.duracionReserva = duracionReserva;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public String getNombreSala() {
        return nombreSala;
    }
}
