package pl.sda.tests.users3;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import pl.sda.tests.users.Database;
import pl.sda.tests.users.User;

import static org.mockito.Mockito.*;



@RunWith(MockitoJUnitRunner.class)
public class DatabaseTest {

    Database mockBazaDoTestow;
    Database bazaDoTestow;
    User mockUser;


    @Before
    public void setup() throws Exception {

        mockBazaDoTestow = mock(Database.class);
        bazaDoTestow = new Database();
        mockUser = mock(User.class);
        when(mockUser.getUsername()).thenReturn("Krzysztof1");
        when(mockBazaDoTestow.getUser("Krzysztof")).thenReturn( new User("Krzysztof", "aaa"));

    }


    @Test()
    public void testAddUser() throws Exception{

        User user1 = new User("Krzysztof", "aaa");
        mockBazaDoTestow.addUser(user1);

        verify(mockBazaDoTestow).addUser(user1);
        verify(mockBazaDoTestow,times(1)).addUser(user1);

    }


    @Test()
    public void testLoginNaMockUser() throws Exception{

        bazaDoTestow.login(mockUser);

        verify(mockUser,times(1)).getUsername();

    }

    @Test()
    public void testReturnUserFromMockDatabase() throws Exception{

        User user1 = new User("Krzysztof", "aaa");

        User krzysztofZMock = mockBazaDoTestow.getUser("Krzysztof");

        Assert.assertEquals(user1,krzysztofZMock);

    }





}