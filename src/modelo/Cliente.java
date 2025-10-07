package modelo;

public class Cliente {
    private static int contadorId = 1; // ID independiente
    private final int id;
    private final String nombre;
    private final String email;
    private final String tipoCliente;

    public Cliente(String nombre, String email, String tipoCliente) {
        this.id = contadorId++;
        this.nombre = nombre;
        this.email = email;
        // normalizar tipo de cliente
        this.tipoCliente = tipoCliente.substring(0,1).toUpperCase() + tipoCliente.substring(1).toLowerCase();
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getTipoCliente() { return tipoCliente; }

    @Override
    public String toString() {
        return "\nCliente[" + id + "]: " + nombre + " | " + email + " | " + tipoCliente;
    }
}
