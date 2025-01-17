package clinicasoft.capa2_aplicacion;

import clinicasoft.capa3_dominio.Especialidad;
import clinicasoft.capa4_persistencia.AccesoDatosJDBC;
import clinicasoft.capa4_persistencia.AccesoDatosJDBCPostgreSQL;
import clinicasoft.capa4_persistencia.EspecialidadPostgreSQL;
import java.util.ArrayList;

public class ControladorEspecialidadServicio {

    private final AccesoDatosJDBC accesoDatosJDBC;
    private final EspecialidadPostgreSQL especialidadPostgreSQL;

    public ControladorEspecialidadServicio() {
        accesoDatosJDBC = new AccesoDatosJDBCPostgreSQL();
        especialidadPostgreSQL = new EspecialidadPostgreSQL(accesoDatosJDBC);
    }

    public void guardarEspecialidad(Especialidad especialidad) throws Exception {
        accesoDatosJDBC.abrirConexion();
        accesoDatosJDBC.iniciarTransaccion();
        especialidadPostgreSQL.guardar(especialidad);
        accesoDatosJDBC.terminarTransaccion();
    }

    public Especialidad consultarEspecialidad(String idEspecialidad) throws Exception {
        accesoDatosJDBC.abrirConexion();
        Especialidad especialidad = especialidadPostgreSQL.consultarPorNombre(idEspecialidad);
        accesoDatosJDBC.cerrarConexion();
        return especialidad;
    }

    public void actualizarEspecialidad(Especialidad especialidad) throws Exception {
        accesoDatosJDBC.abrirConexion();
        accesoDatosJDBC.iniciarTransaccion();
        especialidadPostgreSQL.actualizar(especialidad);
        accesoDatosJDBC.terminarTransaccion();
    }

    public void eliminarEspecialidad(String idEspecialidad) throws Exception {
        accesoDatosJDBC.abrirConexion();
        especialidadPostgreSQL.eliminar(idEspecialidad);
        accesoDatosJDBC.cerrarConexion();
    }

    public ArrayList<Especialidad> listaEspecialidades() throws Exception {
        accesoDatosJDBC.abrirConexion();
        ArrayList<Especialidad> listamed = especialidadPostgreSQL.listaEspecialidades();
        accesoDatosJDBC.cerrarConexion();
        return listamed;
    }
    
    public ArrayList<Especialidad> listaEspecialidadesMedicos() throws Exception {
        accesoDatosJDBC.abrirConexion();
        ArrayList<Especialidad> listamed = especialidadPostgreSQL.listaEspecialidadesMedicos();
        accesoDatosJDBC.cerrarConexion();
        return listamed;
    }
}
