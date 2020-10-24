/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsongui;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author luukw
 */
public class ZoekClass {
    
    public ZoekClass(Stage stageZoek, Scene sceneLogin){
        
        try {
            
           
            Database db = new Database();
            DatabaseJSON dbJ = new DatabaseJSON();
                        
            GridPane gridPaneZoek = new GridPane();
            Scene sceneZoek = new Scene(gridPaneZoek, 800, 500);
            gridPaneZoek.setVgap(10);
            gridPaneZoek.setHgap(15);
            gridPaneZoek.setAlignment(Pos.CENTER);
            
            Label labKenteken = new Label("Vul kenteken in");            
            TextField txtKenteken = new TextField();
            txtKenteken.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
            }));
            
            Button butZoek = new Button("Zoeken");
            Button btnAdd = new Button ("Voeg auto toe");
            Button btnOverzicht = new Button("Overzicht");
            Button btnLogout = new Button ("Logout");
            
            Label labMerk = new Label("Merk");
            TextField txtMerk = new TextField();
            txtMerk.setEditable(false);
            
            Label labVoertuigsoort = new Label("Voertuigsoort");
            TextField txtVoertuigsoort = new TextField();
            txtMerk.setEditable(false);
            
            Label labAPK = new Label("Vervaldatum APK");
            TextField txtAPK = new TextField();
            txtMerk.setEditable(false);
            
            Label labTaxi = new Label("Taxi indicator");
            TextField txtTaxi = new TextField();
            txtMerk.setEditable(false);
            
            Label labHandelsbenaming = new Label("Handelsbenaming");
            TextField txtHandelsbenaming = new TextField();
            txtHandelsbenaming.setEditable(false);
            
            Label labelEersteKleur = new Label("Eerste Kleur");
            TextField txtEersteKleur = new TextField();
            txtEersteKleur.setEditable(false);
            
            Label labTweedeKleur = new Label("Tweede Kleur");
            TextField txtTweedeKleur = new TextField();
            txtMerk.setEditable(false);
            
            btnLogout.setOnAction(e -> {
            stageZoek.setScene(sceneLogin);
            });
            
            btnOverzicht.setOnAction(e -> {
                Overzicht overzichtScherm = new Overzicht(stageZoek,sceneLogin);
            });
            
            butZoek.setOnAction ( event ->{
                
              dbJ.GetKenteken(txtKenteken.getText());
              
              
              txtMerk.setText(dbJ.GetMerk());
              txtHandelsbenaming.setText(dbJ.GetHandelsbenaming());
              txtEersteKleur.setText(dbJ.GetEersteKleur());
              txtTweedeKleur.setText(dbJ.GetTweedeKleur());
              txtVoertuigsoort.setText(dbJ.GetVoertuigsoort());
              txtAPK.setText(dbJ.GetVervalAPK());
              txtTaxi.setText(dbJ.GetTaxi());
              
            });
            
            btnAdd.setOnAction(e -> {
                
                String sKenteken = txtKenteken.getText();
                String sMerk = txtMerk.getText();
                String sHandelnaam = txtHandelsbenaming.getText();
                String sEerste_Kleur = txtEersteKleur.getText();
                String sTweede_Kleur = txtTweedeKleur.getText();
                String sVoertuigsoort = txtVoertuigsoort.getText();
                String sAPK = txtAPK.getText();
                String sTaxiIndicator = txtTaxi.getText();
                
                db.AddAuto(sKenteken, sMerk, sHandelnaam, sEerste_Kleur, sTweede_Kleur, sVoertuigsoort, sAPK, sTaxiIndicator);
                               
            });
            
           
            
            
            
            gridPaneZoek.add(labKenteken, 0, 0);
            gridPaneZoek.add(txtKenteken, 1 ,0);
            gridPaneZoek.add(butZoek, 1, 2);
            
            gridPaneZoek.add(labMerk, 0, 3);
            gridPaneZoek.add(txtMerk, 1 ,3);
            
            gridPaneZoek.add(labVoertuigsoort, 0, 5);
            gridPaneZoek.add(txtVoertuigsoort, 1 ,5);
            
            gridPaneZoek.add(labHandelsbenaming, 0, 4);
            gridPaneZoek.add(txtHandelsbenaming, 1, 4);
            
            gridPaneZoek.add(labelEersteKleur, 0, 6);
            gridPaneZoek.add(txtEersteKleur, 1, 6);
            
            gridPaneZoek.add(labTweedeKleur, 0, 7);
            gridPaneZoek.add(txtTweedeKleur, 1, 7);
            
            gridPaneZoek.add(labAPK, 0, 8);
            gridPaneZoek.add(txtAPK, 1, 8);
            
            gridPaneZoek.add(labTaxi, 0, 9);
            gridPaneZoek.add(txtTaxi, 1, 9);
                       
            gridPaneZoek.add(btnAdd, 1, 10);
            gridPaneZoek.add(btnOverzicht, 1, 11);
            gridPaneZoek.add(btnLogout, 2, 11);
            
            
            stageZoek.setScene(sceneZoek);
            stageZoek.setTitle("Krijg gevens via kenteken");

            
        } catch (SQLException ex) {
            Logger.getLogger(JSONGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
