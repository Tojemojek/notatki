package pl.sda.tests.calculator;

public class Calculator {

    public int add(int a, int b) {
        int answer = a + b;
        return answer;
    }

    public int subtract(int a, int b) {
        int answer = a - b;
        return answer;
    }

    public int multiply(int a, int b) {
        int answer = a * b;
        return answer;
    }

    public int divide(int a, int b) {

        if (b == 0) {
            throw new ArithmeticException("Wartość dzielnika = 0");
        }
        int answer = a / b;

        return answer;
    }
}
