package connection;

import model.Usuarios;

import java.lang.classfile.ClassFileVersion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion
{
    private static final String URL =
            "jdbc:mysql://localhost:3306/easy_parking"
            + "?useSSL=false"
            + "&allowPublicKeyRetrieval=true"
            + "&serverTimezone=America/Bogota";

    private static final String USUARIO = "root";
    private static final String CLAVE = "";

    public Connection getConexion()
    {
        Connection con = null;

        try

        {
            Class.forName("com.mysql.cj.jdbc.Driver");

           con = DriverManager.getConnection(
                   URL,
                   USUARIO,
                   CLAVE
           );
           System.out.println("Conexion exitosa con la base de datos");
        }

        catch (Exception e)
        {
            System.out.println("error en la conexión de base de datos"
            );

            e.printStackTrace();

        }

        return con;

    }
}

