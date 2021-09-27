import java.time.LocalDateTime;

public class TablaTarifa {

    private LocalDateTime datebuffer;
    private int tarifabuffer;

    public void addTarifa(int tarifa_final, LocalDateTime now) {
        this.tarifabuffer = tarifa_final;
        this.datebuffer = now;
        //Simula guardar en Tabla
    }
}