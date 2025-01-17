package clinicasoft.capa4_persistencia;

import clinicasoft.capa3_dominio.*;
import java.sql.*;

public class CitasPostgreSQL {

    private AccesoDatosJDBC accesoDatosJDBC;

    public CitasPostgreSQL(AccesoDatosJDBC accesoDatosJDBC) {
        this.accesoDatosJDBC = accesoDatosJDBC;
    }

    // Guardar cita
    public void guardar(Citas cita) throws Exception {
        String insertSQL = "INSERT INTO cita (fecha, orden, costoNeto, descuento, costoTotal, idPaciente, idMedico) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement sentencia;
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(insertSQL);
            sentencia.setDate(1, cita.getFecha());
            sentencia.setInt(2, cita.getOrden());
            sentencia.setDouble(3, cita.getCostoneto());
            sentencia.setDouble(4, cita.getDescuento());
            sentencia.setDouble(5, cita.getCostototal());
            sentencia.setInt(6, cita.getPaciente().getIdPaciente());
            sentencia.setInt(7, cita.getMedico().getIdMedico());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
            throw new Exception("Error al intentar guardar la cita.", e);
        }
    }

    public Citas consultar(String idCita) throws Exception {
        Citas cita = null;
        String consultarSQL = "SELECT * FROM cita WHERE idCita = ?";
        PreparedStatement sentencia;
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(consultarSQL);
            sentencia.setString(1, idCita);
            ResultSet resultSet = sentencia.executeQuery();
            if (resultSet.next()) {
                cita = new Citas();
                cita.setIdcita(idCita);
                cita.setFecha(resultSet.getDate("fecha"));
                cita.setOrden(resultSet.getInt("orden"));
                cita.setCostoneto(resultSet.getDouble("costoNeto"));
                cita.setDescuento(resultSet.getDouble("descuento"));
                cita.setCostototal(resultSet.getDouble("costoTotal"));

                PacientePostgreSQL pacientePostgreSQL = new PacientePostgreSQL(accesoDatosJDBC);
                Paciente paciente = pacientePostgreSQL.buscarPorDNI(resultSet.getInt("idPaciente"));
                cita.setPaciente(paciente);

                MedicoPostgreSQL medicoPostgreSQL = new MedicoPostgreSQL(accesoDatosJDBC);
                String especialidad = resultSet.getString("especialidad");
                Medico medico = medicoPostgreSQL.consultarPorEspecialidad(especialidad);
                cita.setMedico(medico);
            }
        } catch (Exception e) {
            throw new Exception("Error al consultar la cita", e);
        }
        return cita;
    }

    public int darOrden(java.sql.Date fecha, Medico medico) {
        if (medico == null) {
            return 0;
        }
        String countSQL = "SELECT count(*) AS contador FROM cita WHERE fecha = ? AND idMedico = ?";
        PreparedStatement sentencia;
        int contador = 0;
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(countSQL);
            sentencia.setDate(1, fecha);
            sentencia.setInt(2, medico.getIdMedico());
            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {
                contador = rs.getInt("contador") + 1;
            }
            sentencia.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return contador;
    }
}
