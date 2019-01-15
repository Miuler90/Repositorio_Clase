<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Productos</title>
        <style type="text/css">
            .tablaRegistrar
            {
                margin: 0 auto;
            }
        </style>
    </head>
    <body>
        <%@include file="encabezado.jsp" %>
        <form action="controladorProducto">
            <table class="tablaRegistrar">
                <tr>
                    <th colspan="2">
                        Formulario de Registro
                    </th>
                </tr>
                <tr>
                    <td>
                        Categoria:
                    </td>
                    <td>
                        <input type="text" name="txtCategoria" placeholder="Ingrese Categoria" required />
                    </td>
                </tr>
                <tr>
                    <td>
                        Nombre:
                    </td>
                    <td>
                        <input type="text" name="txtNombre" placeholder="Ingrese Nombre" required />
                    </td>
                </tr>
                <tr>
                    <td>
                        Precio:
                    </td>
                    <td>
                        <input type="number" name="txtPrecio" placeholder="Ingrese Precio" step="0.01" min="0" required />
                    </td>
                </tr>
                <tr>
                    <td>
                        Stock:
                    </td>
                    <td>
                        <input type="number" name="txtStock" placeholder="Ingrese Stock" step="1" min="0" required />
                    </td>
                </tr>
                <tr>
                    <td>
                        Pais Origen:
                    </td>
                    <td>
                        <input type="text" name="txtPaisOrigen" placeholder="Ingrese País de Origen" required />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center">
                        <input type="submit" name="accion" value="Registrar" />
                        &nbsp;
                        <input type="reset" value="Nuevo" />
                        &nbsp;
                        <input type="button" value="Regresar" onclick="window.location.href='controladorProducto'" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>