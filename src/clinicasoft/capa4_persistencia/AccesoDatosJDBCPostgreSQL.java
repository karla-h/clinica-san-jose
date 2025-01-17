package clinicasoft.capa4_persistencia;

import java.sql.DriverManager;

public class AccesoDatosJDBCPostgreSQL extends AccesoDatosJDBC{
    
    @Override
    public void abrirConexion() throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/MedicaSoft";
            conexion = DriverManager.getConnection(url, "postgres", "1234");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Ocurrio un problema en la conexión con la base de datos.", e);
        }
    }
}

