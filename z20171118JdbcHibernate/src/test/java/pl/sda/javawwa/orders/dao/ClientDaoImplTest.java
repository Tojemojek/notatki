package pl.sda.javawwa.orders.dao;

import org.junit.Assert;
import org.junit.Test;
import pl.sda.javawwa.orders.entieties.Client;
import pl.sda.javawwa.orders.entieties.ClientType;

// generalnie testów nie robi się na żywej bazie SQL
// HSQLD - tworzy się taką bazę
// H2 - lub taką
// taka baza danych tworzy się w pamięci np. przy wykorzystaniu skryptów SQL
// przy testach bo takie testy jak tu nie przechodzą za wiele razy
// więc takie metody mogą spowodować fałszywe alarmy

public class ClientDaoImplTest {

    @Test
    public void findById() throws Exception {

        ClientDao clientDao = new ClientDaoImpl();
        Client expectedClient = new Client(1, "Jan", "Kowalski", "jk@mailinator.com", ClientType.VIP);

        clientDao.insertWithId(expectedClient);

        Client clientFromDatabase = clientDao.findById(1);

        Assert.assertEquals("Clients should be the same", expectedClient, clientFromDatabase);

        clientDao.delete(1);


    }

    @Test
    public void shouldInsertClient() throws Exception {

        ClientDao clientDao = new ClientDaoImpl();
        //bez id bo ID musi być przypisany przez bazę danych
        Client insertedClient = new Client(null, "Johny", "Bravo", "jb@mailinator.com", ClientType.REGULAR);
        clientDao.insert(insertedClient);
    }

    @Test
    public void shouldUpdateClient() throws Exception {

        ClientDao clientDao = new ClientDaoImpl();
        Client updatedClient = new Client(2, "Johny2", "Bravo2", "jb2@mailinator.com", ClientType.REGULAR);
        clientDao.update(updatedClient);
    }

    @Test
    public void shouldDeleteClient() throws Exception {

        ClientDao clientDao = new ClientDaoImpl();
        Integer deletedClientID = 1;
        clientDao.delete(deletedClientID);
    }

}