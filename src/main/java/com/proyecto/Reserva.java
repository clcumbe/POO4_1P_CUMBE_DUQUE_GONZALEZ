package com.proyecto;

import java.util.Date;

public class Reserva {
    private String codigoReserva;       // Código único de la reserva
    private String codigoUsuario;       // Código del usuario que realiza la reserva
    private String cedulaUsuario;       // Cédula del usuario
    private Date fechaReserva;          // Fecha de la reserva
    private String codigoEspacio;       // Código del espacio reservado
    private String tipoEspacio;         // Tipo de espacio (Aula, Cancha, etc.)
    private String estado;              // Estado de la reserva (PENDIENTE, APROBADO, etc.)
    private String motivo;              // Motivo de la reserva

    // Constructor de la clase Reserva
    public Reserva(String codigoReserva, String codigoUsuario, String cedulaUsuario, Date fechaReserva,
                   String codigoEspacio, String tipoEspacio, String motivo, String estado) {
        this.codigoReserva = codigoReserva;    // Código de la reserva
        this.codigoUsuario = codigoUsuario;    // Código del usuario
        this.cedulaUsuario = cedulaUsuario;    // Cédula del usuario
        this.fechaReserva = fechaReserva;      // Fecha de la reserva
        this.codigoEspacio = codigoEspacio;    // Código del espacio
        this.tipoEspacio = tipoEspacio;        // Tipo de espacio
        this.estado = estado;                  // Estado de la reserva
        this.motivo = motivo;                  // Motivo de la reserva
        
    }

    

    // Getters y Setters
    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getCedulaUsuario() {
        return cedulaUsuario;
    }

    public void setCedulaUsuario(String cedulaUsuario) {
        this.cedulaUsuario = cedulaUsuario;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getCodigoEspacio() {
        return codigoEspacio;
    }

    public void setCodigoEspacio(String codigoEspacio) {
        this.codigoEspacio = codigoEspacio;
    }

    public String getTipoEspacio() {
        return tipoEspacio;
    }

    public void setTipoEspacio(String tipoEspacio) {
        this.tipoEspacio = tipoEspacio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    

    // Método toString() para representar la instancia de Reserva de forma legible
    @Override
    public String toString() {
        // Formato de la reserva con todos los detalles
        return "Reserva [codigoReserva=" + codigoReserva + ", codigoUsuario=" + codigoUsuario + ", cedulaUsuario="
                + cedulaUsuario + ", fechaReserva=" + fechaReserva + ", codigoEspacio=" + codigoEspacio
                + ", tipoEspacio=" + tipoEspacio + ", estado=" + estado + ", motivo=" + motivo + "]";
    }
    
}
