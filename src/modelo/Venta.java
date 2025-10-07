package modelo;

public class Venta {
    private final int id;
    private final Entrada entrada;

    public Venta(int id, Entrada entrada) {
        this.id = id;
        this.entrada = entrada;
    }

    public int getId() { return id; }
    public Entrada getEntrada() { return entrada; }

    @Override
    public String toString() {
        return "Venta{id=" + id + ", entrada=" + entrada + "}";
    }
}
