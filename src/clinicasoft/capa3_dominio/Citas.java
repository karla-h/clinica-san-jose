package clinicasoft.capa3_dominio;

public class Citas {

    private String idcita;
    private java.sql.Date fecha;
    private int orden;
    private double costoneto;
    private double descuento;
    private double costototal;
    private Paciente paciente;
    private Medico medico;

    public Citas() {
    }

    public Citas(String idcita, java.sql.Date fecha, int orden, double costoneto, double descuento, double costototal, Paciente paciente, Medico medico) {
        this.idcita = idcita;
        this.fecha = fecha;
        this.orden = orden;
        this.costoneto = costoneto;
        this.descuento = descuento;
        this.costototal = costototal;
        this.paciente = paciente;
        this.medico = medico;
    }

    public String getIdcita() {
        return idcita;
    }

    public void setIdcita(String idcita) {
        this.idcita = idcita;
    }

    public java.sql.Date getFecha() {
        return fecha;
    }

    public void setFecha(java.sql.Date fecha) {
        this.fecha = fecha;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public double getCostoneto() {
        return costoneto;
    }

    public void setCostoneto(double costoneto) {
        this.costoneto = costoneto;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getCostototal() {
        return costototal;
    }

    public void setCostototal(double costototal) {
        this.costototal = costototal;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    // Reglas de Negocio
    
    public boolean permiteNuevaCitas(int citasmaximas) {
        return citasmaximas <= medico.getCitaMaxima();
    }

    public double calcularDescuento() {
        return paciente.getAplicaDescuento() ? medico.getEspecialidad().getCosto() * 0.20 : 0;
    }

    public double calcularCostoTotal() {
        return paciente.getAplicaDescuento() ? medico.getEspecialidad().getCosto() * 0.80
                : medico.getEspecialidad().getCosto();
    }
}
