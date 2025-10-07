package modelo;

public class Evento {
    private static int contadorId = 1; // ID independiente
    private final int id;
    private final String nombre;
    private final int capacidad;
    private int asientosVendidos;

    public Evento(String nombre, int capacidad) {
        this.id = contadorId++;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.asientosVendidos = 0;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getCapacidad() { return capacidad; }
    public int getAsientosVendidos() { return asientosVendidos; }

    public boolean hayDisponibilidad() {
        return asientosVendidos < capacidad;
    }

    public void venderAsiento() {
        if(hayDisponibilidad()) {
            asientosVendidos++;
        }
    }

    @Override
    public String toString() {
        return "\nEvento[" + id + "]: " + nombre + " | Capacidad: " + capacidad + " | Asientos vendidos: " + asientosVendidos;
    }
}
