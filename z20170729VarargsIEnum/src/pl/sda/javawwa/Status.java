package pl.sda.javawwa;

public enum Status {
    WZOROWY("Uczeń jest wzorowy"),
    DOBRY("Uczeń jest dobry"),
    SLABY("Uczeń jest słaby"),
    NIEDOSTATECZNY("Uczeń jest niedostateczny");

    private final String opisUcznia;

    Status(String opisUcznia) {
        this.opisUcznia = opisUcznia;
    }

    public String getOpisUcznia() {
        return opisUcznia;
    }
}

