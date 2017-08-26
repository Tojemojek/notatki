package pl.sda.javawwa.objectTypeInterface;

public class Adder implements Computable {

    @Override
    public int compute(int a, int b) {
        return a + b;
    }

}
