package pl.sda.javawwa.hibernate.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.sda.javawwa.hibernate.entity.Order;
import pl.sda.javawwa.hibernate.utils.HibernateUtil;

public class OrderDaoImpl implements OrderDao{

    private Logger logger = Logger.getLogger(OrderDaoImpl.class);

    @Override
    public Order findById(Integer id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Order order = null;

        try {
            order = session.find(Order.class, id);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Problem during order load with id=" + id, e);
        }

        return order;
    }


    @Override
    public void save(Order order) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(order);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Problem during Order save " + order, e);
        }
    }

}
