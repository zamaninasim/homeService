package ir.maktab.model.enumeration;

public enum OrderStatus {
    FIRST("WaitingForExpertSuggestions"),
    SECOND("WaitingForExpertSelection"),
    THIRD("WaitingForTheExpertToArrive"),
    FOURTH("Started"),
    FIFTH("Done"),
    SIXTH("Paid");

    private String direction;

    OrderStatus(String direction) {
        this.direction = direction;
    }
}
