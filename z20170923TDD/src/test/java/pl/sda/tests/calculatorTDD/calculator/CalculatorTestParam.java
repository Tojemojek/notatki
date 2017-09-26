package pl.sda.tests.calculatorTDD.calculator;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import pl.sda.tests.calculator.Calculator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class CalculatorTestParam {

    private Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    @Parameters({"0","2","4","6","8","10","12"})
    public void testPair1(int number) {

        boolean result1 = calculator.pair(number);
        assertTrue(result1);

    }

    @Test
    @Parameters({"3","5","7","9","11","13"})
    public void testPair2(int number) {

        boolean result1 = calculator.pair(number);
        assertFalse(result1);

    }


    @Test
    @Parameters({"2,4","4,16","6,36","8,64","10,100","12,144","0,0"})
    public void testSquared(int number, int result) {

        int result1 = calculator.squared(number);
        assertEquals(result,result1);
    }

    @Test
    @Parameters({"2,50,3","4,30,5.2"})
    public void testBrutto(int number, int taxRate,double result) {

        double result1 = calculator.brutto(number, taxRate);
        assertEquals(result,result1,0.000001);
    }


    @After
    public void tearDown() {
        calculator = null;
    }

}
