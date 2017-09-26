package pl.sda.tests.fibonacci;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

@RunWith(value = Parameterized.class)
public class FibonacciTest {

    private static int i = 0;

    @Parameter
    public int correctResult;

    @Parameters(name = "testowany {index}, oczekiwany wynik {0}")
    public static Iterable<? extends Object> data() {
        return Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181);
    }

    @Before
    public void setUp() {
    }



    @Test
    public void compute() {
        Assert.assertEquals(Fibonacci.compute(i),correctResult);
        i++;
    }

}