import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Persona {
    String nombre;
    LocalDate fechaNac;
    private LocalDate ahora;
    private Period periodo;
    private DateTimeFormatter fmt;

    public int edad() {
        ahora = LocalDate.now();
        periodo = Period.between(fechaNac, ahora);
        return periodo.getYears();
    }

    public Persona(String nombre, String fechaNacimiento) {
        fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.nombre = nombre;
        this.fechaNac = LocalDate.parse(fechaNacimiento, fmt);
    }
}