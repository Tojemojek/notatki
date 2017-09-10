package javawwa.kolekcjeTest;

import org.junit.Assert;
import org.junit.Test;
import pl.sda.javawwa.kolekcje.MyArrayList;
import pl.sda.javawwa.kolekcje.MyList;

public class MyArrayListTest {


    @Test
    public void shouldAdd3Elements() {

        //given
        String testWords[] = {"Ala", "ma", "kota"};
        MyList<String> list = new MyArrayList<>();

        //when
        for (int i = 0; i < testWords.length; i++) {
            list.add(testWords[i]);
        }

        //then
        Assert.assertEquals(testWords[0], list.get(0));
        Assert.assertEquals(testWords[1], list.get(1));
        Assert.assertEquals(testWords[2], list.get(2));

        Assert.assertEquals(3, list.size());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowIndexOutOfBounds() {

        //given
        MyList<String> list = new MyArrayList<>();

        //when
        list.get(10);

        //then
        //exception


    }


}
