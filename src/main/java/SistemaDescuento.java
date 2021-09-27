import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SistemaDescuento {


    Set<Integer> discountedZIP = new HashSet<Integer>(
            Arrays.asList(
                    110521,
                    130546,
                    154789)
    );

    public int obtenerDescuento(Cliente clienteCompra, Producto productoCompra) {
        if (discountedZIP.contains(clienteCompra.getCodigoPostal())) {
            return switch (productoCompra.getId()) {
                case 1 ->
                        //20% descuento en mouse
                        (int) (productoCompra.getPrecio() * 0.2);
                case 2 ->
                        //5% descuento en teclado
                        (int) (productoCompra.getPrecio() * 0.05);
                case 3 ->
                        //10% descuento en monitor
                        (int) (productoCompra.getPrecio() * 0.1);
                default -> 1;
            };
        } else {
            return 0;
        }

    }
}