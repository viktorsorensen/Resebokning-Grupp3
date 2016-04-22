package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.DBConnect;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * Created by Viktor on 2016-04-11.
 */
public class PersonInfoController implements Initializable{

    @FXML
    private Button homeBtn;
    @FXML
    private Button backBtn;
    @FXML
    private Button bookBtn;
    @FXML
    private TextField firstNameOne;
    @FXML
    private TextField lastNameOne;
    @FXML
    private TextField socNumOne;


    BookingSession bookingSession;

    private int names;



    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    @FXML
    private void homeAction(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) homeBtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../view/MainScene.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void backAction(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) backBtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../view/FlightinfoView.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void bookAction(ActionEvent event) throws IOException {
        String firstName = firstNameOne.getText();
        boolean adult = false;
        String lastName = lastNameOne.getText();
        String socNum = socNumOne.getText();

        Connection c;
        Statement stmt = null;
        try {
            c = DBConnect.connect();
            stmt = c.createStatement();
            String SQL = "INSERT INTO Customer (firstName, isAdult, lastName, socNbr) VALUES ('"+firstName+"', FALSE ,'"+lastName+"',"+socNum+")";            stmt.executeUpdate(SQL);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage;
        Parent root;

        stage = (Stage) bookBtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../view/FinishedView.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();



    }

    public void setBookingSession(BookingSession bookingSession) {
        this.bookingSession = bookingSession;
    }
}
