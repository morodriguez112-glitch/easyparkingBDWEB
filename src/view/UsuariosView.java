package view;

import connection.Conexion;
import controller.UsuariosController;
import model.Usuarios;

import javax.swing.*;
import java.util.ArrayList;

public class UsuariosView
{
    UsuariosController usuariosController = new UsuariosController();
    Conexion conexion = new Conexion();

    // metodo mostrar

    public void mostrar ()
    {
        ArrayList<Usuarios> listaUsuarios = new ArrayList<>();
        listaUsuarios = usuariosController.mostrar();

        for (Usuarios usuarios : listaUsuarios)
        {
            System.out.println("Id: "+usuarios.getId_usuarios());
            System.out.println("Nombre: "+usuarios.getNombre());
            System.out.println("Apellido: "+usuarios.getApellido());
            System.out.println("Documento: "+usuarios.getDocumento());
            System.out.println("Telefono: "+usuarios.getTelefono());
            System.out.println("Correo: "+usuarios.getCorreo());
            System.out.println("Tipo_usuario: "+usuarios.getTipo_usuario());
            System.out.println("Estado: "+usuarios.getEstado());
            System.out.println("______________________________________________");
        }
    }

    //metodo agregar

    public  void agregar ()
    {
        String nombre = JOptionPane.showInputDialog("Escribir nombre del usuario");
        String apellido = JOptionPane.showInputDialog("Escribir apellido del usuario");
        String documento = JOptionPane.showInputDialog("Escribir documento del usuario");
        String telefono = JOptionPane.showInputDialog("Escribir telefono del usuario");
        String correo = JOptionPane.showInputDialog("Escribir correo del usuario");
        String tipo_usuario = JOptionPane.showInputDialog("Escribir tipo de usuario");

        Usuarios usuarios = new Usuarios(0, nombre, apellido, documento, telefono, correo, tipo_usuario, "1");
        usuariosController.agregar(usuarios);
    }

    //metodo eliminar

    public void eliminar()
    {
        int Id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Id del Usuario"));
        usuariosController.eliminar(Id);
    }

    //metodo actualizar

    public void actualizar()
    {
        String nombre = JOptionPane.showInputDialog("Escribir nombre del usuario");
        String apellido = JOptionPane.showInputDialog("Escribir apellido del usuario");
        String documento = JOptionPane.showInputDialog("Escribir documento del usuario");
        String telefono = JOptionPane.showInputDialog("Escribir telefono del usuario");
        String correo = JOptionPane.showInputDialog("Escribir correo del usuario");
        String tipo_usuario = JOptionPane.showInputDialog("Escribir tipo de usuario");
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingresar el Id del Usuario"));

        Usuarios usuarios = new Usuarios(id, nombre, apellido, documento, telefono, correo, tipo_usuario, "1");
        usuariosController.actualizar(usuarios);
    }

    public void menu()
    {
        int op = Integer.parseInt(JOptionPane.showInputDialog("1.mostrar, 2.agregar, 3.actualizar, 4.eliminar, 5.salir"));

        switch (op)
        {
            case 1:
                mostrar();
                break;
            case 2:
                agregar();
                break;
            case 3:
                actualizar();
                break;
            case 4:
                eliminar();
                break;
            case 5:
                System.exit(0);
                break;
        }
        menu ();
    }

    static void main()
    {
        UsuariosView usuariosView =new UsuariosView();
        usuariosView.menu();
    }
}
