package pl.sda.javawwa.hibernate.dao;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import pl.sda.javawwa.hibernate.entity.Client;
import pl.sda.javawwa.hibernate.entity.ClientType;

import static org.junit.Assert.*;

public class ClientDaoImplTest {

    private Logger logger = Logger.getLogger(ClientDaoImpl.class);


    @Test
    public void shouldFindById() throws Exception {
        ClientDao clientDao = new ClientDaoImpl();
        Client client = clientDao.findById(2);
        logger.info(client);
    }

    @Test
    public void shouldSaveClient() throws Exception {
        ClientDao clientDao = new ClientDaoImpl();
        Client client = new Client("Jan", "Kowalsky","jk2@mailinator.com", ClientType.REGULAR);
        clientDao.save(client);
        logger.info(client);
    }

    @Test
    public void shouldDeleteClient() throws Exception {
        ClientDao clientDao = new ClientDaoImpl();
        clientDao.delete(5);
        logger.info("Usunięto klienta z id 5");
    }

    @Test
    public void shouldSaveOrUpdateClient() throws Exception {

        ClientDao clientDao = new ClientDaoImpl();
        Client client = new Client(2,"Janek", "Kowalsky","jk15@mailinator.com", ClientType.VIP);
        clientDao.update(client);

        Client clientFromDatabase = clientDao.findById(2);
        logger.info(clientFromDatabase);

        Assert.assertEquals("Nazwisko powinno być takie samo","Kowalsky",clientFromDatabase.getSecondName());

        logger.info("Test update przeprowadzony");
    }





}