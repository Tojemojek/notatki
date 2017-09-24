package pl.sda.tests.calculator;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class CalculatorTestParam {

    private Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    @Parameters({"3,2,1","10,11,-1","99,33,66","121,121,0"})
    public void testSubstract(int number, int number2,int resultExpected) {

        int result1 = calculator.subtract(number, number2);
        assertEquals(result1, resultExpected);

    }

    @After
    public void tearDown() {
        calculator = null;
    }

}
