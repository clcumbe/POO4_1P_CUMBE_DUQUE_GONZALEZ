package com.proyecto;

import java.util.Scanner;

public class Administrador extends Usuario {

    // Atributos específicos de la clase Administrador
    private String cargo;  // El cargo del administrador, por ejemplo, "Analista", "Ingeniero de datos", etc.

    public Administrador(String codigo, String cedula, String nombre, String apellido, String usuario,
    String contrasena, String correo, String cargo) {
    super(codigo, cedula, nombre, apellido, usuario, contrasena, correo);  // Llamada al constructor de la clase padre
    this.cargo = cargo;  // Inicializar el atributo específico del administrador
    }

    // Getter y Setter para el cargo
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    Scanner scanner = new Scanner(System.in);

    // Sobrescribir el método menu() de la clase Usuario
    @Override
    public void mostrarMenu() {
        // Mostrar las opciones del menú para el administrador
        System.out.println("Menú Administrador:");
        System.out.println("1. Aprobar o Rechazar Reserva");
        System.out.println("2. Consultar Reservas");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        switch (opcion) {
            case 1:
                aprobarORechazarReserva();
                break;
            case 2:
                consultarReservas();
                break;
            case 3:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    // Método para aprobar o rechazar una reserva
    public void aprobarORechazarReserva() {
        System.out.print("Ingrese el código de la reserva a aprobar o rechazar: ");
        String codigoReserva = scanner.nextLine();
        System.out.print("¿Desea aprobar la reserva? (S/N): ");
        char opcion = scanner.nextLine().charAt(0);

        boolean aprobar = opcion == 'S' || opcion == 's';  // Aprobar si la opción es 'S'

        // Buscar la reserva correspondiente y aprobarla o rechazarla
        for (Reserva reserva : Main.reservas) {
            if (reserva.getCodigoReserva().equals(codigoReserva) && reserva.getCodigoUsuario().startsWith("S")) {
                // Solo las reservas de estudiantes pueden ser aprobadas o rechazadas por el administrador
                if (aprobar) {
                    reserva.setEstado("APROBADO");
                    System.out.println("Reserva " + codigoReserva + " aprobada.");
                } else {
                    reserva.setEstado("RECHAZADO");
                    System.out.println("Reserva " + codigoReserva + " rechazada.");
                }
                // Enviar notificación por email
                Notificador.enviarCorreoNotificacion(reserva);  // Llamamos al notificador
                return;
            }
        }
        System.out.println("Reserva no encontrada o no es una reserva de estudiante.");
    }

    // Método para consultar todas las reservas
    public void consultarReservas() {
        if (Main.reservas.isEmpty()) {
            System.out.println("No hay reservas registradas.");
            return;
        }

        for (Reserva reserva : Main.reservas) {
            System.out.println(reserva.toString());
        }
    }

    // Sobrescribir el método toString() para mostrar los detalles del administrador
    @Override
    public String toString() {
        return "Administrador [cargo=" + cargo + ", " + super.toString() + "]";
    }

}
