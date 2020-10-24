/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsongui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author luukw
 */
public class Overzicht {

    Database db = new Database();

    public Overzicht(Stage stageOverzicht, Scene sceneLogin) {

        TableView<Auto> tableOverzicht = new TableView();
        tableOverzicht.setPrefWidth(360.0);

        TableColumn kenteken = new TableColumn();
        kenteken.setText("Kenteken");

        TableColumn merk = new TableColumn();
        merk.setText("Merk");

        TableColumn handelsbenaming = new TableColumn();
        handelsbenaming.setText("Handelsbenaming");

        TableColumn eersteKleur = new TableColumn();
        eersteKleur.setText("Eerste Kleur");

        TableColumn TweedeKleur = new TableColumn();
        TweedeKleur.setText("Tweede Kleur");

        TableColumn Voertuigsoort = new TableColumn();
        Voertuigsoort.setText("Voertuigsoort");

        TableColumn APK = new TableColumn();
        APK.setText("APK");

        TableColumn TaxiIndicator = new TableColumn();
        TaxiIndicator.setText("TaxiIndicator");

        kenteken.setCellValueFactory(new PropertyValueFactory<>("Kenteken"));
        merk.setCellValueFactory(new PropertyValueFactory<>("Merk"));
        handelsbenaming.setCellValueFactory(new PropertyValueFactory<>("Handelsbenaming"));
        eersteKleur.setCellValueFactory(new PropertyValueFactory<>("EersteKleur"));
        TweedeKleur.setCellValueFactory(new PropertyValueFactory<>("TweedeKleur"));
        Voertuigsoort.setCellValueFactory(new PropertyValueFactory<>("Voertuigsoort"));
        APK.setCellValueFactory(new PropertyValueFactory<>("APK"));
        TaxiIndicator.setCellValueFactory(new PropertyValueFactory<>("TaxiIndicator"));

        tableOverzicht.setItems(db.getAutos());
        tableOverzicht.getColumns().addAll(kenteken, merk, handelsbenaming, eersteKleur, TweedeKleur, APK, Voertuigsoort, TaxiIndicator);

   
        tableOverzicht.setOnMouseClicked(e -> {
            Auto auto = tableOverzicht.getSelectionModel().getSelectedItem();
            //auto.getKenteken();
            System.out.println(auto.getKenteken());
        });

        Button btnZoek = new Button("Naar Zoekscherm");
        Button btnLogout = new Button("Logout");
        Button btnDelete = new Button("Delete Auto");

        btnZoek.setOnAction(e -> {
            ZoekClass zoekscherm = new ZoekClass(stageOverzicht, sceneLogin);

        }
        );

        btnLogout.setOnAction(e -> {
            stageOverzicht.setScene(sceneLogin);
        });

        btnDelete.setOnAction(e -> {
            Auto auto = tableOverzicht.getSelectionModel().getSelectedItem();
            System.out.println(auto.getKenteken());
            String sKenteken = auto.getKenteken();
            db.deleteAuto(sKenteken);
            Overzicht overzichtScherm = new Overzicht(stageOverzicht,sceneLogin);
        });

        VBox vbOverzicht = new VBox();
        vbOverzicht.setSpacing(5);
        vbOverzicht.setPadding(new Insets(10, 10, 10, 10));
        vbOverzicht.getChildren().addAll(tableOverzicht, btnZoek, btnDelete, btnLogout);

        Scene sceneOverzicht = new Scene(vbOverzicht, 1080, 920);

        stageOverzicht.setScene(sceneOverzicht);
        stageOverzicht.setTitle("Overzicht");
        stageOverzicht.show();
    }


}
