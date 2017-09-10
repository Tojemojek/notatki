package javawwa.kolekcjeZSortowaniemTest;

import org.junit.Assert;
import org.junit.Test;
import pl.sda.javawwa.kolekcje.MyArrayList;
import pl.sda.javawwa.kolekcje.MyList;
import pl.sda.javawwa.kolekcjeZSortowaniem.MyArrayListWithSort;

import java.util.Arrays;

public class TestMyArrayListWithSort {


    @Test
    public void testQuickSort() {
        //given
        Integer intTest[] = {10, 54, 33, 11, 1, 23, 43, 88, 66};

        MyArrayListWithSort<Integer> testList = new MyArrayListWithSort<>();

        for (int i : intTest) {
            testList.add(i);
        }

        //when
        testList.quickSort();


        //then

        Arrays.sort(intTest);

        for (int i = 0; i < intTest.length; i++) {
            Assert.assertEquals(intTest[i], testList.get(i));
        }

    }

    @Test
    public void binarySearchTest() {


        //given
        MyArrayListWithSort<Integer> testList = new MyArrayListWithSort<>();

        testList.add(10);
        testList.add(15);
        testList.add(18);
        testList.add(20);
        testList.add(25);
        testList.add(29);

        //when

        int index18 = testList.findInSortedArray(18);
        int index29 = testList.findInSortedArray(29);

        //then
        Assert.assertEquals(2, index18);
        Assert.assertEquals(5, index29);

    }


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

    @Test
    public void removeTest() {


        //given
        MyArrayListWithSort<Integer> testList = new MyArrayListWithSort<>();

        testList.add(10);
        testList.add(15);
        testList.add(18);
        testList.add(20);
        testList.add(25);
        testList.add(29);

        //when
        testList.remove((int) 2);

        //then
        boolean contains = testList.contains(18);
        Assert.assertFalse(contains);

    }
}