/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Emperor
 */
public class DBConnector {

    private static Connection conn;
    
     public DBConnector() {
        conn = null;
    }
     
    public static Connection conDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");//register the JDBC driver
            conn = DriverManager.getConnection("jdbc:mysql://localhost/user_record","root","");
            return conn;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("DataBase not connected " + ex.getMessage());
        }
        return null;
    }

   
    
    
}
