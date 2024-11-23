package com.proyecto;

public class Espacio {
    private String codigo;
    private String tipo; // AULA, CANCHA, LABORATORIO, etc.
    private String nombre;
    private int capacidad;
    private String estado; // DISPONIBLE, RESERVADO, etc.
    private String rolPermitido; // ESTUDIANTE, PROFESOR, AMBOS

    public Espacio(String codigo, String tipo, String nombre, int capacidad, String estado, String rolPermitido) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.estado = estado;
        this.rolPermitido = rolPermitido;
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRolPermitido() {
        return rolPermitido;
    }

    public void setRolPermitido(String rolPermitido) {
        this.rolPermitido = rolPermitido;
    }

    // Método toString() para representar la instancia de Espacio
    @Override
    public String toString() {
        return "Espacio [codigo=" + codigo + ", tipo=" + tipo + ", nombre=" + nombre + 
               ", capacidad=" + capacidad + ", estado=" + estado + ", rolPermitido=" + rolPermitido + "]";
    }

    // Método para comprobar si el espacio está disponible
    public boolean isDisponible() {
        return estado.equalsIgnoreCase("DISPONIBLE");
    }
    
   
}

