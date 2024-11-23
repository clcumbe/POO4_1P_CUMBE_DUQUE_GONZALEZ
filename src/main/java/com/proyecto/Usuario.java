package com.proyecto;

public abstract class Usuario {
    private String codigo;
    private String cedula;
    private String nombres;
    private String apellidos;
    private String usuario;
    private String contrasena;
    private String correo;

    public Usuario(String codigo, String cedula, String nombres, String apellidos, String usuario, String contrasena, String correo) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.correo = correo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Método toString() para representar la instancia de Usuario
    @Override
    public String toString() {
        return "Usuario [codigo=" + codigo + ", cedula=" + cedula + ", nombres=" + nombres + ", apellidos=" + apellidos
                + ", usuario=" + usuario + ", correo=" + correo + "]";
    }


    public abstract void mostrarMenu();
}
