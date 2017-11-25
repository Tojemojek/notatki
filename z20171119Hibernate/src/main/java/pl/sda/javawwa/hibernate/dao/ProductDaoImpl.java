package pl.sda.javawwa.hibernate.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.sda.javawwa.hibernate.entity.Product;
import pl.sda.javawwa.hibernate.utils.HibernateUtil;

public class ProductDaoImpl implements ProductDao {

    private Logger logger = Logger.getLogger(ProductDaoImpl.class);

    @Override
    public Product findById(Integer id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Product product = null;

        try {
            product = session.find(Product.class, id);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Problem during product load with id=" + id, e);
        }

        return product;
    }
}

