package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by viktorsorensen on 2016-04-03.
 */
public class BookingViewController implements Initializable {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnChooseTrip;

    @FXML
    private ChoiceBox cbFrom;

    @FXML
    private ChoiceBox cbTo;
    
    @FXML
    private ChoiceBox cbChooseClass;

    @FXML
    private DatePicker dateDepart;

    @FXML
    private DatePicker dateReturn;

    @FXML
    private TextField tfAdult;

    @FXML
    private TextField tfChild;

    @FXML
    private Button btnAdultMinus;

    @FXML
    private Button btnAdultPlus;

    @FXML
    private Button btnChildMinus;

    @FXML
    private Button btnChildPlus;

    @FXML
    private ChoiceBox cbChoose;

    @FXML
    private RadioButton rbtnDepartReturn;

    @FXML
    private RadioButton rbtnOneWay;







    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cbFrom.setItems(FXCollections.observableArrayList("Ängelholm", "Malmö", "Helsingborg"));
        cbTo.setItems(FXCollections.observableArrayList("Mexiko", "Danmark", "Finland"));
        cbChoose.setItems(FXCollections.observableArrayList("Välj klass", new Separator(), "Business", "Economy"));
        cbChoose.getSelectionModel().selectFirst();

    }

    @FXML
    private void handleAction(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) btnBack.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../view/MainScene.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
