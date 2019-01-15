package Controladores;

import Modelos.claseProducto;
import Modelos.modeloProducto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "controladorProducto", urlPatterns = {"/controladorProducto"})
public class controladorProducto extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if(accion==null)
        {
            accion = "Listar";
        }
        switch(accion)
        {
            case "Listar":
                listarProductos(request, response);
                break;
            case "Registrar":
                registrarProducto(request, response);
                break;
            case "Cargar":
                cargarProducto(request, response);
                break;
            case "Actualizar":
                actualizarProducto(request, response);
                break;
            case "Eliminar":
                eliminarProducto(request, response);
                break;
        }
    }
    
    public void listarProductos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try 
        {
            List<claseProducto> productos;
            modeloProducto mP = new modeloProducto();
            productos = mP.obtenerProductos();
            request.setAttribute("productos", productos);
            request.getRequestDispatcher("/listarProductos.jsp").forward(request, response);
        }
        catch (Exception e) 
        {
            request.setAttribute("error", e);
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
    
    public void registrarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try 
        {
            String categoria = request.getParameter("txtCategoria");
            String nombre = request.getParameter("txtNombre");
            double precio = Double.parseDouble(request.getParameter("txtPrecio"));
            int stock = Integer.parseInt(request.getParameter("txtStock"));
            String paisOrigen = request.getParameter("txtPaisOrigen");
            claseProducto nuevoProducto = new claseProducto(categoria, nombre, precio, stock, paisOrigen);
            modeloProducto mP = new modeloProducto();
            mP.registrarProducto(nuevoProducto);
            response.sendRedirect("controladorProducto");
        }
        catch (Exception e) 
        {
            request.setAttribute("error", e);
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
    
    public void cargarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try 
        {
            int id = Integer.parseInt(request.getParameter("id"));
            modeloProducto mP = new modeloProducto();
            claseProducto productoCargado = mP.cargarProducto(id);
            request.setAttribute("productoCargado", productoCargado);
            request.getRequestDispatcher("/actualizarProducto.jsp").forward(request, response);
        }
        catch (Exception e) 
        {
            request.setAttribute("error", e);
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
    
    public void actualizarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try 
        {
            int id = Integer.parseInt(request.getParameter("id"));
            String categoria = request.getParameter("txtCategoria");
            String nombre = request.getParameter("txtNombre");
            double precio = Double.parseDouble(request.getParameter("txtPrecio"));
            int stock = Integer.parseInt(request.getParameter("txtStock"));
            String paisOrigen = request.getParameter("txtPaisOrigen");
            
            claseProducto productoActualizado = new claseProducto(id, categoria, nombre, precio, stock, paisOrigen);
            modeloProducto mP = new modeloProducto();
            mP.actualizarProducto(productoActualizado);
            response.sendRedirect("controladorProducto");
        }
        catch (Exception e) 
        {
            request.setAttribute("error", e);
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
    
    public void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try 
        {
            int id = Integer.parseInt(request.getParameter("id"));
            modeloProducto mP = new modeloProducto();
            mP.eliminarProducto(id);
            response.sendRedirect("controladorProducto");
        }
        catch (Exception e) 
        {
            request.setAttribute("error", e);
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}