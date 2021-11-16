package Conexion;

import java.sql.*;

public class Driver {
    public static Connection conectar(){
        
        try{
           Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/Tienda", "salvador", "Galletas1.");
           return cn;
        }
        catch(SQLException e){
            System.out.println("Error en la conexión " + e);
        }
        return (null);
    }
}