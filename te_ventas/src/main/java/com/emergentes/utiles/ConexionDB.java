
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    static public String driver = "com.mysql.cj.jdbc.Driver";
    static public String url = "jdbc:mysql://localhost:3306/bd_ventas";
    static public String usuario = "root";
    static public String password = "";
    
    protected Connection conn = null;

    public ConexionDB() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
            if(conn != null){
                System.out.println("Conexion OK"+conn);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en especificacion de driver: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error al conextar: " + ex.getMessage());
        }
    }
    
    public Connection conectar(){
        return conn;
    }
    
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar: "+ex.getMessage());
        }
    }
}
