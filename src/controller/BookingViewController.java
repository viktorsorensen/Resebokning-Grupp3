package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;

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
    int adultCount = 0;

    @FXML
    private TextField tfChild;
    int childCount = 0;

    @FXML
    private Button btnAdultMinus;

    @FXML
    private Button btnAdultPlus;

    @FXML
    private Button btnChildMinus;

    @FXML
    private Button btnChildPlus;

    @FXML
    private RadioButton rbtnDepartReturn;

    @FXML
    private RadioButton rbtnOneWay;

    @FXML
    private Label tfAdultLabel;

    @FXML
    private Label tfChildLabel;

    @FXML
    private Label cbFromLabel;

    @FXML
    private Label cbToLabel;

    @FXML
    private Label pickClassLabel;

    @FXML
    private Label typeLabel;

    BookingSession bookingSession;

    private void disableStuff() {
        btnChildMinus.setDisable(true);
        btnAdultMinus.setDisable(true);
        tfAdultLabel.setVisible(false);
        tfChildLabel.setVisible(false);
        cbFromLabel.setVisible(false);
        cbToLabel.setVisible(false);
        pickClassLabel.setVisible(false);
        typeLabel.setVisible(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        disableStuff();

        // Lägg in dummy data
        cbFrom.setItems(FXCollections.observableArrayList("Ängelholm", "Malmö", "Helsingborg"));
        cbTo.setItems(FXCollections.observableArrayList("Mexiko", "Danmark", "Finland"));
        cbChooseClass.setItems(FXCollections.observableArrayList("Välj klass", new Separator(), "Första Klass", "Business", "Ekonomi"));
        cbChooseClass.getSelectionModel().selectFirst();

        // Datepicker
        dateDepart.setValue(LocalDate.now());
        final Callback<DatePicker, DateCell> dayCellFactory =
                (final DatePicker datePicker) -> new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);

                        long daysGone = ChronoUnit.DAYS.between(dateDepart.getValue(), item);
                        setTooltip(new Tooltip("Du kommer att vara borta i " + daysGone + " dagar."));

                        if (item.isBefore(
                                dateDepart.getValue().plusDays(1))
                                ) {
                            setDisable(true);
                            setStyle("-fx-background-color: #ffc0cb");
                        }
                    }
                };

        final Callback<DatePicker, DateCell> dayCellFactoryTwo =
                (final DatePicker datePicker) -> new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);

                        DayOfWeek day = DayOfWeek.from(item);
                        if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
                            setStyle("-fx-background-color: beige");
                        }
                    }
                };

        dateDepart.setDayCellFactory(dayCellFactoryTwo);
        dateReturn.setDayCellFactory(dayCellFactory);
        dateReturn.setValue(dateDepart.getValue().plusDays(1));

    }

    @FXML
    private void addAdult(ActionEvent ev) throws IOException {
        adultCount++;
        tfAdult.setText(String.valueOf(adultCount));
        if (adultCount >= 8){
            btnAdultPlus.setDisable(true);
        }
        btnAdultMinus.setDisable(false);

    }

    @FXML
    private void removeAdult(ActionEvent ev) throws IOException {
        adultCount--;
        tfAdult.setText(String.valueOf(adultCount));
        if(adultCount <= 0){
            tfAdult.setText(String.valueOf(0));
            btnAdultMinus.setDisable(true);
        }
        
        btnAdultPlus.setDisable(false);

    }
    @FXML
    private void addChild(ActionEvent ev) throws IOException {
        childCount++;
        tfChild.setText(String.valueOf(childCount));
        if(childCount >= 8){
            tfChild.setText(String.valueOf(8));
            btnChildPlus.setDisable(true);
        }
        
        btnChildMinus.setDisable(false);
    }

    @FXML
    private void removeChild(ActionEvent ev) throws IOException {
        childCount--;
        tfChild.setText(String.valueOf(childCount));
        if (childCount <= 0){
            tfChild.setText(String.valueOf(0));
            btnChildMinus.setDisable(true);
        }
        
        btnChildPlus.setDisable(false);
    }

    @FXML
    private void handleAction(ActionEvent event) throws IOException {

        try {
            Stage stage;
            Parent root;

            stage = (Stage) btnBack.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../view/MainScene.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void searchTripAction(ActionEvent event) throws IOException {

        if (checkSelected()) {

            try {

                Stage stage;
                Parent root;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/FlightinfoView.fxml"));
                Scene scene = new Scene(loader.load());

                BookingSession bs = new BookingSession();
                bs.setNumberOfAdults(adultCount);
                bs.setNumberOfChildren(childCount);

                FlightinfoController controller = loader.<FlightinfoController>getController();
                controller.setBookingSession(bs);

                stage = (Stage) btnBack.getScene().getWindow();

                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private boolean checkSelected() {

        boolean validated = true;

        if (!cbChooseClass.getSelectionModel().isSelected(2) && !cbChooseClass.getSelectionModel().isSelected(3) && !cbChooseClass.getSelectionModel().isSelected(4)) {
            pickClassLabel.setVisible(true);
            validated = false;
        }

        if (cbChooseClass.getSelectionModel().isSelected(2) || cbChooseClass.getSelectionModel().isSelected(3) || cbChooseClass.getSelectionModel().isSelected(4)) {
            pickClassLabel.setVisible(false);
        }

        if (!cbFrom.getSelectionModel().isEmpty()) {
            cbFromLabel.setVisible(false);
        }

        if (!cbTo.getSelectionModel().isEmpty()) {
            cbToLabel.setVisible(false);
        }

        if (cbFrom.getSelectionModel().isEmpty()) {
            cbFromLabel.setVisible(true);
            validated = false;
        }

        if (cbTo.getSelectionModel().isEmpty()) {
            cbToLabel.setVisible(true);
            validated = false;
        }

        if (cbFrom.getSelectionModel().isEmpty() && cbTo.getSelectionModel().isEmpty()) {
            cbFromLabel.setVisible(true);
            cbToLabel.setVisible(true);
            validated = false;
        }

        if (adultCount == 0) {
            tfAdultLabel.setVisible(true);
            validated = false;
        } else {
            tfAdultLabel.setVisible(false);
        }
        
        if (!rbtnOneWay.isSelected() && (!rbtnDepartReturn.isSelected())) {
            typeLabel.setVisible(true);
            validated = false;
        } else {
            typeLabel.setVisible(false);
        }
        return validated;
    }
}
