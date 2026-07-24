<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registrar usuarios</title>
</head>
<body>

<h1>Registrar usuarios</h1>

<form action="<%= request.getContextPath() %>/usuarios"
      method="post">

    <input type="hidden"
           name="accion"
           value="guardar">

    <label for="nombre">Nombre:</label>
    <input type="text"
           id="nombre"
           name="nombre"
           required>

    <br><br>

    <label for="apellido">Apellido:</label>
    <input type="text"
           id="apellido"
           name="apellido"
           required>

    <br><br>

    <label for="documento">Documento:</label>
    <input type="text"
           id="documento"
           name="documento"
           required>

    <br><br>

    <label for="telefono">Teléfono:</label>
    <input type="text"
           id="telefono"
           name="telefono"
           required>

    <br><br>

    <label for="correo">Correo:</label>
    <input type="email"
           id="correo"
           name="correo"
           required>

    <br><br>

    <select id="tipo_usuario" name="tipo_usuario" required>
        <option value="" disabled selected>Seleccione una opción</option>
        <option value="propietario">Propietario</option>
        <option value="arrendatario">Arrendatario</option>
        <option value="visitante">Visitante</option>
        <option value="administrador">Administrador</option>
    </select>

    <br><br>

    <label for="estado">Estado:</label>
    <select id="estado" name="estado" required>
        <option value="" disabled selected>Seleccione un estado</option>
        <option value="1">Activo</option>
        <option value="0">Inactivo</option>
    </select>

    <br><br>

    <button type="submit">
        Guardar
    </button>

    <a href="<%= request.getContextPath() %>/usuarios">
        Cancelar
    </a>

</form>

</body>
</html>