package controller.table;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Ticket {

    private SimpleIntegerProperty bookingNum;
    private SimpleStringProperty ticketType;
    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleIntegerProperty socNum;
    private SimpleDoubleProperty price;

    public Ticket(int tbookingNum, String tticketType, String tfirstName, String tlastName, int tsocNum, double tprice) {
        this.bookingNum = new SimpleIntegerProperty(tbookingNum);
        this.ticketType = new SimpleStringProperty(tticketType);
        this.firstName = new SimpleStringProperty(tfirstName);
        this.lastName = new SimpleStringProperty(tlastName);
        this.socNum = new SimpleIntegerProperty(tsocNum);
        this.price = new SimpleDoubleProperty(tprice);
    }

    public int getBookingNum() {
        return bookingNum.get();
    }

    public SimpleIntegerProperty bookingNumProperty() {
        return bookingNum;
    }

    public void setBookingNum(int bookingNum) {
        this.bookingNum.set(bookingNum);
    }

    public String getTicketType() {
        return ticketType.get();
    }

    public SimpleStringProperty ticketTypeProperty() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType.set(ticketType);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public int getSocNum() {
        return socNum.get();
    }

    public SimpleIntegerProperty socNumProperty() {
        return socNum;
    }

    public void setSocNum(int socNum) {
        this.socNum.set(socNum);
    }

    public double getPrice() {
        return price.get();
    }

    public SimpleDoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }
}
