package controller;

import controller.table.Flight;
import controller.table.Ticket;
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
    private TableView ticketTable;

    private ObservableList<ObservableList> data;

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

        Connection c;
        data = FXCollections.observableArrayList();
        try {
            c = DBConnect.connect();
            String SQL = "SELECT * from Customer";
            ResultSet rs = c.createStatement().executeQuery(SQL);

            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }

                });

                ticketTable.getColumns().addAll(col);
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

            ticketTable.setItems(data);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
