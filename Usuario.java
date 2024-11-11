public abstract class Usuario {
    private String codigoUnico;
    private String cedula;
    private String nombres;
    private String apellidos;
    private String usuario;
    private String contrasena;
    private String correo;
    private String rol;

    public Usuario(String codigoUnico, String cedula, String nombres, String apellidos, 
                   String usuario, String contrasena, String correo, String rol) {
        this.codigoUnico = codigoUnico;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.correo = correo;
        this.rol = rol;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

 
    public abstract void realizarReserva();

    public void enviarNotificacion() {
        System.out.println("Notificación enviada a: " + correo);
    }
    public class Espacio {
   private String codigoUnico;
   private String tipoEspacio;
   private String nombre;
   private int capacidad;
   private String estado;
   private String rolPermitido;

   public Espacio(String codigoUnico, String tipoEspacio, String nombre, int capacidad, String estado, String rolPermitido) {
       this.codigoUnico = codigoUnico;
       this.tipoEspacio = tipoEspacio;
       this.nombre = nombre;
       this.capacidad = capacidad;
       this.estado = estado;
       this.rolPermitido = rolPermitido;
   }

   public String getCodigoUnico() {
       return codigoUnico;
   }

   public String getTipoEspacio() {
       return tipoEspacio;
   }

   public String getNombre() {
       return nombre;
   }

   public int getCapacidad() {
       return capacidad;
   }

   public String getEstado() {
       return estado;
   }

   public String getRolPermitido() {
       return rolPermitido;
   }

   public void setEstado(String estado) {
       this.estado = estado;
   }

   public boolean esReservablePor(String rol) {
       return rolPermitido.equals("AMBOS") || rolPermitido.equals(rol);
   }
}
/*    
public class Estudiante extends Usuario(){
    protected String matricula;
    protected String carrera;

    public Estudiante(String codigoUnico, String cedula, String nombres, String apellidos, String usuario, String contrasena, String correo, TipoUsuario tipoUsuario, String matricula,String carrera){
        super(codigoUnico, cedula, nombres, apellidos, usuario, contrasena, correo, carrera);
        this.carrera = carrera;
        this.matricula = matricula;
    }

    public void setCarrera(String carrera){
        this.carrera=carrera;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public String getCarrera(){
        return this.carrera;
    }

    public String getMatricula(){
        return this.matricula;
    }
        }
        */
}

