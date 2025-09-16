

package Exp_S5_Camila_Reid.modelo;


public class Entrada {
   
    private final int numero;
    private final String ubicacion;
    private final double precioFinal;
    private final String tipoCliente; // estudiante, tercera edad, general

    
    // Constructor
    public Entrada(int numero, String ubicacion, double precioFinal, String tipoCliente) {
        this.numero = numero;
        this.ubicacion = ubicacion;
        this.precioFinal = precioFinal;
        this.tipoCliente = tipoCliente;
        
}

    // Getters
    public int getNumero() {
        return numero;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public double getPrecioFinal() {
        return precioFinal;
    }
    public String getTipoCliente() {
        return tipoCliente;
    }
    
}