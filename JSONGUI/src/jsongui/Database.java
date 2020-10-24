/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsongui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author luukw
 */
public class Database {
    

    Connection con;
    Statement stm;
    ResultSet rset;
            
 public Database(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3309/kenteken?user=root&password=password");
            stm = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error");
        }
     
 }
 
     public boolean AddAuto(String sKenteken, String sMerk, String sHandelnaam, String sEerste_Kleur, String sTweede_Kleur, String sVoertuigsoort, String sAPK, String sTaxiIndicator){
        String sSquery = "INSERT INTO kenteken(Kenteken, Merk, Handelsbenaming, Eerste_Kleur, Tweede_Kleur, Voertuigsoort, APK, TaxiIndicator) VALUES ('" + sKenteken + "', '" + sMerk + "', '" + sHandelnaam + "', '" + sEerste_Kleur + "', '" + sTweede_Kleur + "', '" + sVoertuigsoort + "', '" + sAPK + "', '" + sTaxiIndicator + "')";
        
        System.out.println(sSquery);
        try {
            // Eerst proberen om om te zetten naar een statement
            stm = con.createStatement();
            // Kijken of de query wordt uitgevoerd
            if(stm.execute(sSquery)){    
                // Vind het altijd fijn om te checken   
                System.out.println("Query is naar de database gegaan");
                // Teruggeven dat het goed is gegaan
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Niet gelukt");
            return false;
        }
        
        return false;
    }
     
public ObservableList<Auto> getAutos(){
        // Array maken
        ObservableList<Auto> Autos = FXCollections.observableArrayList();
        
        String sQuery = "SELECT*FROM kenteken";
        try{
            stm = con.createStatement();
            
            stm.executeQuery(sQuery);
            
            rset = stm.getResultSet();
            
            while(rset.next()){
                // Array.VoegToe.resultaten
                Auto auto = new Auto(rset.getString("Kenteken"), rset.getString("Merk"), rset.getString("Handelsbenaming"), rset.getString("Eerste_Kleur"), rset.getString("Tweede_Kleur"), rset.getString("Voertuigsoort"), rset.getString("APK"), rset.getString("TaxiIndicator"));
                Autos.add(auto);
            }
        }catch(SQLException ex){
            System.out.println("Fout");
        }
        
        return Autos;
    
    }



public boolean deleteAuto(String sKenteken){
    
        String sSquery = "DELETE FROM kenteken WHERE Kenteken = '"+sKenteken+"'";
        
        System.out.println(sSquery);
        try {
            // Eerst proberen om om te zetten naar een statement
            stm = con.createStatement();
            // Kijken of de query wordt uitgevoerd
            if(stm.execute(sSquery)){    
                // Vind het altijd fijn om te checken   
                System.out.println("Query is naar de database gegaan");
                // Teruggeven dat het goed is gegaan
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Auto niet verwijderd");
            return false;
        }
        
        return false;
    }



    public ObservableList<Login> getLogin(String sUsername, String sPassword){
        // Array maken
        ObservableList<Login> log = FXCollections.observableArrayList();
        
        String sQuery = "SELECT * FROM login WHERE username = '"+sUsername+"' AND password = '"+sPassword+"'";;
        
        try{
            stm = con.createStatement();
            
            
            stm.executeQuery(sQuery);
            
            rset = stm.getResultSet();
            
            while(rset.next()){
                // Array.VoegToe.resultaten
                Login login = new Login(rset.getString("username"), rset.getString("password"));
                Login.add(login);
            }
        }catch(SQLException ex){
            System.out.println("Fout");
        }
        
        return log;
        
    
    }
    
    public String GetUser(String sUsername, String sPassword){
        
        String SQLQuery = "SELECT * FROM login WHERE username = '"+sUsername+"' AND password = '"+sPassword+"'";;
        try {
            stm = con.createStatement();
            
            if(stm.execute(SQLQuery)){
                rset = stm.getResultSet();
                
                while(rset.next()){
                    String username = rset.getString("username");
                    
                    return username;
                }
            }

        } catch (Exception e){

        }
        return "Error";
    
}
    
    public String GetPassword(String sUsername, String sPassword){
        
        String SQLQuery = "SELECT * FROM login WHERE username = '"+sUsername+"' AND password = '"+sPassword+"'";;
        try {
            stm = con.createStatement();
            
            if(stm.execute(SQLQuery)){
                rset = stm.getResultSet();
                
                while(rset.next()){
                    String password = rset.getString("password");
                    
                    return password;
                }
            }

        } catch (Exception e){

        }
        return "Error";
    
}

}
