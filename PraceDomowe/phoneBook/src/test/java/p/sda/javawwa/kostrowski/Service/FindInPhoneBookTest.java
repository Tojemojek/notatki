package p.sda.javawwa.kostrowski.Service;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.sda.javawwa.kostowski.Service.FindInPhoneBook;

import java.util.*;

public class FindInPhoneBookTest {

    private static Map<String, Set<String>> phoneBook;

    @Before
    public void initFindInPhoneBookTest() {
        initPhoneBook();

    }


    @Test
    public void searchByPhoneNumberTest() {
        String tmpName;
        tmpName = FindInPhoneBook.searchByPhoneNumber(phoneBook, "023456780");

        Assert.assertEquals("Imię0",tmpName);

    }

    @Test
    public void searchByNameTest() {
        Set <String> tmpNumbers;

        tmpNumbers = FindInPhoneBook.searchByName(phoneBook, "Imię0");

        Assert.assertTrue(tmpNumbers.contains("023456780"));
        Assert.assertTrue(tmpNumbers.contains("023456781"));
        Assert.assertTrue(tmpNumbers.contains("023456782"));

    }


    private static void initPhoneBook() {

        phoneBook = new HashMap<>();
        Set<String> tmpPhoneNumbers;

        int howManyrndNumbers = 3;
        int homManyUsers = 5;


        for (int i = 0; i < homManyUsers; i++) {
            tmpPhoneNumbers = new HashSet<>();
            for (int j = 0; j < howManyrndNumbers; j++) {

                //tmpPhoneNumbers.add(String.valueOf(random.nextInt(900000000) + 100000000));
                tmpPhoneNumbers.add(i*(j+1) + "2345678"+j);
            }
            phoneBook.put("Imię" + i, tmpPhoneNumbers);


        }
    }

}