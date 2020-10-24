package jsongui;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Window;

//opstartklasse

/**
 *
 * @author Gebruiker
 */
public class JSONGUI extends Application {
    Database db = new Database();
    
    
    String checkUser, checkPw;

    @Override
    public void start(Stage primaryStage) throws Exception {
      
        primaryStage.setTitle("Login Politie");
               
        
        GridPane gridPaneLogin = new GridPane();
             
        Scene sceneLogin = new Scene(gridPaneLogin, 800, 500);
        // Aet GridPane position
        gridPaneLogin.setAlignment(Pos.CENTER);

        // Set padding
        gridPaneLogin.setPadding(new Insets(20, 20, 20, 20));

        // Set horizontal gap
        gridPaneLogin.setHgap(10);

        // Set vertical gap
        gridPaneLogin.setVgap(10);

        // Add Column Constraints

        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        ColumnConstraints columnTwoConstrains = new ColumnConstraints(100,100, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        //Add ColumnConstraints to gridpane
        gridPaneLogin.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        // Add Header
        Label headerLabel = new Label("Login Politie");
        headerLabel.setFont(Font.font("Calibri", FontWeight.BOLD, 20));
        gridPaneLogin.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(10, 0, 10, 0));

        // Add Name Label
        Label nameLabel = new Label("Loginnnaam: ");
        nameLabel.maxWidth(100);
        gridPaneLogin.add(nameLabel, 0,1);
        

        // Add Name Text Field
        TextField nameField = new TextField("");
        nameField.setPrefHeight(40);
        nameField.setMaxWidth(350);
        GridPane.setHalignment(nameField, HPos.CENTER);
        gridPaneLogin.add(nameField, 1,1);

        // Add Password
        Label passwordLabel = new Label("Wachtwoord: ");
        passwordLabel.maxWidth(100);
        gridPaneLogin.add(passwordLabel, 0, 2);

        // Add Email Text Field
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(40);
        passwordField.setMaxWidth(350);
        GridPane.setHalignment(passwordField, HPos.CENTER);
        gridPaneLogin.add(passwordField, 1, 2);

        // Add Login Button
        Button loginButton = new Button("Login");
        loginButton.setPrefHeight(40);
        loginButton.setDefaultButton(true);
        loginButton.setPrefWidth(100);
        gridPaneLogin.add(loginButton, 0, 4, 2, 1);
        GridPane.setHalignment(loginButton, HPos.CENTER);
        GridPane.setMargin(loginButton, new Insets(20, 0, 20, 0));
        
        //Error Label
        Label labelMessage = new Label();
        gridPaneLogin.add(labelMessage, 0, 4, 2, 1);
        
        
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(nameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPaneLogin.getScene().getWindow(), "Form Error!", "Vul je gebruikersnaam in");
                    return;
                }


                if(passwordField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPaneLogin.getScene().getWindow(), "Form Error!", "Vul je wachtwoord in");
                    return;
                }
                
                checkUser = nameField.getText();
                checkPw = passwordField.getText();
                if(checkUser.equals(db.GetUser(nameField.getText(), passwordField.getText())) && checkPw.equals(db.GetPassword(nameField.getText(), passwordField.getText()))){
               ZoekClass zoekClass = new ZoekClass (primaryStage, sceneLogin);
                            
            }
                else{
           labelMessage.setText("Ongeldige gebruikersnaam of wachtwoord");
           labelMessage.setTextFill(Color.web("#FF0000"));
          }
          nameField.setText("");
          passwordField.setText("");
         }
         });
        
        // Create the registration form grid pane
        
        
        // Add UI controls to the registration form grid pane
        // Set the scene in primary stage	
        primaryStage.setScene(sceneLogin);
        
        primaryStage.show();
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}