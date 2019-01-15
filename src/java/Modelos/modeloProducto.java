package Modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class modeloProducto 
{
    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;
    
    public List<claseProducto> obtenerProductos() throws Exception
    {
        List<claseProducto> productos = new ArrayList<>();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtienda","root","");
            st = con.createStatement();
            String sql = "SELECT * FROM productos";
            rs = st.executeQuery(sql);
            while(rs.next())
            {
                int id = rs.getInt("id");
                String categoria = rs.getString("categoria");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                String paisOrigen = rs.getString("paisOrigen");
                claseProducto productoTemporal = new claseProducto(id, categoria, nombre, precio, stock, paisOrigen);
                productos.add(productoTemporal);
            }
            con.close();
            st.close();
            rs.close();
            return productos;
        } 
        catch (Exception e)
        {
            throw e;
        }
    }
    
    public void registrarProducto(claseProducto nuevoProducto) throws Exception
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtienda","root","");
            st = con.createStatement();
            String sql = "INSERT INTO productos(categoria, nombre, precio, stock, paisOrigen) VALUES('"+nuevoProducto.getCategoria()+"','"+nuevoProducto.getNombre()+"','"+nuevoProducto.getPrecio()+"','"+nuevoProducto.getStock()+"','"+nuevoProducto.getPaisOrigen()+"')";
            st.executeUpdate(sql);
            con.close();
            st.close();
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    
    public claseProducto cargarProducto(int id) throws Exception
    {
        claseProducto productoCargado = null;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtienda","root","");
            st = con.createStatement();
            String sql = "SELECT * FROM productos WHERE id='"+id+"'";
            rs = st.executeQuery(sql);
            if(rs.next())
            {
                String categoria = rs.getString("categoria");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                String paisOrigen = rs.getString("paisOrigen");
                productoCargado = new claseProducto(id, categoria, nombre, precio, stock, paisOrigen);
            }
            con.close();
            st.close();
            rs.close();
            return productoCargado;
        }
        catch (Exception e) 
        {
            throw e;
        }
    }
    
    public void actualizarProducto(claseProducto productoActualizado) throws Exception
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtienda","root","");
            st = con.createStatement();
            String sql = "UPDATE productos SET categoria='"+productoActualizado.getCategoria()+"', nombre='"+productoActualizado.getNombre()+"', precio='"+productoActualizado.getPrecio()+"', stock='"+productoActualizado.getStock()+"', paisOrigen='"+productoActualizado.getPaisOrigen()+"' WHERE id='"+productoActualizado.getId()+"'";
            st.executeUpdate(sql);
            con.close();
            st.close();
        }
        catch (Exception e) 
        {
            throw e;
        }
    }
    
    public void eliminarProducto(int id) throws Exception
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtienda","root","");
            st = con.createStatement();
            String sql = "DELETE FROM productos WHERE id='"+id+"'";
            st.executeUpdate(sql);
            con.close();
            st.close();
        }
        catch (Exception e) 
        {
            throw e;
        }
    }
    
}