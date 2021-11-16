package Operaciones;

import java.sql.*;
import Conexion.Driver;

public class RegistrarDatos {
    private String marca, nombre, tipoPrenda, descripcion;
    private int precioCompra, existencia, categoria, precioVenta;
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
    
    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
        
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public void ingresarDatos(){
        try{
            String SQL = "insert into prenda (marca, nombre, precioCompra, precioVenta, existencia, descripcion) values (?,?,?,?,?,?)";
            PreparedStatement pst = cn.prepareStatement(SQL);
            pst.setString(1,marca);
            pst.setString(2,nombre);
            pst.setInt(3,precioCompra);
            pst.setInt(4,precioVenta);
            pst.setInt(5,existencia);
            pst.setString(6,descripcion);
            
            PreparedStatement pst2 = cn.prepareStatement("insert into departamento (categoria, tipoPrenda) values (?,?)");
            pst2.setInt(1,categoria);
            pst2.setString(2,tipoPrenda);
            pst.execute();
            pst2.execute();
            
            String buscar = "select max(idPrenda) as idPrenda from prenda";
            PreparedStatement pts = cn.prepareStatement(buscar);
            ResultSet rs = pts.executeQuery();
            
            PreparedStatement pst3 = cn.prepareStatement("insert into pertenece (idPrenda, idDepartamento) values (?,?)");
            if(rs.next()){
                pst3.setInt(1,Integer.parseInt(rs.getString("idPrenda")));
                pst3.setInt(2,Integer.parseInt(rs.getString("idPrenda")));
            }
            pst3.execute();
                System.out.println("Todo correcto");
        }
        catch(SQLException e){
            System.out.println("error " + e);
        }
    }
    
}
