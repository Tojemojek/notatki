package pl.sda.tests.users;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.sda.tests.users.exceptions.UserExistsException;
import pl.sda.tests.users.exceptions.UserNotExistException;

import java.rmi.server.ExportException;

import static org.junit.Assert.*;


public class DatabaseTest {

    Database bazaDoTestow;


    @Before
    public void setup() throws Exception {

        bazaDoTestow = new Database();

        bazaDoTestow.addUser(new User("Krzysiek", "aaa"));
        bazaDoTestow.addUser(new User("Marcin", "bbb"));
        bazaDoTestow.addUser(new User("Rafał", "ccc"));

    }


    @Test(expected = NullPointerException.class)
    public void testAddNullUser() throws NullPointerException, UserExistsException{
        bazaDoTestow.addUser(null);
    }



    @Test
    public void testAddUser() throws UserExistsException {
        bazaDoTestow.addUser(new User("Krzysiek2", "aaa"));
    }

    @Test(expected = UserExistsException.class)
    public void testAddUserAgain() throws UserExistsException {
        bazaDoTestow.addUser(new User("Krzysiek", "aaa"));
    }


    @Test
    public void removeUserTest1() {
        try {
            bazaDoTestow.removeUser(new User("asdsadas", "aaa"));
            fail("This user does not exist so this should not happen");
        } catch (UserNotExistException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void removeUserTest2() {

        try {
            bazaDoTestow.removeUser(new User("Krzysiek", "aaa"));
        } catch (UserNotExistException e) {
            e.printStackTrace();
        }

    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void getUser() throws Exception {
        thrown.expect(UserNotExistException.class);
        thrown.expectMessage("User with username " + "aSDFFAFDA" + "does not exist in database");
        bazaDoTestow.getUser("aSDFFAFDA");
    }


    @Test
    public void getUsers() throws Exception {
        assertEquals(3, bazaDoTestow.getUsers().size());
    }


}