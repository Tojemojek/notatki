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
            client = session.find(Client.class, id);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Problem during client load with id=" + id, e);
        }

        return client;
    }

    @Override
    public void save(Client client) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(client);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Problem during client save with id=" + client.getId(), e);
        }
    }

    @Override
    public void delete(Integer clientId) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Client client = session.find(Client.class, clientId);
            session.remove(client);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Problem during client remove=" + clientId, e);
        }
    }

    @Override
    public void update(Client client) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.saveOrUpdate(client);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Problem during client update=" + client.getId(), e);
        }
    }

}
