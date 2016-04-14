package controller;

import controller.table.Flight;
import controller.table.Ticket;
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
 * Created by HampusBolin on 2016-04-13.
 */
public class TicketController implements Initializable {
    @FXML
    private Button backBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private Button changeBtn;
    @FXML
    private Button homeBtn;
    @FXML
    private TableView<Ticket> ticketTable;
    @FXML
    private TableColumn bookingNumCol;
    @FXML
    private TableColumn typeCol;
    @FXML
    private TableColumn firstNameCol;
    @FXML
    private TableColumn lastNameCol;
    @FXML
    private TableColumn socNumCol;
    @FXML
    private TableColumn priceCol;


    @FXML
    private void backAction(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) backBtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../view/MainScene.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void cancelAction(ActionEvent event) throws IOException {
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        final ObservableList<Ticket> data = FXCollections.observableArrayList(
                new Ticket(2433, "first", "Hampussy", "Brohlin", 19910421, 2499),
                new Ticket(5442, "econ", "Namir", "Wesaf", 19941017, 1515)
        );

        bookingNumCol.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("bookingNum"));
        typeCol.setCellValueFactory(new PropertyValueFactory<Ticket, String>("ticketType"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Ticket, String>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Ticket, String>("lastName"));
        socNumCol.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("socNum"));
        priceCol.setCellValueFactory(new PropertyValueFactory<Ticket, Double>("price"));
        ticketTable.setItems(data);


    }
}
