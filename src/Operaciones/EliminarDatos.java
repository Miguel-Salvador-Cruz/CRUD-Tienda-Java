package Operaciones;

import java.sql.*;
import Conexion.Driver;

public class EliminarDatos {
    String SQL, SQL2;
    int n , m;
    Connection cn = Driver.conectar();

    public void setFilaSeleccionada(String SQL) {
        this.SQL = SQL;
    }
    
    public void setFilaSeleccionada2(String SQL2) {
        this.SQL2 = SQL2;
    }

    public void eliminar(){
        try{
            Statement st = cn.createStatement();
            n = st.executeUpdate(SQL);
            m = st.executeUpdate(SQL2);
            if(n>=0){
                System.out.println("Registro eliminado");
            }
        }
        catch(SQLException e){
            System.out.println("error " + e);
        }
    }

}