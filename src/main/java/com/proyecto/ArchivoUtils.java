package com.proyecto;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class ArchivoUtils {
    public static List<Usuario> cargarUsuarios(String ruta) {
        List<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");
                String codigo = partes[0].trim();
                String cedula = partes[1].trim();
                String nombres = partes[2].trim();
                String apellidos = partes[3].trim();
                String usuario = partes[4].trim();
                String contrasena = partes[5].trim();
                String correo = partes[6].trim();
                String rol = partes[7].trim();

                Usuario nuevoUsuario = crearUsuario(rol, codigo, cedula, nombres, apellidos, usuario, contrasena, correo);
                if (nuevoUsuario != null) {
                    usuarios.add(nuevoUsuario);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar usuarios: " + e.getMessage());
        }
        return usuarios;
    }

    private static Usuario crearUsuario(String rol, String codigo, String cedula, String nombres, String apellidos, String usuario, String contrasena, String correo) {
        if ("E".equals(rol)) {
            return new Estudiante(codigo, cedula, nombres, apellidos, usuario, contrasena, correo, "MATRICULA", "CARRERA");
        } else if ("P".equals(rol)) {
            return new Profesor(codigo, cedula, nombres, apellidos, usuario, contrasena, correo, "FACULTAD", new String[]{"MATERIAS"});
        } else if ("A".equals(rol)) {
            return new Administrador(codigo, cedula, nombres, apellidos, usuario, contrasena, correo, "CARGO");
        }
        return null;
    }

    public static List<Espacio> cargarEspacios(String ruta) {
        List<Espacio> espacios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");
                String codigo = partes[0].trim();
                String tipo = partes[1].trim();
                String nombre = partes[2].trim();
                int capacidad = Integer.parseInt(partes[3].trim());
                String estado = partes[4].trim();
                String rolPermitido = partes[5].trim();
                espacios.add(new Espacio(codigo, tipo, nombre, capacidad, estado, rolPermitido));
            }
        } catch (IOException e) {
            System.out.println("Error al cargar espacios: " + e.getMessage());
        }
        return espacios;
    }

    // Método para mostrar los espacios disponibles según el tipo de usuario
    public static void mostrarEspaciosDisponibles(List<Espacio> espacios, Usuario usuario) {
        System.out.println("Espacios disponibles para " + usuario.getUsuario() + ":");

        // Filtrar espacios según el rol del usuario
        for (Espacio espacio : espacios) {
            if (espacio.isDisponible() && espacio.getRolPermitido().equalsIgnoreCase("AMBOS") ||
                (usuario instanceof Estudiante && espacio.getRolPermitido().equalsIgnoreCase("ESTUDIANTE")) ||
                (usuario instanceof Profesor && !espacio.getRolPermitido().equalsIgnoreCase("ESTUDIANTE"))) {
                System.out.println(espacio);
            }
        }
    }

    public static List<Reserva> cargarReservas(String ruta) {
        List<Reserva> reservas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  // Formato de fecha esperado

            while ((linea = br.readLine()) != null) {
                // Verificar si la línea no está vacía
                if (linea.trim().isEmpty()) {
                    continue; // Saltar líneas vacías
                }

                // Dividir la línea por el delimitador "|"
                String[] partes = linea.split("\\|");

                // Asegurarse de que la línea tiene suficientes campos
                if (partes.length < 8) {
                    System.out.println("Línea mal formateada (falta información): " + linea);
                    continue;  // Saltar líneas mal formateadas
                }

                // Eliminar los espacios extra de los campos
                for (int i = 0; i < partes.length; i++) {
                    partes[i] = partes[i].trim();
                }

                // Asignar cada campo a las variables correspondientes
                String codigoReserva = partes[0];
                String codigoUsuario = partes[1];
                String cedulaUsuario = partes[2];
                String fechaReserva = partes[3];  // Fecha como String
                String codigoEspacio = partes[4];
                String tipoEspacio = partes[5];
                String estado = partes[6];
                String motivo = partes[7];

                // Convertir la fecha desde String a Date
                Date fecha = sdf.parse(fechaReserva);  // Convertir la fecha

                // Crear la reserva y agregarla a la lista
                // Ahora pasamos el código de la reserva del archivo
                Reserva reserva = new Reserva(codigoReserva, codigoUsuario, cedulaUsuario, fecha, codigoEspacio, tipoEspacio, motivo, estado);
                reservas.add(reserva);
            }
        } catch (IOException | java.text.ParseException e) {
            System.out.println("Error al cargar las reservas: " + e.getMessage());
        }
        return reservas;
    }

// Método para guardar la nueva reserva en el archivo "reservas.txt"
public static void guardarReservaEnArchivo(Reserva nuevaReserva) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("reservas.txt", true))) {
        // Convertir la fecha de la reserva a formato adecuado
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaReserva = sdf.format(nuevaReserva.getFechaReserva());

        // Escribir la reserva en el archivo
        String linea = nuevaReserva.getCodigoReserva() + " | " +
                       nuevaReserva.getCodigoUsuario() + " | " +
                       nuevaReserva.getCedulaUsuario() + " | " +
                       fechaReserva + " | " +
                       nuevaReserva.getCodigoEspacio() + " | " +
                       nuevaReserva.getTipoEspacio() + " | " +
                       nuevaReserva.getEstado() + " | " +
                       nuevaReserva.getMotivo() + "\n";

        bw.write(linea);  // Escribir en la última línea
        System.out.println("Reserva guardada en el archivo.");
    } catch (IOException e) {
        System.out.println("Error al guardar la reserva en el archivo: " + e.getMessage());
    }
}


}
