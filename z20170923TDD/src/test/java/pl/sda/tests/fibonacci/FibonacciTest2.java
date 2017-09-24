package pl.sda.tests.fibonacci;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class FibonacciTest2 {

    @Parameter
    public int noOfElement;

    @Parameter(1)
    public int correctResult;


    @Parameters(name = "testowany {index}, oczekiwany wynik {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0},
                {1, 1},
                {2, 1},
                {3, 2},
                {4, 3},
                {5, 5},
                {6, 8},
                {7, 13},
                {8, 21},
                {9, 34},
                {10, 55},
                {11, 89},
                {12, 144},
                {13, 233},
                {14, 377},
                {15, 610},
                {16, 987},
                {17, 1597},
                {18, 2584},
                {19, 4181}
        });
    }

    @Before
    public void setUp() {
    }

    @Test
    public void compute() {
        Assert.assertEquals(Fibonacci.compute(noOfElement), correctResult);
    }

}