public class Producto {
    private int id;
    private String nombre;
    private int precio;
    private double IVA;

    public Producto(int id, String nombre, int precio, double IVA) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.IVA = IVA;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

}
