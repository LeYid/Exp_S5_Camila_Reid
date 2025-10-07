package servicio;

public class GestorDescuentos {
    public double aplicarDescuento(double precio, double porcentaje) {
        return precio - (precio * porcentaje / 100);
    }
}
