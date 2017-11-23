package pl.sda.javawwa.orders.dao;

import org.apache.log4j.Logger;
import pl.sda.javawwa.orders.Exceptions.DatabaseException;
import pl.sda.javawwa.orders.entieties.Order;
import pl.sda.javawwa.orders.entieties.OrderItem;
import pl.sda.javawwa.orders.entieties.OrderStatus;
import pl.sda.javawwa.orders.entieties.Product;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
                            + " VALUES(last_insert_id(),?,?)");
                    //last_insert_id() jest funkcją z bazy danych
                    //podaje ostatnią wykorzystaną autoincrementem wartość
                    //tu jest nam potrzebne bo w naszym orderItem mamy klucz obcy
                    //którym jest numer zamówienia
                    //którego w tym momencie nie znamy

                    statement.setInt(1, orderItem.getProductId());
                    statement.setInt(2, orderItem.getQuantity());
                    statement.execute();
                }
            }

            connection.commit();
            logger.info("Commit either was executed");

        } catch (SQLException se) {
            logger.error("Problem during order insert", se);
            throw new DatabaseException("Problem during order insert", se);
        } finally {
            //mam connection i statement w bloku try with resources - nie ma nic do zamykania
        }

    }

    @Override
    public Order findById(Integer id) {
        Order o = null;
        logger.info("Trying to get connection to retrieve Order by ID...");

        ResultSet resultSet1 = null;
        ResultSet resultSet2 = null;

        String sqlStatement1 = "SELECT id, client_id, insert_date, update_date, status, total_cost FROM `order` WHERE id=?";
        String sqlStatement2 = "SELECT  p.id, oi.quantity, p.name, p.price FROM `order_item` oi join `product` p on oi.product_id = p.id WHERE oi.order_id=?";

        try (Connection connection = DriverManager.getConnection(MY_SQL_CONNECTION_STRING);
             PreparedStatement statement1 = connection.prepareStatement(
                     sqlStatement1);
             PreparedStatement statement2 = connection.prepareStatement(
                     sqlStatement2);
        ) {

            statement1.setInt(1, id);
            resultSet1 = statement1.executeQuery();

            statement2.setInt(1, id);
            resultSet2 = statement2.executeQuery();

            if (resultSet1.next()) {

                logger.info("Found order by ID");

                List<OrderItem> listOrderItem = new ArrayList();

                while (resultSet2.next()) {
                    createListOfOrderItems(id, resultSet2, listOrderItem);
                }
                o = createOrder(resultSet1, listOrderItem);
            }

        } catch (SQLException se) {
            logger.error("Problem with retreiving order by ID", se);
            throw new DatabaseException("Problem with retreiving order by ID", se);
        } finally{
            if (resultSet1 != null){
                try {
                    resultSet1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet2 != null){
                try {
                    resultSet2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return o;
    }


    private Order createOrder(ResultSet resultSet1, List<OrderItem> listOrderItem) throws SQLException {
        Order o;
        Integer orderId = resultSet1.getInt("id");
        Integer clientId = resultSet1.getInt("client_id");
        java.util.Date insertDate = resultSet1.getTimestamp("insert_date");
        java.util.Date updateDate = resultSet1.getTimestamp("update_date");
        OrderStatus status = OrderStatus.valueOf(resultSet1.getString("status"));
        BigDecimal totalCost = resultSet1.getBigDecimal("total_cost");

        o = new Order(orderId, clientId, insertDate, updateDate, status, totalCost,listOrderItem);
        logger.info(o);
        return o;
    }

    private void createListOfOrderItems(Integer id, ResultSet resultSet2, List<OrderItem> listOrderItem) throws SQLException {
        Integer orderItemId = resultSet2.getInt("id");
        Integer productId = resultSet2.getInt("id");
        String name = resultSet2.getString("name");
        BigDecimal price = resultSet2.getBigDecimal("price");
        Integer quantity = resultSet2.getInt("quantity");

        Product p = new Product(productId, name, price);
        logger.info(p);

        OrderItem oi = new OrderItem(id,p, quantity);

        logger.info(oi);

        listOrderItem.add(oi);
    }
}
