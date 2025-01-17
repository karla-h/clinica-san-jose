package clinicasoft.capa4_persistencia;

import clinicasoft.capa3_dominio.Especialidad;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EspecialidadPostgreSQL {

    private final AccesoDatosJDBC accesoDatosJDBC;
    private PreparedStatement ps;
    private ResultSet rs;

    public EspecialidadPostgreSQL(AccesoDatosJDBC accesoDatosJDBC) {
        this.accesoDatosJDBC = accesoDatosJDBC;
    }

    public void guardar(Especialidad especialidad) throws Exception {
        String insertSQL = "INSERT INTO especialidad (nombre, costo) VALUES (?, ?)";
        try {
            ps = accesoDatosJDBC.prepararSentencia(insertSQL);
            ps.setString(1, especialidad.getNombre());
            ps.setDouble(2, especialidad.getCosto());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw new Exception("Error al intentar guardar la especialidad. ", e);
        } finally {
            close();
        }
    }

    public Especialidad consultarPorNombre(String nombreEspecialidad) throws Exception {
        Especialidad especialidad = new Especialidad();
        String consultarSQL = "select * from especialidad where nombre = ?";
        try {
            ps = accesoDatosJDBC.prepararSentencia(consultarSQL);
            ps.setString(1, nombreEspecialidad);
            rs = ps.executeQuery();
            if (rs.next()) {
                especialidad.setIdEspecialidad(rs.getInt("idEspecialidad"));
                especialidad.setNombre(rs.getString("nombre"));
                especialidad.setCosto(rs.getDouble("costo"));
            }
        } catch (Exception e) {
            throw new Exception("Error al intentar consultar la especialidad. ", e);
        } finally {
            close();
        }
        return especialidad;
    }

    public void actualizar(Especialidad especialidad) throws Exception {
        String actualizarSQL = "update especialidad set nombre = ?, costo = ? where idEspecialidad = ?";
        try {
            ps = accesoDatosJDBC.prepararSentencia(actualizarSQL);
            ps.setString(1, especialidad.getNombre());
            ps.setDouble(2, especialidad.getCosto());
            ps.setInt(3, especialidad.getIdEspecialidad());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al intentar actualizar la especialidad. ", e);
        } finally {
            close();
        }
    }

    public void eliminar(String nombreEspecialidad) throws Exception {
        String eliminarSQL = "delete from especialidad where nombre = ?";
        try {
            ps = accesoDatosJDBC.prepararSentencia(eliminarSQL);
            ps.setString(1, nombreEspecialidad);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al intentar eliminar la especialidad. ", e);
        } finally {
            close();
        }
    }

    public ArrayList<Especialidad> listaEspecialidades() throws Exception {
        ArrayList<Especialidad> listaEspecialidades = new ArrayList<>();
        String mostrarEspecialidadesSQL
                = "SELECT e.idEspecialidad, e.nombre, e.costo "
                + "FROM especialidad e "
                + "JOIN medico m ON e.idEspecialidad = m.idEspecialidad "
                + "GROUP BY e.idEspecialidad, e.nombre, e.costo";
        try {
            ps = accesoDatosJDBC.prepararSentencia(mostrarEspecialidadesSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Especialidad especialidad = new Especialidad();
                especialidad.setIdEspecialidad(rs.getInt("idEspecialidad"));
                especialidad.setNombre(rs.getString("nombre"));
                especialidad.setCosto(rs.getDouble("costo"));
                listaEspecialidades.add(especialidad);
            }
        } catch (Exception e) {
            throw new Exception("Error al intentar mostrar las especialidades con médicos. ", e);
        } finally {
            close();
        }
        return listaEspecialidades;
    }

    public ArrayList<Especialidad> listaEspecialidadesMedicos() throws Exception {
        ArrayList<Especialidad> listaEspecialidades = new ArrayList<>();
        String mostrarEspecialidadesSQL = "select * from especialidad";
        try {
            ps = accesoDatosJDBC.prepararSentencia(mostrarEspecialidadesSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Especialidad especialidad = new Especialidad();
                especialidad.setIdEspecialidad(rs.getInt("idEspecialidad"));
                especialidad.setNombre(rs.getString("nombre"));
                especialidad.setCosto(rs.getDouble("costo"));
                listaEspecialidades.add(especialidad);
            }
        } catch (Exception e) {
            throw new Exception("Error al intentar mostrar las especialidades. ", e);
        } finally {
            close();
        }
        return listaEspecialidades;
    }

    private void close() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
