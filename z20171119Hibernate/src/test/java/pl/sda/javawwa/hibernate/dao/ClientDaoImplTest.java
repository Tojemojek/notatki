package pl.sda.javawwa.hibernate.dao;

import org.apache.log4j.Logger;
import org.junit.Test;
import pl.sda.javawwa.hibernate.entity.Client;

import static org.junit.Assert.*;

public class ClientDaoImplTest {

    private Logger logger = Logger.getLogger(ClientDaoImpl.class);


    @Test
    public void shouldFindById() throws Exception {
        ClientDao clientDao = new ClientDaoImpl();
        Client client = clientDao.findById(2);
        logger.info(client);
    }
}