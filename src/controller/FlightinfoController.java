package controller;

import controller.table.Flight;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
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
import javafx.util.Callback;
import main.DBConnect;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
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
    private TableView flightTable;

   /* @FXML
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
    private TableColumn flightPriceCol;*/

    private ObservableList<ObservableList> data;
    private BookingSession bookingSession;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Connection c;
        data = FXCollections.observableArrayList();
        try {
            c = DBConnect.connect();
            String SQL = "SELECT * from Flight";
            ResultSet rs = c.createStatement().executeQuery(SQL);

            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }

                });

                flightTable.getColumns().addAll(col);
                System.out.println("Column [" + i + "] ");
            }

            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    row.add(rs.getString(i));
                }

                System.out.println("Row [1] added" + row);
                data.add(row);
            }

            flightTable.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



        /*final ObservableList<Flight> data = FXCollections.observableArrayList(
                new Flight(2433, "Helsingborg", "Mexiko", "14:30", 177, 1999),
                new Flight(5442, "Namirs hus", "Persien", "17:20", 133, 2433)
        );*/

       /* flightRefCol.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("flightRef"));
        flightFromCol.setCellValueFactory(new PropertyValueFactory<Flight, String>("flightFrom"));
        flightToCol.setCellValueFactory(new PropertyValueFactory<Flight, String>("flightTo"));
        flightTimeCol.setCellValueFactory(new PropertyValueFactory<Flight, Double>("flightTime"));
        flightSeatsCol.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("flightSeats"));
        flightPriceCol.setCellValueFactory(new PropertyValueFactory<Flight, Double>("flightPrice"));
        flightTable.setItems(data);
    } */

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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/PersoninfoView.fxml"));
        Scene scene = new Scene(loader.load());

        BookingSession bs = new BookingSession();


        PersonInfoController controller = loader.<PersonInfoController>getController();
        controller.setBookingSession(bs);

        stage = (Stage) pickBtn.getScene().getWindow();
        //root = FXMLLoader.load(getClass().getResource("../view/FlightinfoView.fxml"));


        stage.setScene(scene);
        stage.show();
    }

    public void fillTable() {
        Connection c;
    }

    public void setBookingSession(BookingSession bookingSession) {
        this.bookingSession = bookingSession;
    }
}

