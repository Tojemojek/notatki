package pl.sda.tests.calculator2.calculator;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.sda.tests.calculator.Calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {

        int result1 = calculator.add(3, 5);

        assertThat(result1).isEqualTo(8).isNotEqualTo(9);

    }


    @Test
    public void testSubstract() {

        int result1 = calculator.subtract(3, 5);
        assertThat(result1).isEqualTo(-2).isNotEqualTo(9);

    }

    @Test
    public void testMultiply() {

        int result1 = calculator.multiply(3, 5);
        assertThat(result1).isEqualTo(15).isNotEqualTo(9);

    }

    @Test
    public void testDivide() {

        int result1 = calculator.divide(15, 5);
        assertThat(result1).isEqualTo(3).isNotEqualTo(9);

    }


    @Test
    public void testDivideByZero() {

        assertThatThrownBy(() -> {calculator.divide(15, 0);}).hasMessage("Wartość dzielnika = 0");

    }


    @After
    public void tearDown() {
        calculator = null;
    }

}
