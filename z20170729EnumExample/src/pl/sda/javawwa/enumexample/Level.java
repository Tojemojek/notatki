package pl.sda.javawwa.enumexample;

public enum Level {

    HIGH(3,"Danger"), MEDIUM(2,"Default"), LOW(1,"Low");

    private final int levelCode;
    private final String levelMessage;


    Level(int levelCode, String levelMessage) {
        this.levelCode = levelCode;
        this.levelMessage = levelMessage;
    }

    public int getLevelCode() {
        return this.levelCode;
    }

    public String getLevelMessage() {
        return this.levelMessage;
    }
}