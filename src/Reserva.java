import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("EEEE, 'dia ' dd ' de ' MMMM ' de ' yyyy ' a las ' hh:mm");
        return
                "Reserva:\n\tFecha reservada: " + fechaReserva.format(f1) + "." +
                "\n\tDuracion: " + duracionReserva.toHours() + " hora/s" +
                "\n\tDepartamento que reservó: " + codDepReservador.toUpperCase();
    }


}
