package pl.sda.javawwa;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import pl.sda.javawwa.model.AlbumDto;

import java.io.IOException;

//import org.apache.http.HttpStatus;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;

public class JasonHttpGetApp {


    //todo zrobić to dla users
    //ale teraz testujemy albums

    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        Logger logger = Logger.getLogger(JasonHttpGetApp.class);
        logger.info("App started! (my precious)");

        testGet();

        logger.info("App is dead! (my precious)");
    }

    public static void testGet() throws IOException {

        Logger logger = Logger.getLogger(JasonHttpGetApp.class);

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet get = new HttpGet("https://jsonplaceholder.typicode.com/albums/1");
        get.addHeader("Accept", "Application/json");
        get.addHeader("Content-type", "Application/json");

        CloseableHttpResponse response = httpClient.execute(get);

        HttpEntity httpEntity = response.getEntity();

        String body = EntityUtils.toString(httpEntity);

        AlbumDto album = mapper.readValue(body, AlbumDto.class);

        logger.info(album);


    }
}
