package ir.maktab.model.enumeration;

public enum UserStatus {
    CONFIRMED, WAITING;

    public static UserStatus getValue(String status) {
        switch (status) {
            case "confirmed":
                return CONFIRMED;
            default:
                return WAITING;
        }
    }


}
