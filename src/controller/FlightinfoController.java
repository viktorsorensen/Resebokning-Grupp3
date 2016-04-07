package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Namir on 4/7/2016.
 */

public class FlightinfoController implements Initializable{

    @FXML
    private Button backBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void backAction(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) backBtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../view/BookingView.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

