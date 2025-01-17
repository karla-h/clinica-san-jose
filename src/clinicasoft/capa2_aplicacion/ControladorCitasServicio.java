package clinicasoft.capa2_aplicacion;

import clinicasoft.capa3_dominio.Citas;
import clinicasoft.capa3_dominio.Paciente;
import clinicasoft.capa3_dominio.Especialidad;
import clinicasoft.capa3_dominio.Medico;
import clinicasoft.capa4_persistencia.AccesoDatosJDBC;
import clinicasoft.capa4_persistencia.AccesoDatosJDBCPostgreSQL;
import clinicasoft.capa4_persistencia.CitasPostgreSQL;
import clinicasoft.capa4_persistencia.EspecialidadPostgreSQL;
import clinicasoft.capa4_persistencia.PacientePostgreSQL;

public class ControladorCitasServicio {

    private final AccesoDatosJDBC accesoDatosJDBC;
    private final CitasPostgreSQL citasprostgreSQL;
    private final PacientePostgreSQL pacientepostgreSQL;
    private final EspecialidadPostgreSQL especialidadpostgresql;

    public ControladorCitasServicio() {
        accesoDatosJDBC = new AccesoDatosJDBCPostgreSQL();
        citasprostgreSQL = new CitasPostgreSQL(accesoDatosJDBC);
        pacientepostgreSQL = new PacientePostgreSQL(accesoDatosJDBC);
        especialidadpostgresql = new EspecialidadPostgreSQL(accesoDatosJDBC);

    }

    public Especialidad buscarEspecialidad(String idespecialidad) throws Exception {
        accesoDatosJDBC.abrirConexion();
        Especialidad especialidad = especialidadpostgresql.consultarPorNombre(idespecialidad);
        accesoDatosJDBC.cerrarConexion();
        return especialidad;
    }

    public Paciente buscarPaciente(int dni) throws Exception {
        accesoDatosJDBC.abrirConexion();
        Paciente paciente = pacientepostgreSQL.buscarPorDNI(dni);
        accesoDatosJDBC.cerrarConexion();
        return paciente;
    }

    public void GuardarCita(Citas cita) throws Exception {
        accesoDatosJDBC.abrirConexion();
        accesoDatosJDBC.iniciarTransaccion();
        citasprostgreSQL.guardar(cita);
        accesoDatosJDBC.terminarTransaccion();
    }

    public int darOrden(java.sql.Date fecha, Medico medico) throws Exception {
        accesoDatosJDBC.abrirConexion();
        accesoDatosJDBC.iniciarTransaccion();
        int c = citasprostgreSQL.darOrden(fecha, medico);
        accesoDatosJDBC.terminarTransaccion();
        return c;
    }
}
