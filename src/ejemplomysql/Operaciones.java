package ejemplomysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Operaciones {

    private static java.sql.Connection con;
    public static String driver = "com.mysql.jdbc.Driver";
    public static String user = "root";
    public static String pass = "";
    public static String url = "jdbc:mysql://localhost/test";

    public static void conectarBaseDatos() {
        con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
            if (con != null) {
                System.out.println("Conexión exitosa");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Conexión no exitosa");
        }

        Operaciones operacion = new Operaciones();

        operacion.guardar(con);

    }
    final String tabla = "estudiante";

    public void guardar(Connection conexion) {
        try {

            PreparedStatement consulta;

            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla
                    + "(Name,Age,CC) VALUES(?,?,?)");

            consulta.setString(1, "Juan David Patarroyo");
            consulta.setInt(2, 17);
            consulta.setString(3, "1034282941");

            consulta.executeUpdate();

            System.out.println("Escritura exitosa");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}


