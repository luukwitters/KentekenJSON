/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsongui;

/**
 *
 * @author luukw
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DbConnector {
    Connection con;
    Statement stm;
    ResultSet rset;
    
    // Constructor
    
        public DbConnector() {
        try {
            // Query maken
            con = DriverManager.getConnection("jdbc:mysql://localhost:3309/kenteken?user=root&password=password");
            // Van de query een statement maken die naar de database kan
            stm = con.createStatement();
        } catch (SQLException error) { 
            // error in de log zetten
            System.out.println(error);
        }

    }
   
}