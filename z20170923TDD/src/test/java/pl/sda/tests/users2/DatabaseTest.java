package pl.sda.tests.users2;

import org.junit.Before;
import org.junit.Test;
import pl.sda.tests.users.Database;
import pl.sda.tests.users.User;
import pl.sda.tests.users.exceptions.UserExistsException;
import pl.sda.tests.users.exceptions.UserNotExistException;

import static org.assertj.core.api.Assertions.assertThat;

public class DatabaseTest {

    Database bazaDoTestow;

    @Before
    public void setup() throws Exception {

        bazaDoTestow = new Database();

        bazaDoTestow.addUser(new User("Krzysiek", "aaa"));
        bazaDoTestow.addUser(new User("Marcin", "bbb"));
        bazaDoTestow.addUser(new User("Rafał", "ccc"));

    }


    @Test()
    public void testAddUser() {

        User u1 = new User("aaa", "bbb");

        assertThat(u1.getUsername()).isNotEmpty()
                .isEqualTo("aaa")
                .isNotEqualTo("bbb");

    }


    @Test()
    public void testAddUsersToList() {

        assertThat(bazaDoTestow.getUsers()).hasSize(3)
                .contains(new User("Marcin", "bbb"))
                .doesNotContain(new User("niema", "bbb"));

    }


    @Test()
    public void testAddUsersToListAndCheckIfSame() throws Exception {

        User u1 = new User("aaa", "bbb");

        bazaDoTestow.addUser(u1);

        assertThat(bazaDoTestow.getUsers()).hasSize(4)
                .contains(new User("Marcin", "bbb"))
                .doesNotContain(new User("niema", "bbb"));

        assertThat(bazaDoTestow.getUser("aaa")).isEqualTo(u1);

    }

    @Test()
    public void testAddUsersToListAndCheckIfSameWithAs() throws Exception {

        User u1 = new User("aaa", "bbb");

        bazaDoTestow.addUser(u1);

        assertThat(bazaDoTestow.getUser("aaa"))
                .as("Sprawdź imię %s", bazaDoTestow.getUser("aaa")
                        .getUsername()).isEqualTo(u1);

//        To poniżej pokazuje jak będzie wyświetlony
//        assertThat(bazaDoTestow.getUser("Krzysiek").getUsername())
//                .as("Sprawdź imię %s", bazaDoTestow.getUser("Krzysiek")
//                        .getUsername()).isEqualTo(u1.getUsername());

    }

}