package servlet;

import controller.UsuariosController;
import model.Usuarios;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/usuarios")
public class UsuariosServlet extends HttpServlet
{
    private UsuariosController usuariosController;

    @Override
    public void init()
    {
        usuariosController = new UsuariosController();
    }
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException
    {
        String accion = request.getParameter("accion");

        if (accion == null)
        {
            accion = "listar";
        }

        switch (accion)
        {
            case "nuevo":
            mostrarFormulario(request, response);
            break;

            case "eliminar":
            eliminarUsuarios(request, response);
            break;

            case "listar":
            default:
                listarUsuarios(request, response);
                break;

        }

    }

    private void eliminarUsuarios(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    )throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");

        if("guardar".equals(accion))
        {
            guardarUsuarios(request, response);
        }
        else
        {
            response.sendRedirect(request.getContextPath() + "/usuarios"
            );
        }
    }

    private void guardarUsuarios(HttpServletRequest request, HttpServletResponse response) {
    }

    private void listarUsuarios(
        HttpServletRequest request,
        HttpServletResponse response
) throws ServletException, IOException
{
    ArrayList<Usuarios> listaUsuarios =
            usuariosController.mostrar();
    request.setAttribute("listaUsuarios", listaUsuarios);

    request.getRequestDispatcher("/usuarios/listar.jsp")
            .forward(request, response);
}

private void mostrarFormulario(
        HttpServletRequest request,
        HttpServletResponse response
) throws ServletException, IOException
{
    request.getRequestDispatcher("/usuarios/formulario.jsp")
            .forward(request, response);
}
}

