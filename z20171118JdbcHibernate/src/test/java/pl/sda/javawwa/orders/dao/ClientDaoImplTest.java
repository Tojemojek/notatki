package pl.sda.javawwa.orders.dao;

import org.junit.Assert;
import org.junit.Test;
import pl.sda.javawwa.orders.entieties.Client;
import pl.sda.javawwa.orders.entieties.ClientType;

import static org.junit.Assert.*;





public class ClientDaoImplTest {

    @Test
    public void findById() throws Exception {

        ClientDao clientDao = new ClientDaoImpl();
        Client clientFromDatabase = clientDao.findById(1);
        Client expectedClient = new Client(1,"Jan","Kowalski","jk@mailinator.com", ClientType.VIP);
        Assert.assertEquals("Clients should be the same", expectedClient,clientFromDatabase);

    }

}