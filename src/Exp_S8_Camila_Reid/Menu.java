package Exp_S8_Camila_Reid;

import modelo.*;
import servicio.*;
import java.util.Scanner;

public class Menu {
    private static final GestorEventos gestorEventos = new GestorEventos();
    private static final GestorDescuentos gestorDescuentos = new GestorDescuentos();
    private static final GestorEntradas gestorEntradas = new GestorEntradas(gestorDescuentos);
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- Menú Teatro ---");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Crear Evento");
            System.out.println("3. Vender Entrada");
            System.out.println("4. Listar Eventos");
            System.out.println("5. Salir");
            opcion = leerInt("Seleccione una opción: ");

            switch(opcion) {
                case 1 -> registrarCliente();
                case 2 -> crearEvento();
                case 3 -> venderEntrada();
                case 4 -> listarEventos();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida, ingrese un número del 1 al 5.");
            }
        } while(opcion != 5);
    }

    private static void registrarCliente() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        String tipoCliente;
        do {
            System.out.print("Tipo de cliente (Normal, Estudiante, Tercera Edad): ");
            tipoCliente = sc.nextLine().trim();
            if(!tipoCliente.equalsIgnoreCase("Normal") &&
               !tipoCliente.equalsIgnoreCase("Estudiante") &&
               !tipoCliente.equalsIgnoreCase("Tercera Edad")) {
                System.out.println("Tipo inválido, ingrese Normal, Estudiante o Tercera Edad.");
            }
        } while(!tipoCliente.equalsIgnoreCase("Normal") &&
                !tipoCliente.equalsIgnoreCase("Estudiante") &&
                !tipoCliente.equalsIgnoreCase("Tercera Edad"));

        Cliente cliente = new Cliente(nombre, email, tipoCliente);
        gestorEventos.agregarCliente(cliente);

        System.out.println("\nCliente registrado: " + cliente);
        System.out.println("\nPresiona Enter para continuar...");
        sc.nextLine();
    }

    private static void crearEvento() {
        System.out.print("Nombre del evento: ");
        String nombre = sc.nextLine();

        int capacidad;
        do {
            capacidad = leerInt("Capacidad: ");
            if(capacidad <= 0) {
                System.out.println("La capacidad debe ser un número mayor que 0.");
            }
        } while(capacidad <= 0);

        Evento evento = new Evento(nombre, capacidad);
        gestorEventos.agregarEvento(evento);

        System.out.println("\nEvento creado: " + evento);
        System.out.println("\nPresiona Enter para continuar...");
        sc.nextLine();
    }

    private static void venderEntrada() {
        int clienteId = leerInt("ID Cliente: ");
        int eventoId = leerInt("ID Evento: ");

        Entrada entrada = gestorEntradas.venderEntrada(clienteId, eventoId, gestorEventos);
        if (entrada != null) {
            System.out.println("\nEntrada vendida: " + entrada);
        } else {
            System.out.println("\nNo se pudo vender la entrada. Verifique IDs o disponibilidad.");
        }
        System.out.println("\nPresiona Enter para continuar...");
        sc.nextLine();
    }

    private static void listarEventos() {
        gestorEventos.listarEventos();
        System.out.println("\nPresiona Enter para continuar...");
        sc.nextLine();
    }

    private static int leerInt(String mensaje) {
        int numero = -1;
        boolean valido = false;
        do {
            System.out.print(mensaje);
            String entrada = sc.nextLine();
            try {
                numero = Integer.parseInt(entrada);
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número válido.");
            }
        } while(!valido);
        return numero;
    }
}
