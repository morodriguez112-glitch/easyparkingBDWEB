package controller;

import com.mysql.cj.conf.StringProperty;
import connection.Conexion;
import model.Usuarios;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuariosController {

    private Conexion conexion = new Conexion();

    // metodo para agregar

    public void agregar(Usuarios usuarios)
    {
        Connection con = conexion.getConexion();

        String query = "INSERT INTO usuarios (nombre, apellido, documento, telefono, correo, tipo_usuario, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try
        {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, usuarios.getNombre());
            pst.setString(2, usuarios.getApellido());
            pst.setString(3, usuarios.getDocumento());
            pst.setString(4, usuarios.getTelefono());
            pst.setString(5, usuarios.getCorreo());
            pst.setString(6, usuarios.getTipo_usuario());
            pst.setString(7, usuarios.getEstado());

            int resultado = pst.executeUpdate();

            if (resultado > 0)
            {
                JOptionPane.showMessageDialog(null, "Usuario agregado exitosamente");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al agregar Usuario");
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // metodo para eliminar

    public void eliminar (int id)
    {
        Connection con = conexion.getConexion();

        String query = "DELETE FROM usuarios WHERE id_usuarios = ?";

        try
        {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, id);

            int resultado = pst.executeUpdate();

            if (resultado > 0)
            {
                JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al eliminar el usuario");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

// metodo para actualizar

    public void actualizar (Usuarios usuarios)
    {
        Connection con = conexion.getConexion();

        String query = "UPDATE usuarios nombre = ?, apellido = ?, documento ? , telefono ? , correo = ?, tipo_usuario = ?, estado = ?) WEHERE id usuarios";

        try
        {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, usuarios.getNombre());
            pst.setString(2, usuarios.getApellido());
            pst.setString(3, usuarios.getDocumento());
            pst.setString(4, usuarios.getTelefono());
            pst.setString(5, usuarios.getCorreo());
            pst.setString(6, usuarios.getTipo_usuario());
            pst.setString(7, usuarios.getEstado());
            pst.setInt(8, usuarios.getId_usuarios());

            int resultado = pst.executeUpdate();

            if (resultado > 0)
            {
                JOptionPane.showMessageDialog(null, "Usuario actualizado exitosamente");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al actualizar Usuario");
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
// metodo para mostrar

public ArrayList<Usuarios> mostrar()
{
    ArrayList<Usuarios> listaUsuarios = new ArrayList<>();
    Connection con = conexion.getConexion();

    String query = "SELECT * FROM usuarios";

    try {
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            Usuarios usuarios = new Usuarios(
                    rs.getInt("id_usuarios"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("documento"),
                    rs.getString("telefono"),
                    rs.getString("correo"),
                    rs.getString("tipo_usuario"),
                    rs.getString("estado")
            );
        listaUsuarios.add(usuarios);
        }
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }

    return listaUsuarios;
}

}
