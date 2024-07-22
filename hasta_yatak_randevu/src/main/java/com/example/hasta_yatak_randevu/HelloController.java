package com.example.hasta_yatak_randevu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;

import static com.example.hasta_yatak_randevu.Login.loadUsersFromFile;

public class HelloController {

    @FXML
    private AnchorPane ap;

    @FXML
    private AnchorPane ap1;

    @FXML
    private ImageView image;

    @FXML
    private Button loginbutton;

    @FXML
    private PasswordField password;


    @FXML
    private Text sonuc;

    @FXML
    private Button signupbutton;

    @FXML
    private SplitPane spane;

    @FXML
    private TextField tf;

    @FXML
    private Label titlelabel;

    @FXML
    private VBox vbox;
    @FXML
    private Button sidebutton1;

    @FXML
    private Button sidebutton2;

    @FXML
    private Button sidebutton3;

    @FXML
    void onloginclicked(ActionEvent event) {
        // Load users from the file
        loadUsersFromFile("users.txt");

        // Check if the entered username and password match any user
        String enteredUsername = tf.getText();
        String enteredPassword = password.getText();

        if (Login.validateCredentials(enteredUsername, enteredPassword)) {
            // If the credentials match, set the text of the sonuc label to "Oturum açma başarılı" (Login successful).
            sonuc.setText("Oturum açma başarılı");
            try {
               HelloApplication m =new HelloApplication(); m.changeScene("randevupage.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            // If the credentials do not match, set the text of the sonuc label to "Email yada şifre hatalı!" (Email or password incorrect).
            sonuc.setText("Email yada şifre hatalı!");
        }
    }


    @FXML
    void onSignuplicked(ActionEvent event){
        HelloApplication m= new HelloApplication();
        try {
            m.changeScene("signup.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
