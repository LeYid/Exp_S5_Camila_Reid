package modelo;

public class Entrada {
    private int id;
    private Cliente cliente;
    private Evento evento;
    private double precio;

    public Entrada(int id, Cliente cliente, Evento evento, double precio) {
        this.id = id;
        this.cliente = cliente;
        this.evento = evento;
        this.precio = precio;
    }

    public int getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public Evento getEvento() { return evento; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return "\nEntrada[" + id + "]: Cliente: " + cliente.getNombre() + " | Evento: " + evento.getNombre() + " | Precio: $" + precio;
    }
}
