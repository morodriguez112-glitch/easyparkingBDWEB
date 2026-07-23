package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public Connection getConexion()
    {
        Connection con = null;

        try

        {
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/easy_parking", "root", "");
        }

        catch (Exception e)
        {
            e.printStackTrace();

        }

        return con;

    }
}
