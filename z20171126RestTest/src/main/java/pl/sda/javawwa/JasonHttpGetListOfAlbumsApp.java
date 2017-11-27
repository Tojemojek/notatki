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

import java.io.IOException;
import java.util.List;

//import org.apache.http.HttpStatus;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;

public class JasonHttpGetListOfAlbumsApp {


    //todo zrobić to dla users
    //ale teraz testujemy albums

    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        Logger logger = Logger.getLogger(JasonHttpGetListOfAlbumsApp.class);
        logger.info("App started! (my precious)");

        testGet();

        logger.info("App is dead! (my precious)");
    }

    public static void testGet() throws IOException {

        Logger logger = Logger.getLogger(JasonHttpGetListOfAlbumsApp.class);

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet get = new HttpGet("https://jsonplaceholder.typicode.com/albums");
        get.addHeader("Accept", "Application/json");
        get.addHeader("Content-type", "Application/json");

        CloseableHttpResponse response = httpClient.execute(get);

        HttpEntity httpEntity = response.getEntity();

        String body = EntityUtils.toString(httpEntity);

        List<AlbumDto> listOfAlbums = mapper.readValue (body,new TypeReference<List<AlbumDto>>(){});

        logger.info(listOfAlbums);


    }
}
