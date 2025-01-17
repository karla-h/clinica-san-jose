package clinicasoft.capa3_dominio;

public class Medico {

    private int idMedico;
    private String nombres;
    private String apellidos;
    private int dni;
    private int telefono;
    private String correo;
    private int citaMaxima;
    private Especialidad especialidad;

    public Medico() {
    }

    public Medico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getCitaMaxima() {
        return citaMaxima;
    }

    public void setCitaMaxima(int citaMaxima) {
        this.citaMaxima = citaMaxima;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
}