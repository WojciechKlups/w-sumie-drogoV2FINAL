package pl.sda.wsumiedrogo.model;

public enum Availability {

    AVAILABILITY_ONSTOCK("ON STOCK"), AVAILABILITY_SOLDOUT("SOLD OUT");

    private final String availability;

    public String getRole() {
        return availability;
    }

    Availability(String availability) {
        this.availability = availability;
    }
}
