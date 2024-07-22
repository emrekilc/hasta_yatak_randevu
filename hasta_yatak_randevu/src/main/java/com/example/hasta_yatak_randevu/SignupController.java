package com.example.hasta_yatak_randevu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class SignupController {

    @FXML
    private AnchorPane apsignup;

    @FXML
    private TextField isim;

    @FXML
    private Button kayıtol;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private TextField soyisim;

    @FXML
    private TextField tckimlik;

    @FXML
    private Text sonuctext;

    @FXML
    private Text text1;

    @FXML
    private Button geridon;

    @FXML
    private TextField yaş;

    @FXML
    private void kayitOlButtonAction(ActionEvent event) {
        try {
            String name = isim.getText();
            String surname = soyisim.getText();
            int age = Integer.parseInt(yaş.getText());
            int kimlikNumarasi = Integer.parseInt(tckimlik.getText());
            String kullaniciAdi = username.getText();
            String sifre = password.getText();

            // Check if the username already exists
            if (usernameExists(kullaniciAdi)) {
                sonuctext.setText("Bu kullanıcı adı zaten mevcut. Lütfen farklı bir kullanıcı adı seçin.");
                return;
            }

            // Call the method to handle user creation
            Login.yeniKullaniciOlustur(name, surname, age, kimlikNumarasi, kullaniciAdi, sifre);

            // Dosyaya kaydetme
            Login.saveUsersToFile("users.txt");
            Login.loadUsersFromFile("users.txt");
            Login.printUserList(Login.getKullaniciListesi());

            sonuctext.setText("Kayıt işlemi başarılı!");
        } catch (NumberFormatException e) {
            sonuctext.setText("Geçersiz yaş veya kimlik numarası. Lütfen doğru bilgileri girin.");
        } catch (Exception e) {
            e.printStackTrace();
            sonuctext.setText("Kayıt işlemi sırasında bir hata oluştu.");
        }
    }

    private boolean usernameExists(String username) {
        for (Login user : Login.getKullaniciListesi()) {
            if (user.getKullaniciAdi().equals(username)) {
                return true;
            }
        }
        return false;
    }

    @FXML
    private void geriDonButtonAction(ActionEvent event) {
        try {
            // Create an instance of HelloApplication to change the scene
            HelloApplication m = new HelloApplication();
            m.changeScene("hello-view.fxml");
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (e.g., show an error message)
        }
    }

}
