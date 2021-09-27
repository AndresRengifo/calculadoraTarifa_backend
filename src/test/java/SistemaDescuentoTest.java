import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SistemaDescuentoTest {

    private static Producto mouse = new Producto(1, "Mouse", 30000, 0.19);
    private static Producto teclado = new Producto(2, "Teclado", 100000, 0.19);
    private static Producto monitor = new Producto(3, "Monitor", 500000, 0.19);
    private static Cliente jaime = new Cliente("Jaime", 110532);
    private static Cliente ana = new Cliente("Ana", 130546);
    private SistemaDescuento sistemaDescuento;

    @BeforeEach
    public void setUp() throws Exception {
        sistemaDescuento = new SistemaDescuento();
    }


    @Test
    public void should_Return0_WithCost30kandNoDiscount() throws Exception {
        int descuento = sistemaDescuento.obtenerDescuento(jaime, mouse);
        assertEquals(0, descuento);
    }

    @Test
    public void should_Return_WithCost30kandDiscount() throws Exception {
        int descuento = sistemaDescuento.obtenerDescuento(ana, mouse);
        assertEquals(6000, descuento);
    }

}