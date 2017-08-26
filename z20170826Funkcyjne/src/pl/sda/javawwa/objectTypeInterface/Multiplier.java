package pl.sda.javawwa.objectTypeInterface;

public class Multiplier implements Computable {

    @Override
    public int compute(int a, int b) {
        return a * b;
    }
}
