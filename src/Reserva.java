import java.time.Duration;
import java.time.LocalDateTime;

public class Reserva {
    private String nombreSala;
    private LocalDateTime fechaReserva;
    private Duration duracionReserva;
    private String nombreDepartamentoReservador;


    public Reserva(String nombreSala, LocalDateTime fechaReserva, Duration duracionReserva, String nombreDepartamentoReservador){
        this.nombreSala = nombreSala;
        this.fechaReserva = fechaReserva;
        this.duracionReserva = duracionReserva;
        this.nombreDepartamentoReservador = nombreDepartamentoReservador;
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

    @Override
    public String toString() {
        return "Reserva{" +
                "nombreSala='" + nombreSala + '\'' +
                ", fecha=" + fechaReserva +
                ", duracion=" + duracionReserva.toHours() + " horas" +
                '}';
    }


}
