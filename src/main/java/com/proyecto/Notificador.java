package com.proyecto;

public class Notificador {

    // Método para enviar correo cuando el estudiante hace una reserva
    public static void enviarCorreoEstudiante(Reserva reserva) {
        String asunto = "Reserva realizada";
        String mensaje = "El estudiante " + reserva.getCodigoUsuario() + " ha realizado una reserva con código " +
                         reserva.getCodigoReserva() + " para la fecha " + reserva.getFechaReserva() +
                         " en la cancha " + reserva.getCodigoEspacio() + ".\n" +
                         "Ingrese al sistema para aprobar o rechazar la reserva.";

        // Aquí va la lógica para enviar el correo (simulada)
        System.out.println("Correo a Administrador:");
        System.out.println("De: correoEstudiante");
        System.out.println("Para: correoAdministrador");
        System.out.println("Asunto: " + asunto);
        System.out.println("Mensaje: " + mensaje);
    }

    // Método para enviar correo cuando el profesor hace una reserva
    public static void enviarCorreoProfesor(Reserva reserva) {
        String asunto = "Reserva realizada";
        String mensaje = "Se le notifica que el profesor " + reserva.getCodigoUsuario() + " ha realizado una reserva con código " +
                         reserva.getCodigoReserva() + " para la fecha " + reserva.getFechaReserva() +
                         " en el auditorio " + reserva.getCodigoEspacio() + " para la materia " + reserva.getMotivo() + ".\n" +
                         "Ingrese al sistema para aprobar o rechazar la reserva.";

        // Aquí va la lógica para enviar el correo (simulada)
        System.out.println("Correo a Administrador:");
        System.out.println("De: correoProfesor");
        System.out.println("Para: correoAdministrador");
        System.out.println("Asunto: " + asunto);
        System.out.println("Mensaje: " + mensaje);
    }

    public static void enviarCorreoNotificacion(Reserva reserva) {
        //
    }
}

