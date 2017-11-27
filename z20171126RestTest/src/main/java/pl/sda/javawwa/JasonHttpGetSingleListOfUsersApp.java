package pl.sda.javawwa;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import pl.sda.javawwa.model.AlbumDto;
import pl.sda.javawwa.model.PersonDto;

import java.io.IOException;
import java.util.List;

public class JasonHttpGetSingleListOfUsersApp {


    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        Logger logger = Logger.getLogger(JasonHttpGetSingleListOfUsersApp.class);
        logger.info("App started! (my precious)");

        testGet();

        logger.info("App is dead! (my precious)");
    }

    public static void testGet() throws IOException {

        Logger logger = Logger.getLogger(JasonHttpGetSingleListOfUsersApp.class);

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet get = new HttpGet("https://jsonplaceholder.typicode.com/users");
        get.addHeader("Accept", "Application/json");
        get.addHeader("Content-type", "Application/json");

        CloseableHttpResponse response = httpClient.execute(get);

        HttpEntity httpEntity = response.getEntity();

        String body = EntityUtils.toString(httpEntity);

        List<PersonDto> readPersonList = mapper.readValue(body, new TypeReference<List<PersonDto>>(){});

        logger.info(readPersonList);


    }
}
