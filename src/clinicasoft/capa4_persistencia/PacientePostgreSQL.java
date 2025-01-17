package clinicasoft.capa4_persistencia;

import clinicasoft.capa3_dominio.Paciente;
import java.sql.*;

public class PacientePostgreSQL {

    private final AccesoDatosJDBC accesoDatosJDBC;
    private PreparedStatement ps;
    private ResultSet rs;

    public PacientePostgreSQL(AccesoDatosJDBC accesoDatosJDBC) {
        this.accesoDatosJDBC = accesoDatosJDBC;
    }

    public Paciente buscarPorDNI(int dni) throws Exception {
        Paciente paciente = new Paciente();
        String consultaSQL = "select * from paciente where dni = ?";
        try {
            ps = accesoDatosJDBC.prepararSentencia(consultaSQL);
            ps.setInt(1, dni);
            rs = ps.executeQuery();
            if (rs.next()) {
                paciente.setIdPaciente(rs.getInt("idPaciente"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setApellido(rs.getString("apellido"));
                paciente.setDni(rs.getInt("dni"));
                paciente.setTelefono(rs.getInt("telefono"));
                paciente.setCorreo(rs.getString("correo"));
                paciente.setAplicaDescuento(rs.getBoolean("aplicaDescuento"));
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace(); 
            throw new Exception("Error al intentar buscar el paciente por DNI.", e);
        }
        return paciente;
    }

    public void agregar(Paciente paciente) throws Exception {
        String insertarSQL = "INSERT INTO paciente (nombre, apellido, dni, telefono, correo, aplicaDescuento) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = accesoDatosJDBC.prepararSentencia(insertarSQL)) {
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellido());
            ps.setInt(3, paciente.getDni());
            ps.setInt(4, paciente.getTelefono());
            ps.setString(5, paciente.getCorreo());
            ps.setBoolean(6, paciente.getAplicaDescuento());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al intentar agregar al paciente.", e);
        }
    }

    public void actualizar(Paciente paciente) throws Exception {
        String actualizarSQL = "UPDATE paciente SET nombre = ?, apellido = ?, telefono = ?, correo = ?, aplicaDescuento = ? "
                + "WHERE dni = ?";
        try (PreparedStatement ps = accesoDatosJDBC.prepararSentencia(actualizarSQL)) {
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellido());
            ps.setInt(3, paciente.getTelefono());
            ps.setString(4, paciente.getCorreo());
            ps.setBoolean(5, paciente.getAplicaDescuento());
            ps.setInt(6, paciente.getDni());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al intentar actualizar al paciente.", e);
        }
    }

    public void eliminar(int dni) throws Exception {
        String eliminarSQL = "DELETE FROM paciente WHERE dni = ?";
        try (PreparedStatement ps = accesoDatosJDBC.prepararSentencia(eliminarSQL)) {
            ps.setInt(1, dni);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al intentar eliminar al paciente.", e);
        }
    }

}
