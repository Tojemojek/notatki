package pl.sda.tests.calculator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.sda.tests.calculator.Calculator;

import static org.junit.Assert.assertEquals;


public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {

        int result1 = calculator.add(3, 5);
        int result2 = calculator.add(-3, 5);
        int result3 = calculator.add(15, 0);
        int result4 = calculator.add(0, 0);

        assertEquals(8, result1);
        assertEquals(2, result2);
        assertEquals(15, result3);
        assertEquals(0, result4);

    }


    @Test
    public void testSubstract() {

        int result1 = calculator.subtract(3, 5);
        int result2 = calculator.subtract(-3, 5);
        int result3 = calculator.subtract(15, 0);
        int result4 = calculator.subtract(0, 0);

        assertEquals(-2, result1);
        assertEquals(-8, result2);
        assertEquals(15, result3);
        assertEquals(0, result4);

    }


    @Test
    public void testMultiply() {

        int result1 = calculator.multiply(3, 5);
        int result2 = calculator.multiply(-3, 5);
        int result3 = calculator.multiply(15, 0);
        int result4 = calculator.multiply(0, 0);

        assertEquals(15, result1);
        assertEquals(-15, result2);
        assertEquals(0, result3);
        assertEquals(0, result4);

    }

    @Test
    public void testDivide() {

        int result1 = calculator.divide(15, 5);
        int result2 = calculator.divide(-15, 5);

        assertEquals(3, result1);
        assertEquals(-3, result2);

    }

    @Test (expected = ArithmeticException.class)
    public void testDivideByZero() {

        int result1 = calculator.divide(15, 0);

    }

    @After
    public void tearDown() {
        calculator = null;
    }

}
