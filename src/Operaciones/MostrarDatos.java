package Operaciones;

import Conexion.Driver;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class MostrarDatos {
    
    Connection cn = Driver.conectar();
    String titulos[] = {"idPrenda", "marca", "nombre", "precioCompra", "precioVenta", "existencia", "descripcion", "tipoPrenda"};
    String registros[] = new String[8];
    DefaultTableModel modelo = new DefaultTableModel(null,titulos);
    String SQL = "select prenda.idPrenda, marca, nombre, precioCompra, precioVenta, existencia, descripcion, tipoPrenda\n" +
        "from prenda, pertenece, departamento\n" +
        "where prenda.idPrenda = pertenece.idPrenda\n" +
        "and pertenece.idDepartamento = departamento.idDepartamento\n" +
        "and prenda.idPrenda >= 1";
        
    public void obtener(){       
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next()){
                registros[0] = rs.getString("idPrenda");
                registros[1] = rs.getString("marca");
                registros[2] = rs.getString("nombre");
                registros[3] = rs.getString("precioCompra");
                registros[4] = rs.getString("precioVenta");
                registros[5] = rs.getString("existencia");
                registros[6] = rs.getString("descripcion");
                registros[7] = rs.getString("tipoPrenda");
                modelo.addRow(registros);
            }
        }
        catch(SQLException e){}
    }
    
    public DefaultTableModel getModelo(){
        return modelo;
    }
}