package pl.sda.javawwa.model;

public enum JobPosition {
    MANAGER(10), ANALYST(8), ARCHITECT(6), SENIOR_DEVELOPER(4),DEVELOPER(2), JUNIOR_DEVELOPER(0), TESTER(-2);

    private int priority;

    JobPosition(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
