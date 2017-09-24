package pl.sda.tests.fibonacci;

import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(JUnitParamsRunner.class)
public class FibonacciTest3 {

    @Before
    public void setUp() {
    }

    @Test
    @junitparams.Parameters({"0, 0", "1, 1", "2, 1", "3, 2", "4, 3", "5, 5", "6, 8", "7, 13", "8, 21", "9, 34", "10, 55", "11, 89", "12, 144", "13, 233", "14, 377", "15, 610", "16, 987", "17, 1597", "18, 2584", "19, 4181"})
    public void compute(int noOfElement, int expectedResult) {
        Assert.assertEquals(Fibonacci.compute(noOfElement), expectedResult);
    }

}