package com.example.hasta_yatak_randevu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class RandevuController {

    @FXML
    private AnchorPane apbottom;

    @FXML
    private AnchorPane apcenter;

    @FXML
    private AnchorPane apleft;

    @FXML
    private AnchorPane apright;

    @FXML
    private AnchorPane aptop;

    @FXML
    private Button bosyatak;

    @FXML
    private BorderPane bp;

    @FXML
    private Button randevual;

    @FXML
    private Button randevusil;

    @FXML
    private Text randevutext;

    @FXML
    private Text resultText; // New Text element to display results

    @FXML
    private Button kacis;

    private Yatak yatak = new Yatak(50);  // Create an instance of Yatak with an initial capacity

    @FXML
    private void showEmptyBeds(ActionEvent event) {
        String emptyBedInfo = yatak.bosYataklar();
        resultText.setText(emptyBedInfo);
    }

    @FXML
    private void reserveBed(ActionEvent event) {
        String reserveResult = yatak.reserveBed(1);
        resultText.setText(reserveResult);
    }

    @FXML
    private void releaseBed(ActionEvent event) {
        String releaseResult = yatak.releaseBed(1);
        resultText.setText(releaseResult);
    }

    @FXML
    private void showOccupiedBeds(ActionEvent event) {
        String occupiedBedInfo = yatak.doluYataklar();
        resultText.setText(occupiedBedInfo);
    }

    @FXML
    private void onkacisClicked(ActionEvent event) {
        HelloApplication m = new HelloApplication();
        try {
            m.changeScene("hello-view.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
