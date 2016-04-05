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

public class MainSceneController implements Initializable {

    @FXML
    private Button btnFindTrip;

    @FXML
    private void handleAction(ActionEvent event) throws IOException {

        if (event.getSource() == btnFindTrip) {
            Stage stage;
            Parent root;

            stage = (Stage) btnFindTrip.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../view/BookingView.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
