package Operaciones;

import java.sql.*;
import Conexion.Driver;

public class ActualizarDatos {
    private String marca, nombre, tipoPrenda, dao, descripcion;
    private int precioCompra, precioVenta, existencia, categoria;
    Connection cn = Driver.conectar();

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoPrenda(String tipoPrenda) {
        this.tipoPrenda = tipoPrenda;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
    
    public void setDao(String dao) {
        this.dao = dao;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    public void actualizar(){
        try{
            String SQL = "update prenda set marca=?, nombre=?, precioCompra=?, precioVenta=?, existencia=?, descripcion=? where idPrenda=?";
            
            PreparedStatement pst = cn.prepareStatement(SQL);
            pst.setString(1,marca);
            pst.setString(2,nombre);
            pst.setInt(3,precioCompra);
            pst.setInt(4,precioVenta);
            pst.setInt(5,existencia);
            pst.setString(6,descripcion);
            pst.setString(7,dao);
            
            PreparedStatement pst2 = cn.prepareStatement("update departamento set categoria=?, tipoPrenda=? where idDepartamento=?");
            pst2.setInt(1,categoria);
            pst2.setString(2,tipoPrenda);
            pst2.setString(3,dao);
            pst.execute();
            pst2.execute();
            System.out.println("Todo correcto");
        }
        catch(SQLException e){
            System.out.println("error " + e);
        }
    }
}