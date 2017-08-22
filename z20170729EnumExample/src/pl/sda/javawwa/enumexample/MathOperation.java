package pl.sda.javawwa.enumexample;

public enum MathOperation {

    ADDITION,
    SUBTRACTION,
    MULTIPLICATION,
    DIVISION;

    public double calculate (double x, double y) {
        switch(this) {
            case ADDITION:
                return x + y;
            case SUBTRACTION:
                return x-y;
            case MULTIPLICATION:
                return x*y;
            case DIVISION:
                return x/y;
                default:
                    throw new AssertionError("Operation does not exist: " + this);
        }


    }



}
