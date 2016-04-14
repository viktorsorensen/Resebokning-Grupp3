package controller.table;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Viktor on 2016-04-11.
 */
public class Flight {

    private SimpleIntegerProperty flightRef;
    private SimpleStringProperty flightFrom;
    private SimpleStringProperty flightTo;
    private SimpleStringProperty flightTime;
    private SimpleIntegerProperty flightSeats;
    private SimpleDoubleProperty flightPrice;

    public int getFlightRef() {
        return flightRef.get();
    }

    public SimpleIntegerProperty flightRefProperty() {
        return flightRef;
    }

    public void setFlightRef(int flightRef) {
        this.flightRef.set(flightRef);
    }

    public String getFlightFrom() {
        return flightFrom.get();
    }

    public SimpleStringProperty flightFromProperty() {
        return flightFrom;
    }

    public void setFlightFrom(String flightFrom) {
        this.flightFrom.set(flightFrom);
    }

    public String getFlightTo() {
        return flightTo.get();
    }

    public SimpleStringProperty flightToProperty() {
        return flightTo;
    }

    public void setFlightTo(String flightTo) {
        this.flightTo.set(flightTo);
    }

    public String getFlightTime() {
        return flightTime.get();
    }

    public SimpleStringProperty flightTimeProperty() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime.set(flightTime);
    }

    public int getFlightSeats() {
        return flightSeats.get();
    }

    public SimpleIntegerProperty flightSeatsProperty() {
        return flightSeats;
    }

    public void setFlightSeats(int flightSeats) {
        this.flightSeats.set(flightSeats);
    }

    public double getFlightPrice() {
        return flightPrice.get();
    }

    public SimpleDoubleProperty flightPriceProperty() {
        return flightPrice;
    }

    public void setFlightPrice(double flightPrice) {
        this.flightPrice.set(flightPrice);
    }

    public Flight(int fRef, String fFrom, String fTo, String fTime, int fSeats, double fPrice) {
        this.flightRef = new SimpleIntegerProperty(fRef);
        this.flightFrom = new SimpleStringProperty(fFrom);
        this.flightTo = new SimpleStringProperty(fTo);
        this.flightTime = new SimpleStringProperty(fTime);
        this.flightSeats = new SimpleIntegerProperty(fSeats);
        this.flightPrice = new SimpleDoubleProperty(fPrice);
    }

}
