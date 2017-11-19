package pl.sda.javawwa.hibernate.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.sda.javawwa.hibernate.entity.Client;
import pl.sda.javawwa.hibernate.utils.HibernateUtil;

public class ClientDaoImpl implements ClientDao {

    private Logger logger = Logger.getLogger(ClientDaoImpl.class);

    @Override
    public Client findById(Integer id) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Client client = null;
        try {
            client = session.load(Client.class, id);
            transaction.commit();
        }
        catch (Exception e) {
            transaction.rollback();
            logger.error("Problem during client load with id=" + id, e);
        }

        return client;
    }
}
