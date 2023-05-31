/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movie;

import java.sql.*;

/**
 *
 * @author PC PRAKTIKUM
 */
public class connector {
    public class Connector {
    private String DBurl = "http://localhost/phpmyadmin/index.php?route=/table/structure&db=movie&table=movie";
    private String DBusername = "root";
    private String DBpassword = "";
    private Connection connection;
    Statement statement;
    public Connector(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Koneksi Berhasil");
        }
        catch(Exception ex){
            System.out.println("Connection Failed");
        }
    }
    
    public Connection getConnection(){
        return connection;
    }
}
}
