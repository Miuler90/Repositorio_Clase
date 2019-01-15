<%@page import="java.util.List"%>
<%@page import="Modelos.claseProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Productos</title>
        <style type="text/css">
            .tablaProductos
            {
                float: left;
            }
            .encabezados
            {
                background: #00cc33;
            }
            .resultados
            {
                background: #99ff99;
                text-align: center;
            }
        </style>
    </head>
    <%
        List<claseProducto> productos = (List<claseProducto>)request.getAttribute("productos");
    %>
    <body>
        <%@include file="encabezado.jsp" %>
        <table class="tablaProductos">
            <tr class="encabezados">
                <th>Categoria</th>
                <th>Nombre</th>
                <th>Precio</th>
                <th>Stock</th>
                <th>País de Origen</th>
                <th>Acciones</th>
            </tr>
            <%
                for (claseProducto productoTemporal : productos) 
                {
                    %>
                    <tr class="resultados">
                        <td><%=productoTemporal.getCategoria()%></td>
                        <td><%=productoTemporal.getNombre()%></td>
                        <td>S/. <%=productoTemporal.getPrecio()%></td>
                        <td><%=productoTemporal.getStock()%></td>
                        <td><%=productoTemporal.getPaisOrigen()%></td>
                        <td>
                            <a href="controladorProducto?accion=Cargar&id=<%=productoTemporal.getId()%>">Actualizar</a>
                            &nbsp;|&nbsp;
                            <a href="controladorProducto?accion=Eliminar&id=<%=productoTemporal.getId()%>">Eliminar</a>
                        </td>
                    </tr>
                    <%
                }
            %>
        </table>
        <input type="button" value="Nuevo Registro" onclick="window.location.href='registrarProducto.jsp'">
    </body>
</html>