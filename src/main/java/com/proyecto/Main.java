package com.proyecto;

import java.util.*;


public class Main {

    static List<Usuario> usuarios = ArchivoUtils.cargarUsuarios("usuarios.txt");
    static List<Espacio> espacios = ArchivoUtils.cargarEspacios("espacios.txt");
    static List<Reserva> reservas = ArchivoUtils.cargarReservas("reservas.txt");
    public static void main(String[] args) {
        

        Scanner scanner = new Scanner(System.in);
        Usuario usuarioActual = null;

        // Bucle para verificar las credenciales hasta que sean correctas
        while (usuarioActual == null) {
            System.out.println("Ingrese su usuario:");
            String usuario = scanner.nextLine();
            System.out.println("Ingrese su contraseña:");
            String contrasena = scanner.nextLine();

            usuarioActual = buscarUsuario(usuarios, usuario, contrasena);

            if (usuarioActual == null) {
                System.out.println("Credenciales incorrectas. Intente nuevamente.");
            }
        }

        // Si el login es exitoso, muestra el menú del usuario
        System.out.println("Bienvenido, " + usuarioActual.getUsuario());
        usuarioActual.mostrarMenu();
    }

    private static Usuario buscarUsuario(List<Usuario> usuarios, String usuario, String contrasena) {
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario) && u.getContrasena().equals(contrasena)) {
                return u;
            }
        }
        return null; // Retorna null si no se encuentra el usuario
    }
}
