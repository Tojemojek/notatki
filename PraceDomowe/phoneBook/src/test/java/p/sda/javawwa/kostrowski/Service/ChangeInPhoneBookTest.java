package p.sda.javawwa.kostrowski.Service;


import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.sda.javawwa.kostowski.Service.ChangeInPhoneBook;
import pl.sda.javawwa.kostowski.Service.FindInPhoneBook;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ChangeInPhoneBookTest {

    private static Map<String, Set<String>> phoneBook;
    @Before
    public void initChangeInPhoneBookTest() {
        initPhoneBook2();

    }

    @Test
    public void addNewNumberTest() {
        Set<String> tmpPhoneNumber = new HashSet<>();

        ChangeInPhoneBook.addNewNumber(phoneBook, "Imię0", "123", "124");

        tmpPhoneNumber = phoneBook.get("Imię0");

        Assert.assertTrue(tmpPhoneNumber.contains("123"));
        Assert.assertTrue(tmpPhoneNumber.contains("124"));
        Assert.assertFalse(tmpPhoneNumber.contains("125"));

    }


    @Test
    public void removeNumberTest() {

        Set<String> tmpPhoneNumber = new HashSet<>();

        tmpPhoneNumber = phoneBook.get("Imię0");

        Assert.assertTrue(tmpPhoneNumber.contains("023456780"));

        ChangeInPhoneBook.removeNumber(phoneBook,"Imię0","023456780");

        tmpPhoneNumber = phoneBook.get("Imię0");

        Assert.assertFalse(tmpPhoneNumber.contains("023456780"));


    }

    @Test
    public void changeUserNameTest() {


        Assert.assertTrue(phoneBook.containsKey("Imię0"));
        Assert.assertFalse(phoneBook.containsKey("ToTen"));

        ChangeInPhoneBook.changeUserName(phoneBook,"Imię0","ToTen");

        Assert.assertFalse(phoneBook.containsKey("Imię0"));
        Assert.assertTrue(phoneBook.containsKey("ToTen"));
    }

    @Test
    public void replaceTelNumber() {
        String tmpName;
        Set<String> tmpPhoneNumber = new HashSet<>();

        tmpName = FindInPhoneBook.searchByPhoneNumber(phoneBook, "023456780");
        tmpPhoneNumber = phoneBook.get(tmpName);

        Assert.assertTrue(tmpPhoneNumber.contains("023456780"));
        Assert.assertFalse(tmpPhoneNumber.contains("123"));

        ChangeInPhoneBook.replaceTelNumber(phoneBook,"023456780","123");

        Assert.assertFalse(tmpPhoneNumber.contains("023456780"));
        Assert.assertTrue(tmpPhoneNumber.contains("123"));



    }


    private static void initPhoneBook2() {

        phoneBook = new HashMap<>();
        Set<String> tmpPhoneNumbers2;

        int howManyrndNumbers = 3;
        int homManyUsers = 5;


        for (int i = 0; i < homManyUsers; i++) {
            tmpPhoneNumbers2 = new HashSet<>();
            for (int j = 0; j < howManyrndNumbers; j++) {

                //tmpPhoneNumbers.add(String.valueOf(random.nextInt(900000000) + 100000000));
                tmpPhoneNumbers2.add(i * (j + 1) + "2345678" + j);
            }
            phoneBook.put("Imię" + i, tmpPhoneNumbers2);


        }
    }

}