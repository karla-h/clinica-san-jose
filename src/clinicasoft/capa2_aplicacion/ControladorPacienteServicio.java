package clinicasoft.capa2_aplicacion;

import clinicasoft.capa3_dominio.Paciente;
import clinicasoft.capa4_persistencia.AccesoDatosJDBC;
import clinicasoft.capa4_persistencia.AccesoDatosJDBCPostgreSQL;
import clinicasoft.capa4_persistencia.PacientePostgreSQL;

public class ControladorPacienteServicio {

    private AccesoDatosJDBC accesoDatosJDBC;
    private PacientePostgreSQL pacientePostgreSQL;

    public ControladorPacienteServicio() {
        accesoDatosJDBC = new AccesoDatosJDBCPostgreSQL();
        pacientePostgreSQL = new PacientePostgreSQL(accesoDatosJDBC);
    }

    public Paciente buscarPaciente(int dni) throws Exception {
        accesoDatosJDBC.abrirConexion();
        Paciente paciente = pacientePostgreSQL.buscarPorDNI(dni);
        accesoDatosJDBC.cerrarConexion();
        return paciente;
    }
    
    public void guardarPaciente(Paciente paciente) throws Exception {
        accesoDatosJDBC.abrirConexion();
        accesoDatosJDBC.iniciarTransaccion();
        pacientePostgreSQL.agregar(paciente);
        accesoDatosJDBC.terminarTransaccion();
    }
    
    public void actualizarPaciente(Paciente paciente) throws Exception{
        accesoDatosJDBC.abrirConexion();
        accesoDatosJDBC.iniciarTransaccion();
        pacientePostgreSQL.actualizar(paciente);
        accesoDatosJDBC.terminarTransaccion();
    }
    
    public void eliminar(int dni) throws Exception{
        accesoDatosJDBC.abrirConexion();
        accesoDatosJDBC.iniciarTransaccion();
        pacientePostgreSQL.eliminar(dni);
        accesoDatosJDBC.terminarTransaccion();
    }
}
