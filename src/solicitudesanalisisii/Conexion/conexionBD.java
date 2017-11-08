package solicitudesanalisisii.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionBD {
    
    private static Connection connection;
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/solicitudes";
    private static String user = "root";
    private static String password = "1111";
    
    public conexionBD(){
        try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }
    
    public Connection getConexion() {
       return connection;
    }
    
}
