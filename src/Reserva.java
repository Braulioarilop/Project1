import java.time.Duration;
import java.time.LocalDateTime;

class Reserva {
    private String nombreSala;
    private LocalDateTime fecha;
    private Duration duracion;

    public Reserva(String nombreSala, LocalDateTime fecha, Duration duracion) {
        this.nombreSala = nombreSala;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Duration getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "nombreSala='" + nombreSala + '\'' +
                ", fecha=" + fecha +
                ", duracion=" + duracion.toHours() + " horas" +
                '}';
    }
}
