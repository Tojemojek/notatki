package pl.sda.javawwa;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import pl.sda.javawwa.model.AlbumDto;

import java.io.IOException;

//import org.apache.http.HttpStatus;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;

public class JasonHttpPostTestApp {



    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        Logger logger = Logger.getLogger(JasonHttpPostTestApp.class);
        logger.info("App started! (my precious)");



        postGet();

        logger.info("App is dead! (my precious)");
    }

    public static void postGet() throws IOException {

        Logger logger = Logger.getLogger(JasonHttpPostTestApp.class);

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost post = new HttpPost("https://jsonplaceholder.typicode.com/albums");
        post.addHeader("Accept", "Application/json");
        post.addHeader("Content-type", "Application/json");


        AlbumDto newAlbum = new AlbumDto();
        newAlbum.setTitle("Oj Oj");
        newAlbum.setUserId(1);

        String postJson = mapper.writeValueAsString(newAlbum);

        HttpEntity requestBody = new StringEntity(postJson);
        post.setEntity(requestBody);

        CloseableHttpResponse response = httpClient.execute(post);
        HttpEntity httpEntity = response.getEntity();
        String body = EntityUtils.toString(httpEntity);
        AlbumDto album = mapper.readValue(body, AlbumDto.class);
        logger.info(album);

    }
}
