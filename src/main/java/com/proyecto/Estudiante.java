package com.proyecto;

import java.text.SimpleDateFormat;
import java.util.*;

public class Estudiante extends Usuario {
    private String matricula;
    private String carrera;

    public Estudiante(String codigo, String cedula, String nombres, String apellidos, String usuario, String contrasena, String correo, String matricula, String carrera) {
        super(codigo, cedula, nombres, apellidos, usuario, contrasena, correo);
        this.matricula = matricula;
        this.carrera = carrera;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    // Método toString() para representar la instancia de Estudiante
    @Override
    public String toString() {
        return "Estudiante [matricula=" + matricula + ", carrera=" + carrera + ", usuario=" + getUsuario() + ", nombres=" + getNombres() + " " + getApellidos() + "]";
    }


    Scanner scanner = new Scanner(System.in);

    @Override
    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println("Menú de Estudiante:");
            System.out.println("1. Reservar espacio");
            System.out.println("2. Consultar reservas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    reservarEspacio();
                    break;
                case 2:
                    consultarReservas();
                    break;
                case 3:
                    System.out.println("Gracias por usar el sistema.");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 3);
    }

   
    private void reservarEspacio() {
    // Mostrar solo los espacios que el estudiante puede reservar
    System.out.println("Seleccione el tipo de espacio a reservar: ");
    System.out.println("1. Aulas");
    System.out.println("2. Canchas");
    System.out.print("Ingrese su opción: ");
    int opcion = scanner.nextInt();
    scanner.nextLine(); // Limpiar el buffer

    // Filtrar los espacios disponibles según la opción seleccionada
    List<Espacio> espaciosDisponibles = new ArrayList<>();
    for (Espacio espacio : Main.espacios) {
        if (espacio.isDisponible() && ((opcion == 1 && espacio.getTipo().equals("AULA")) ||
                                       (opcion == 2 && espacio.getTipo().equals("CANCHA")))) {
            espaciosDisponibles.add(espacio);
        }
    }

    // Si hay espacios disponibles, mostrar la lista
    if (!espaciosDisponibles.isEmpty()) {
        System.out.println("Espacios disponibles:");
        for (int i = 0; i < espaciosDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + espaciosDisponibles.get(i));
        }

        System.out.print("Seleccione el número del espacio que desea reservar: ");
        int espacioSeleccionado = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        if (espacioSeleccionado >= 1 && espacioSeleccionado <= espaciosDisponibles.size()) {
            Espacio espacioElegido = espaciosDisponibles.get(espacioSeleccionado - 1);

            // Generar el código de reserva secuencialmente
            String codigoReserva = generarCodigoReserva();

            // Crear una nueva reserva con el código generado
            Reserva nuevaReserva = new Reserva(codigoReserva, this.getCodigo(), this.getCedula(), new Date(),
                                               espacioElegido.getCodigo(), espacioElegido.getTipo(),
                                               "Reserva de " + espacioElegido.getNombre(), "PENDIENTE");

            // Agregar la nueva reserva a la lista estática de reservas en el Main
            Main.reservas.add(nuevaReserva);

            // Mostrar la reserva realizada con el formato de toString
            System.out.println("Reserva realizada con éxito: " + nuevaReserva.toString());

            // Guardar la nueva reserva en el archivo de texto
            ArchivoUtils.guardarReservaEnArchivo(nuevaReserva);
           

        } else {
            System.out.println("Opción no válida.");
        }

    } else {
        System.out.println("No hay espacios disponibles para su selección.");
    }
}

// Método para generar el código de reserva secuencialmente
private String generarCodigoReserva() {
    int ultimoCodigo = 0;
    // Buscar el último código de reserva en la lista de reservas
    if (!Main.reservas.isEmpty()) {
        String ultimoCodigoStr = Main.reservas.get(Main.reservas.size() - 1).getCodigoReserva();
        // Extraer el número del último código (por ejemplo, "5001" -> 5001)
        ultimoCodigo = Integer.parseInt(ultimoCodigoStr);
    }
    // Incrementar el último código para generar el siguiente
    return String.valueOf(ultimoCodigo + 1);  // Retorna el nuevo código como String
}

    
    // Método para consultar las reservas de un estudiante
   private void consultarReservas() {
    System.out.print("Ingrese la fecha para consultar las reservas (YYYY-MM-DD): ");
    String fechaInput = scanner.nextLine();

    // Convertir la fecha ingresada por el usuario a un objeto Date
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date fechaBusqueda = null;
    try {
        fechaBusqueda = sdf.parse(fechaInput);  // Parsear la fecha ingresada
    } catch (Exception e) {
        System.out.println("Formato de fecha incorrecto.");
        return;
    }

    // Filtrar reservas por fecha y código de usuario
    boolean encontrado = false;
    for (Reserva reserva : Main.reservas) {
        // Comparar solo las fechas (sin hora) usando SimpleDateFormat
        if (esMismaFecha(reserva.getFechaReserva(), fechaBusqueda) && reserva.getCodigoUsuario().equals(this.getCodigo())) {
            // Usamos los getters para acceder a los atributos de la reserva
            System.out.println("Código de reserva: " + reserva.getCodigoReserva());
            System.out.println("Fecha: " + sdf.format(reserva.getFechaReserva()));  // Muestra la fecha formateada
            System.out.println("Tipo de espacio: " + reserva.getTipoEspacio());
            System.out.println("Nombre del espacio: " + reserva.getCodigoEspacio());

            // Obtener el espacio correspondiente a la reserva
            Espacio espacio = obtenerEspacioPorCodigo(reserva.getCodigoEspacio());
            if (espacio != null) {
                int capacidad = espacio.getCapacidad();
                System.out.println("Capacidad: " + capacidad);
            } else {
                System.out.println("Espacio no encontrado.");
            }

            System.out.println("Usuario: " + reserva.getCodigoUsuario());
            System.out.println("Estado: " + reserva.getEstado());
            System.out.println("Motivo: " + reserva.getMotivo());
            encontrado = true;
        }
    }

    if (!encontrado) {
        System.out.println("No se encontraron reservas para esa fecha.");
    }
}

// Método para comparar solo la fecha (sin hora) de dos objetos Date
private boolean esMismaFecha(Date fecha1, Date fecha2) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String fecha1Str = sdf.format(fecha1);  // Convertir la fecha1 a formato "yyyy-MM-dd"
    String fecha2Str = sdf.format(fecha2);  // Convertir la fecha2 a formato "yyyy-MM-dd"
    return fecha1Str.equals(fecha2Str);  // Comparar solo las fechas
}

// Método para obtener el espacio correspondiente al código
public Espacio obtenerEspacioPorCodigo(String codigoEspacio) {
    for (Espacio espacio : Main.espacios) {
        if (espacio.getCodigo().equals(codigoEspacio)) {
            return espacio;
        }
    }
    return null;  // Si no se encuentra el espacio, devuelve null
}

}


