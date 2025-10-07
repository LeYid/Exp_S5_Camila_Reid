package modelo;

public class EntradaTeatro {
    private final int numero;
    private final String ubicacion;
    private final char fila;
    private final int numAsiento;
    private final String tipoCliente;
    private final double precioFinal;

    public EntradaTeatro(int numero, String ubicacion, char fila, int numAsiento, String tipoCliente, double precioFinal) {
        this.numero = numero;
        this.ubicacion = ubicacion;
        this.fila = fila;
        this.numAsiento = numAsiento;
        this.tipoCliente = tipoCliente;
        this.precioFinal = precioFinal;
    }

    public int getNumero() { return numero; }
    public char getFila() { return fila; }
    public int getNumAsiento() { return numAsiento; }
    public String getTipoCliente() { return tipoCliente; }
    public double getPrecioFinal() { return precioFinal; }

    @Override
    public String toString() {
        String detalleDescuento = switch(tipoCliente) {
            case "Estudiante" -> "Descuento 10% por estudiante";
            case "Tercera Edad" -> "Descuento 15% por tercera edad";
            default -> "Sin descuento";
        };

        return """
                -------------------------
                      ENTRADA DE TEATRO
                -------------------------
                Número entrada: """ + numero + "\n" +
                "Ubicación: " + ubicacion + "\n" +
                "Fila: " + fila + ", Asiento: " + numAsiento + "\n" +
                "Tipo: " + tipoCliente + "\n" +
                detalleDescuento + "\n" +
                String.format("Precio Final: $%.0f", precioFinal) + "\n" +
                "-------------------------\n";
    }
}
