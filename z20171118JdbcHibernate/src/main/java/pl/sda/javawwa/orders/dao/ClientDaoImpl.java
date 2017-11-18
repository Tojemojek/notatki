package pl.sda.javawwa.orders.dao;

import org.apache.log4j.Logger;
import pl.sda.javawwa.orders.Exceptions.DatabaseException;
import pl.sda.javawwa.orders.entieties.Client;
import pl.sda.javawwa.orders.entieties.ClientType;

import java.sql.*;

public class ClientDaoImpl implements ClientDao {

    public static final String MY_SQL_CONNECTION_STRING = "jdbc:mysql://localhost/orders?"
            + "user=root&password=root";
    private Logger logger = Logger.getLogger(ClientDaoImpl.class);

    @Override
    public Client findById(Integer id) {

        Client client = null;

        logger.info("Trying to get connection...");

        try (Connection connection = DriverManager.getConnection(MY_SQL_CONNECTION_STRING);
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT id, first_name, second_name, email, type FROM client WHERE id=?");
             ResultSet resultSet = statement.executeQuery()) {

            statement.setInt(1, id);

            if (resultSet.next()) {
                Integer clientId = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String secondName = resultSet.getString("second_name");
                String email = resultSet.getString("email");
                String clientType = resultSet.getString("type");

                ClientType type = ClientType.valueOf(clientType);
                client = new Client(clientId, firstName, secondName, email, type);
                logger.info(client);
            }


        } catch (SQLException se) {
            logger.error("Problem with getting client", se);
        } finally {
//              tu zasadniczo trzeba by było pozamykać, ja skorzystałem z try with resources
//            connection.close();
//            statement = null;
//            resultSet = null;

        }

        return client;
    }


    @Override
    public void insert(Client client) {

        logger.info("Trying to get connection...");

        try (Connection connection = DriverManager.getConnection(MY_SQL_CONNECTION_STRING);
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO client (first_name, second_name, email, type) " + "VALUES(?,?,?,?)")) {
            statement.setString(1, client.getFirstName());
            statement.setString(2, client.getSecondName());
            statement.setString(3, client.getEmail());
            statement.setString(4, client.getType().name());

            statement.execute();




        } catch (SQLException se) {
            logger.error("Problem with insert client", se);
            throw new DatabaseException("Problem with insert client", se);
        }
    }

    @Override
    public void update(Client client) {

        logger.info("Trying to get connection...");

        try (Connection connection = DriverManager.getConnection(MY_SQL_CONNECTION_STRING);
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE client SET first_name=?, second_name=?, email=?,type=?"+
                             " WHERE id=?")) {

            int parameterIndex = 1;

            statement.setString(parameterIndex++, client.getFirstName());
            statement.setString(parameterIndex++, client.getSecondName());
            statement.setString(parameterIndex++, client.getEmail());
            statement.setString(parameterIndex++, client.getType().name());
            statement.setInt(parameterIndex, client.getId());

            statement.execute();

        } catch (SQLException se) {
            logger.error("Problem with client modification", se);
            throw new DatabaseException("Problem with client modification", se);
        }
    }

    @Override
    public void delete(Integer clientId) {

        logger.info("Trying to get connection...");

        try (Connection connection = DriverManager.getConnection(MY_SQL_CONNECTION_STRING);
             PreparedStatement statement = connection.prepareStatement(
                     "DELETE FROM client WHERE id=?")) {

            statement.setInt(1, clientId);

            statement.execute();

        } catch (SQLException se) {
            logger.error("Problem with client deletion", se);
            throw new DatabaseException("Problem with client deletion", se);
        }
    }



}
