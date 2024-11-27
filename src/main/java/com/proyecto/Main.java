package com.proyecto;

import java.util.*;
import javax.mail.*;
import io.github.cdimascio.dotenv.*;

public class Main {

    // Listas estáticas que representan los datos cargados
    static List<Usuario> usuarios = ArchivoUtils.cargarUsuarios("usuarios.txt");
    static List<Espacio> espacios = ArchivoUtils.cargarEspacios("espacios.txt");
    static List<Reserva> reservas = ArchivoUtils.cargarReservas("reservas.txt");

    public static void main(String[] args) {
        Usuario usuarioActual; // Usuario autenticado

        do {
            // Iniciar sesión
            usuarioActual = login(usuarios);

            // Mostrar el menú correspondiente al usuario autenticado
            usuarioActual.mostrarMenu();

            // Mensaje al cerrar sesión
            System.out.println("Sesión cerrada. Redirigiendo al inicio de sesión...\n");
        } while (true); // Volver al login después de cerrar sesión
    }

    // Método estático para realizar el inicio de sesión
    public static Usuario login(List<Usuario> usuarios) {
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

        // Si el login es exitoso, se devuelve el usuario autenticado
        System.out.println("Bienvenido, " + usuarioActual.getUsuario());
        return usuarioActual;
    }

    // Método para buscar un usuario en la lista según las credenciales
    private static Usuario buscarUsuario(List<Usuario> usuarios, String usuario, String contrasena) {
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario) && u.getContrasena().equals(contrasena)) {
                return u; // Devuelve el usuario si coincide
            }
        }
        return null; // Retorna null si no se encuentra el usuario
    }
}