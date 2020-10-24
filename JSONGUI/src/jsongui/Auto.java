/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsongui;

import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author luukw
 */
public class Auto {
    
    private final String kenteken;
    private final String Merk;
    private final String Handelsbenaming;
    private final String EersteKleur;
    private final String TweedeKleur;
    private final String Voertuigsoort;
    private final String APK;
    private final String TaxiIndicator;
    
    public Auto(String sKenteken, String sMerk, String sHandelsbenaming, String sEersteKleur, String sTweedeKleur, String sVoertuigsoort, String sAPK, String sTaxiIndicator){
        
        this.kenteken = sKenteken;
        this.Merk = sMerk;
        this.Handelsbenaming = sHandelsbenaming;
        this.EersteKleur = sEersteKleur;
        this.TweedeKleur = sTweedeKleur;
        this.Voertuigsoort = sVoertuigsoort;
        this.APK = sAPK;
        this.TaxiIndicator = sTaxiIndicator;
                       
    }
    
    //Getters

    public String getKenteken() {
        return kenteken;
    }

    public String getMerk() {
        return Merk;
    }

    public String getHandelsbenaming() {
        return Handelsbenaming;
    }

    public String getEersteKleur() {
        return EersteKleur;
    }

    public String getTweedeKleur() {
        return TweedeKleur;
    }

    public String getVoertuigsoort() {
        return Voertuigsoort;
    }

    public String getAPK() {
        return APK;
    }

    public String getTaxiIndicator() {
        return TaxiIndicator;
    }

    
    @Override
    public String toString() {
        return "Auto{" + "kenteken=" + kenteken + ", Merk=" + Merk + ", Handelsbenaming=" + Handelsbenaming + ", EersteKleur=" + EersteKleur + ", TweedeKleur=" + TweedeKleur + ", Voertuigsoort=" + Voertuigsoort + ", APK=" + APK + ", TaxiIndicator=" + TaxiIndicator + '}';
    }

}
