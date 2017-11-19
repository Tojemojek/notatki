package pl.sda.javawwa.orders.dao;

import org.apache.log4j.Logger;
import pl.sda.javawwa.orders.Exceptions.DatabaseException;
import pl.sda.javawwa.orders.entieties.Order;
import pl.sda.javawwa.orders.entieties.OrderItem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDaoImpl implements OrderDao {

    public static final String MY_SQL_CONNECTION_STRING = "jdbc:mysql://localhost/orders?"
            + "user=root&password=root";

    private Logger logger = Logger.getLogger(ClientDaoImpl.class);

    @Override
    public void insertOrder(Order order) {

        logger.info("Trying to get connection...");

        try (Connection connection = DriverManager.getConnection(MY_SQL_CONNECTION_STRING);) {
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO `order` (client_id, insert_date, update_date, `status`, total_cost) " + "VALUES(?,?,?,?,?)");
            //transakcja nie jest commitowana przy każdym statement.execute - tworzymy jedną większą transakcję
            connection.setAutoCommit(false);

            statement.setInt(1, order.getClientId());
            statement.setTimestamp(2, new java.sql.Timestamp(order.getInsertDate().getTime()));
            statement.setTimestamp(3, null);
            statement.setString(4, order.getStatus().name());
            statement.setBigDecimal(5, order.getTotalCost());

            statement.execute();

            if (order.getItems() != null) {
                for (OrderItem orderItem : order.getItems()) {
                    statement = connection.prepareStatement("INSERT INTO `order_item` (`order_id`, `product_id`, `quantity`) "
                            +" VALUES(last_insert_id(),?,?)");
                    //last_insert_id() jest funkcją z bazy danych
                    //podaje ostatnią wykorzystaną autoincrementem wartość
                    //tu jest nam potrzebne bo w naszym orderItem mamy klucz obcy
                    //którym jest numer zamówienia
                    //którego w tym momencie nie znamy

                    statement.setInt(1,orderItem.getProductId());
                    statement.setInt(2,orderItem.getQuantity());
                    statement.execute();
                }
            }

            connection.commit();

        } catch (SQLException se) {
            logger.error("Problem during order insert", se);
            throw new DatabaseException("Problem during order insert", se);
        } finally {
            //todo tu powinny być zamknięte wszystkie nie zamknięte części
            //connetion - jest w try with resources więc nie
            //statement powinien być zamknięty
        }

    }

    @Override
    public Order findById(Integer id) {
        //todo to dopisać wg opisu z interface
        return null;
    }
}
