package servicio;

import modelo.Evento;
import modelo.Cliente;
import java.util.List;
import java.util.ArrayList;

public class GestorEventos {
    private final List<Evento> eventos = new ArrayList<>();
    private final List<Cliente> clientes = new ArrayList<>();

    public void agregarEvento(Evento evento) {
        eventos.add(evento);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Evento buscarEvento(int id) {
        for(Evento e : eventos) {
            if(e.getId() == id) return e;
        }
        return null;
    }

    public Cliente buscarCliente(int id) {
        for(Cliente c : clientes) {
            if(c.getId() == id) return c;
        }
        return null;
    }

    public void listarEventos() {
        System.out.println("Lista de eventos:");
        for(Evento e : eventos) {
            System.out.println(e);
        }
    }
}
