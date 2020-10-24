/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsongui;

import java.net.URI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.prefs.Preferences;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author Gebruiker
 */
public class DatabaseJSON {
    
    public static String sKentekenIn;
    
        public DatabaseJSON() throws SQLException{
        
        }
            
            
             public String GetKenteken(String sKenteken){
                 sKentekenIn = sKenteken;
                 
                 return sKentekenIn;
             }
             
             
             public String GetMerk(){
            
                 String Merk = "";
                 try{
                    URI uri = new URI("https://opendata.rdw.nl/resource/m9d7-ebf2.json?kenteken="+sKentekenIn);
                    JSONTokener tokener = new JSONTokener(uri.toURL().openStream());
                    JSONArray root = new JSONArray(tokener);

                    for (int i = 0; i < root.length(); ++i) {
                        JSONObject Json = root.getJSONObject(i);
                        Merk = Json.getString("merk");

                                                
                    }

                } catch (Exception e) {
                    System.out.println("kapot");
                }
                 return Merk;
             }

             public String GetHandelsbenaming(){
            
                 String Handelsbenaming = "";
                 try{
                    URI uri = new URI("https://opendata.rdw.nl/resource/m9d7-ebf2.json?kenteken="+sKentekenIn);
                    JSONTokener tokener = new JSONTokener(uri.toURL().openStream());
                    JSONArray root = new JSONArray(tokener);

                    for (int i = 0; i < root.length(); ++i) {
                        JSONObject Json = root.getJSONObject(i);
                        Handelsbenaming = Json.getString("handelsbenaming");
                                                
                                               
                    }

                } catch (Exception e) {
                }
                 return Handelsbenaming;
             }
             
            public String GetVoertuigsoort(){
            
                 String Voertuigsoort = "";
                 try{
                    URI uri = new URI("https://opendata.rdw.nl/resource/m9d7-ebf2.json?kenteken="+sKentekenIn);
                    JSONTokener tokener = new JSONTokener(uri.toURL().openStream());
                    JSONArray root = new JSONArray(tokener);

                    for (int i = 0; i < root.length(); ++i) {
                        JSONObject Json = root.getJSONObject(i);
                        Voertuigsoort = Json.getString("voertuigsoort");
                                                
                        System.out.println(Voertuigsoort);
                                               
                    }

                } catch (Exception e) {
                    System.out.println("kapot");
                }
                 return Voertuigsoort;
             }
             
            public String GetEersteKleur(){
            
                 String eersteKleur = "";
                 try{
                    URI uri = new URI("https://opendata.rdw.nl/resource/m9d7-ebf2.json?kenteken="+sKentekenIn);
                    JSONTokener tokener = new JSONTokener(uri.toURL().openStream());
                    JSONArray root = new JSONArray(tokener);

                    for (int i = 0; i < root.length(); ++i) {
                        JSONObject Json = root.getJSONObject(i);
                        eersteKleur = Json.getString("eerste_kleur");
                        
                        System.out.println(eersteKleur);
                      
                    }

                } catch (Exception e) {
                    System.out.println("kapot");
                }
                 return eersteKleur;
             }
            
            public String GetTweedeKleur(){
            
                 String tweedeKleur = "";
                 try{
                    URI uri = new URI("https://opendata.rdw.nl/resource/m9d7-ebf2.json?kenteken="+sKentekenIn);
                    JSONTokener tokener = new JSONTokener(uri.toURL().openStream());
                    JSONArray root = new JSONArray(tokener);

                    for (int i = 0; i < root.length(); ++i) {
                        JSONObject Json = root.getJSONObject(i);
                        tweedeKleur = Json.getString("tweede_kleur");
                        
                        System.out.println(tweedeKleur);

                    }

                } catch (Exception e) {
                    System.out.println("kapot");
                }
                 return tweedeKleur;
             }
            
            public String GetVervalAPK(){
            
                 String vervalAPK = "";
                 try{
                    URI uri = new URI("https://opendata.rdw.nl/resource/m9d7-ebf2.json?kenteken="+sKentekenIn);
                    JSONTokener tokener = new JSONTokener(uri.toURL().openStream());
                    JSONArray root = new JSONArray(tokener);

                    for (int i = 0; i < root.length(); ++i) {
                        JSONObject Json = root.getJSONObject(i);
                        vervalAPK = Json.getString("vervaldatum_apk");

                        System.out.println(vervalAPK);                     
                                                
                    }

                } catch (Exception e) {
                    System.out.println("kapot");
                }
                 return vervalAPK;
             }
            
            public String GetTaxi(){
            
                 String taxiIndicator = "";
                 try{
                    URI uri = new URI("https://opendata.rdw.nl/resource/m9d7-ebf2.json?kenteken="+sKentekenIn);
                    JSONTokener tokener = new JSONTokener(uri.toURL().openStream());
                    JSONArray root = new JSONArray(tokener);

                    for (int i = 0; i < root.length(); ++i) {
                        JSONObject Json = root.getJSONObject(i);
                        taxiIndicator = Json.getString("taxi_indicator");
                        
                        System.out.println(taxiIndicator);                   
                                                
                    }

                } catch (Exception e) {
                    System.out.println("kapot");
                }
                 return taxiIndicator;
             }
             
             
}


                  
    
    

