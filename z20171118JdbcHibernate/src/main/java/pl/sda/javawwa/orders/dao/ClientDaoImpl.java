package pl.sda.javawwa.orders.dao;

import org.apache.log4j.Logger;
import pl.sda.javawwa.orders.entieties.Client;
import pl.sda.javawwa.orders.entieties.ClientType;

import java.sql.*;

public class ClientDaoImpl implements ClientDao {

    public static final String MY_SQL_CONNECTION_STRING = "jdbc:mysql://localhost/orders?" + "user=root&password=root";
    private Logger logger = Logger.getLogger(ClientDaoImpl.class);

    @Override
    public Client findById(Integer id) {

        Connection connection = null;
        Client client = null;
        try {
            logger.info("Trying to get connection...");
            connection = DriverManager.getConnection(MY_SQL_CONNECTION_STRING);
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT id, first_name, second_name, email, type FROM client WHERE id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();


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
        }

        return client;
    }
}
