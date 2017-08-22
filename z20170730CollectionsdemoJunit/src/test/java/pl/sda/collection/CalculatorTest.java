package pl.sda.collection;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void initTest() {
        calculator = new Calculator();
    }

    @Test
    public void verifyAdd() {
        assertTrue("Failled not correct results",
                calculator.add(10,10)==20);
//        assertEquals("Failled not correct results",20, calculator.add(10+10));
        }

}
