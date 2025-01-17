package clinicasoft.capa4_persistencia;

import clinicasoft.capa3_dominio.Especialidad;
import clinicasoft.capa3_dominio.Medico;
import java.sql.PreparedStatement;
import java.sql.*;

public class MedicoPostgreSQL {

    private final AccesoDatosJDBC accesoDatosJDBC;

    public MedicoPostgreSQL(AccesoDatosJDBC accesoDatosJDBC) {
        this.accesoDatosJDBC = accesoDatosJDBC;
    }

    public Medico consultarPorDni(int dni) throws Exception {
        Medico medico = new Medico();
        String consultarSQL = "select * from medico where dni = ?";
        PreparedStatement sentencia;
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(consultarSQL);
            sentencia.setInt(1, dni);
            ResultSet resultset = sentencia.executeQuery();
            if (resultset.next()) {
                medico.setIdMedico(resultset.getInt("idMedico"));
                medico.setNombres(resultset.getString("nombre"));
                medico.setApellidos(resultset.getString("apellido"));
                medico.setDni(resultset.getInt("dni"));
                medico.setTelefono(resultset.getInt("telefono"));
                medico.setCorreo(resultset.getString("correo"));
                medico.setCitaMaxima(resultset.getInt("citaMaxima"));
                String idEspecialidad = resultset.getString("idEspecialidad");
                EspecialidadPostgreSQL especialidadPostgreSQL = new EspecialidadPostgreSQL(accesoDatosJDBC);
                Especialidad especialidad = especialidadPostgreSQL.consultarPorNombre(idEspecialidad);
                medico.setEspecialidad(especialidad);
            }
        } catch (Exception e) {
            throw new Exception("Error al intentar consultar al médico por DNI.", e);
        }
        return medico;
    }

    public Medico consultarPorEspecialidad(String nombreEspecialidad) throws Exception {
        Medico medico = new Medico();
        String consultarSQL = "select * from medico where idEspecialidad = (select idEspecialidad from especialidad "
                + "where nombre = ?)";
        PreparedStatement sentencia;
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(consultarSQL);
            sentencia.setString(1, nombreEspecialidad);
            ResultSet resultset = sentencia.executeQuery();
            if (resultset.next()) {
                medico.setIdMedico(resultset.getInt("idMedico"));
                medico.setNombres(resultset.getString("nombre"));
                medico.setApellidos(resultset.getString("apellido"));
                medico.setDni(resultset.getInt("dni"));
                medico.setTelefono(resultset.getInt("telefono"));
                medico.setCorreo(resultset.getString("correo"));
                medico.setCitaMaxima(resultset.getInt("citaMaxima"));
                EspecialidadPostgreSQL especialidadPostgreSQL = new EspecialidadPostgreSQL(accesoDatosJDBC);
                Especialidad especialidad = especialidadPostgreSQL.consultarPorNombre(nombreEspecialidad);
                medico.setEspecialidad(especialidad);
            }
        } catch (Exception e) {
            throw new Exception("Error al intentar consultar al médico por especialidad.", e);
        }
        return medico;
    }

    public void agregar(Medico medico) throws Exception {
        String insertSQL = "INSERT INTO medico (nombre, apellido, dni, telefono, correo, citaMaxima, idEspecialidad) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement sentencia;
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(insertSQL);
            sentencia.setString(1, medico.getNombres());
            sentencia.setString(2, medico.getApellidos());
            sentencia.setInt(3, medico.getDni());
            sentencia.setInt(4, medico.getTelefono());
            sentencia.setString(5, medico.getCorreo());
            sentencia.setInt(6, medico.getCitaMaxima());
            sentencia.setInt(7, medico.getEspecialidad().getIdEspecialidad());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al intentar agregar al médico.", e);
        }
    }

    public void actualizar(Medico medico) throws Exception {
        String updateSQL = "UPDATE medico SET nombre = ?, apellido = ?, telefono = ?, correo = ?, citaMaxima = ?, idEspecialidad = ? "
                + "WHERE dni = ?";
        PreparedStatement sentencia;
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(updateSQL);
            sentencia.setString(1, medico.getNombres());
            sentencia.setString(2, medico.getApellidos());
            sentencia.setInt(3, medico.getTelefono());
            sentencia.setString(4, medico.getCorreo());
            sentencia.setInt(5, medico.getCitaMaxima());
            sentencia.setString(6, medico.getEspecialidad().getNombre());
            sentencia.setInt(7, medico.getDni());

            sentencia.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al intentar actualizar al médico.", e);
        }
    }

    public void eliminar(int dni) throws Exception {
        String deleteSQL = "DELETE FROM medico WHERE dni = ?";
        PreparedStatement sentencia;
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(deleteSQL);
            sentencia.setInt(1, dni);

            sentencia.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al intentar eliminar al médico.", e);
        }
    }

}
