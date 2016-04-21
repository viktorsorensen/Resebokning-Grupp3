package controller;

import controller.table.Flight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

    @FXML
    private Button homeBtn;

    @FXML
    private Button pickBtn;

    @FXML
    private TableView<Flight> flightTable;

    @FXML
    private TableColumn flightRefCol;
    @FXML
    private TableColumn flightFromCol;
    @FXML
    private TableColumn flightToCol;
    @FXML
    private TableColumn flightTimeCol;
    @FXML
    private TableColumn flightSeatsCol;
    @FXML
    private TableColumn flightPriceCol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        final ObservableList<Flight> data = FXCollections.observableArrayList(
                new Flight(2433, "Helsingborg", "Mexiko", "14:30", 177, 1999),
                new Flight(5442, "Namirs hus", "Persien", "17:20", 133, 2433)
        );

        flightRefCol.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("flightRef"));
        flightFromCol.setCellValueFactory(new PropertyValueFactory<Flight, String>("flightFrom"));
        flightToCol.setCellValueFactory(new PropertyValueFactory<Flight, String>("flightTo"));
        flightTimeCol.setCellValueFactory(new PropertyValueFactory<Flight, Double>("flightTime"));
        flightSeatsCol.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("flightSeats"));
        flightPriceCol.setCellValueFactory(new PropertyValueFactory<Flight, Double>("flightPrice"));
        flightTable.setItems(data);
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

    @FXML
    private void homeAction(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) backBtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../view/MainScene.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void nextSceneAction(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) pickBtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../view/PersonInfoView.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

