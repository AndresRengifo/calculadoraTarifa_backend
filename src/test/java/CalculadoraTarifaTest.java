import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

public class CalculadoraTarifaTest {

    private static Producto mouse = new Producto(1, "Mouse", 30000, 0.19);
    private static Producto teclado = new Producto(2, "Teclado", 100000, 0.19);
    private static Producto monitor = new Producto(3, "Monitor", 500000, 0.19);
    private static Cliente jaime = new Cliente("Jaime", 110532);
    private static Cliente ana = new Cliente("Ana", 130546);
    private CalculadoraTarifa calculadoraprueba;
    @Mock
    private SistemaDescuento sistemaDescuento;

    @Mock
    private TablaTarifa tablaTarifa;

    @BeforeEach
    public void setUp() throws Exception {
        initMocks(this);
        calculadoraprueba = new CalculadoraTarifa(sistemaDescuento, tablaTarifa);
    }

    @Test
    public void should_Return35700_WithCost30kandNoDiscount() throws Exception {
        given(sistemaDescuento.obtenerDescuento(jaime, mouse)).willReturn(0);
        int tarifa_final = calculadoraprueba.calcularTarifa(jaime, mouse);
        assertEquals(35700, tarifa_final);
    }

    @Test
    public void should_Return28560_WithCost30kandDiscount() throws Exception {
        given(sistemaDescuento.obtenerDescuento(ana, mouse)).willReturn((int) (mouse.getPrecio() * 0.2));
        int tarifa_final = calculadoraprueba.calcularTarifa(ana, mouse);
        assertEquals(28560, tarifa_final);
    }

    @Test
    public void should_Return119k_WithCost100kandNoDiscount() throws Exception {
        given(sistemaDescuento.obtenerDescuento(jaime, teclado)).willReturn(0);
        int tarifa_final = calculadoraprueba.calcularTarifa(jaime, teclado);
        assertEquals(119000, tarifa_final);
    }

    @Test
    public void should_Return113050_WithCost100kandDiscount() throws Exception {
        given(sistemaDescuento.obtenerDescuento(ana, teclado)).willReturn((int) (teclado.getPrecio() * 0.05));
        int tarifa_final = calculadoraprueba.calcularTarifa(ana, teclado);
        assertEquals(113050, tarifa_final);
    }

    @Test
    public void should_Return595k_WithCost500kandNoDiscount() throws Exception {
        given(sistemaDescuento.obtenerDescuento(jaime, monitor)).willReturn(0);
        int tarifa_final = calculadoraprueba.calcularTarifa(jaime, monitor);
        assertEquals(595000, tarifa_final);
    }

    @Test
    public void should_Return535500_WithCost500kandDiscount() throws Exception {
        given(sistemaDescuento.obtenerDescuento(ana, monitor)).willReturn((int) (monitor.getPrecio() * 0.1));
        int tarifa_final = calculadoraprueba.calcularTarifa(ana, monitor);
        assertEquals(535500, tarifa_final);
    }


}