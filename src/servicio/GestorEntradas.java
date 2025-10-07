package servicio;

import modelo.*;
import java.util.ArrayList;
import java.util.List;

public class GestorEntradas {
    private final List<Entrada> entradas = new ArrayList<>();
    private final GestorDescuentos gestorDescuentos;

    public GestorEntradas(GestorDescuentos gestorDescuentos) {
        this.gestorDescuentos = gestorDescuentos;
    }

    public Entrada venderEntrada(int clienteId, int eventoId, GestorEventos gestorEventos) {
        Cliente cliente = gestorEventos.buscarCliente(clienteId);
        Evento evento = gestorEventos.buscarEvento(eventoId);

        if(cliente != null && evento != null && evento.hayDisponibilidad()) {
            double precio = 10000; // precio base

            // aplicar descuento según tipo de cliente
            if(cliente.getTipoCliente().equalsIgnoreCase("Estudiante")) {
                precio = gestorDescuentos.aplicarDescuento(precio, 10);
            } else if(cliente.getTipoCliente().equalsIgnoreCase("Tercera Edad")) {
                precio = gestorDescuentos.aplicarDescuento(precio, 15);
            }

            Entrada entrada = new Entrada(entradas.size()+1, cliente, evento, precio);
            entradas.add(entrada);
            evento.venderAsiento();
            return entrada;
        }
        return null;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }
}
