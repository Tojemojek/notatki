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


    public boolean pair(int a) {
        return (a % 2 == 0);
    }

    public int squared(int a) {
        return (a*a);
    }

    public double brutto(int a, int b) {
        return (1.0*a*(1+(1.0*b/100)));
    }

}
