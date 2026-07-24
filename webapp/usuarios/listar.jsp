<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Usuarios" %>

<%
    ArrayList<Usuarios> listaUsuarios =
            (ArrayList<Usuarios>) request.getAttribute("listaUsuarios");
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Usuarios</title>
</head>
<body>

<h1>Lista de usuarios</h1>

<a href="<%= request.getContextPath() %>/usuarios?accion=nuevo">
    Registrar usuarios
</a>

<br><br>

<table border="1">
    <thead>
    <tr>
        <th>id_usuarios</th>
        <th>nombre</th>
        <th>apellido</th>
        <th>documento</th>
        <th>telefono</th>
        <th>correo</th>
        <th>tipo_usuario</th>
        <th>estado</th>
        <th>Acciones</th>
    </tr>
    </thead>

    <tbody>

    <%
        if (listaUsuarios != null && !listaUsuarios.isEmpty()) {
            for (Usuarios usuarios : listaUsuarios) {
    %>

    <tr>
        <td><%= usuarios.getId_usuarios() %></td>
        <td><%= usuarios.getNombre() %></td>
        <td><%= usuarios.getApellido() %></td>
        <td><%= usuarios.getDocumento() %></td>
        <td><%= usuarios.getTelefono() %></td>
        <td><%= usuarios.getCorreo() %></td>
        <td><%= usuarios.getTipo_usuario() %></td>
        <td><%= usuarios.getEstado() %></td>

        <td>
            <a href="<%= request.getContextPath() %>/usuario?accion=eliminar&id=<%= usuarios.getId_usuarios() %>"
               onclick="return confirm('¿Desea eliminar este usuario?')">
                Eliminar
            </a>
        </td>
    </tr>

    <%
        }
    } else {
    %>

    <tr>
        <td colspan="7">
            No hay usuarios registrados.
        </td>
    </tr>

    <%
        }
    %>

    </tbody>
</table>

<br>

<a href="<%= request.getContextPath() %>/">
    Volver al inicio
</a>

</body>
</html>