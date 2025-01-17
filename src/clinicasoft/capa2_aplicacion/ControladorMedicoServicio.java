package clinicasoft.capa2_aplicacion;

import clinicasoft.capa3_dominio.Medico;
import clinicasoft.capa3_dominio.Especialidad;
import clinicasoft.capa4_persistencia.AccesoDatosJDBC;
import clinicasoft.capa4_persistencia.AccesoDatosJDBCPostgreSQL;
import clinicasoft.capa4_persistencia.MedicoPostgreSQL;
import clinicasoft.capa4_persistencia.EspecialidadPostgreSQL; 

public class ControladorMedicoServicio {
    private final AccesoDatosJDBC accesoDatosJDBC;
    private final MedicoPostgreSQL medicoPostgreSQL;
    private final EspecialidadPostgreSQL especialidadPostgreSQL;

    public ControladorMedicoServicio() {
        accesoDatosJDBC = new AccesoDatosJDBCPostgreSQL();
        medicoPostgreSQL = new MedicoPostgreSQL(accesoDatosJDBC);
        especialidadPostgreSQL = new EspecialidadPostgreSQL(accesoDatosJDBC);
    }
    
    public Especialidad buscarEspecialidad(String idEspecialidad) throws Exception {
            accesoDatosJDBC.abrirConexion();
            Especialidad especialidad = especialidadPostgreSQL.consultarPorNombre(idEspecialidad);
            accesoDatosJDBC.cerrarConexion();
            return especialidad;
    }

    
    public Medico consultarMedico(int idMedico) throws Exception{
        accesoDatosJDBC.abrirConexion();
        Medico medico =  medicoPostgreSQL.consultarPorDni(idMedico);
        accesoDatosJDBC.cerrarConexion();
        return medico;
    }
    public Medico BuscarMedicoEspecialidad(String especialidad)throws Exception{
        accesoDatosJDBC.abrirConexion();
        Medico medico =  medicoPostgreSQL.consultarPorEspecialidad(especialidad);
        accesoDatosJDBC.cerrarConexion();
        return medico;
    }
    
    public void guardarMedico(Medico medico) throws Exception {
        accesoDatosJDBC.abrirConexion();
        accesoDatosJDBC.iniciarTransaccion();
        medicoPostgreSQL.agregar(medico);
        accesoDatosJDBC.terminarTransaccion();
    }
    
    public void actualizarMedico(Medico medico) throws Exception{
        accesoDatosJDBC.abrirConexion();
        accesoDatosJDBC.iniciarTransaccion();
        medicoPostgreSQL.actualizar(medico);
        accesoDatosJDBC.terminarTransaccion();
    }
    
    public void eliminar(int dni) throws Exception{
        accesoDatosJDBC.abrirConexion();
        accesoDatosJDBC.iniciarTransaccion();
        medicoPostgreSQL.eliminar(dni);
        accesoDatosJDBC.terminarTransaccion();
    }
}
