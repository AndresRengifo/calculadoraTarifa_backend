import java.time.LocalDateTime;

public class CalculadoraTarifa {

    private SistemaDescuento sistDescuento;
    private TablaTarifa tablaTarifa;

    public CalculadoraTarifa(SistemaDescuento sistDescuento, TablaTarifa tablaTarifa) {
        this.sistDescuento = sistDescuento;
        this.tablaTarifa = tablaTarifa;
    }

    public int calcularTarifa(Cliente clienteCompra, Producto productoCompra) {
        int tarifa_final = 0;
        int descuento = sistDescuento.obtenerDescuento(clienteCompra, productoCompra);
        if (descuento > 0) {
            tarifa_final = tarifa_final + (productoCompra.getPrecio() - descuento);
        } else {
            tarifa_final = tarifa_final + productoCompra.getPrecio();
        }

        tarifa_final = (int) (tarifa_final * (1 + productoCompra.getIVA()));

        tablaTarifa.addTarifa(tarifa_final, LocalDateTime.now());

        return tarifa_final;
    }

}

