package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection {

    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String url = "jdbc:sqlserver://DESKTOP-N6BCL2Q\\SQLEXPRESS:1433;databaseName=prueba";
    private String user = "marcela";
    private String pass = "daniel92";
    //private String pass = "daniel92";

    public connection() {

    }

    public Connection Conectar() {
        try {
            Class.forName(driver);
            System.out.println("Conectando a la base de datos"); 
           return (DriverManager.getConnection(url,user, pass));
        } catch (Exception e) {
            System.out.println("Error de conexion");
            System.out.println("causa -> " + e.getMessage());
            System.out.println("*************************");
            e.printStackTrace();
        }
        return null;
    }

    public void Desconectar(Connection cn) {
        try {
            cn.close();
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) {
        connection con = new connection();
        
        con.Conectar();
    }
    
}
