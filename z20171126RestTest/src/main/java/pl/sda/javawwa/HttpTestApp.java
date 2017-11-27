package pl.sda.javawwa;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
//import org.apache.http.HttpStatus;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;

import java.io.IOException;

public class HttpTestApp {


    public static void main(String[] args) throws IOException {

        Logger logger = Logger.getLogger(HttpTestApp.class);
        logger.info("App started! (my precious)");

        testGet();

        logger.info("App is dead! (my precious)");
    }

    public static void testGet() throws IOException {

        Logger logger = Logger.getLogger(HttpTestApp.class);

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet get = new HttpGet("https://jsonplaceholder.typicode.com/users");
        get.addHeader("Accept", "Application/json");
        get.addHeader("Content-type", "Application/json");
        get.addHeader("X-Inny", "cokolwiek");

        CloseableHttpResponse response = httpClient.execute(get);
        Header[] allHeaders = response.getAllHeaders();

        for (Header allHeader : allHeaders) {
            logger.error(allHeader.getName() + ":" + allHeader.getValue());
        }


        HttpEntity httpEntity = response.getEntity();

        //        To jest pobranie strumienia danych wersja prymitywniejsza
        //        BufferedReader br = new BufferedReader(new InputStreamReader(httpEntity.getContent()));

        logger.info(response.getStatusLine().toString());

        if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK){
            EntityUtils.consumeQuietly(httpEntity);
            logger.error("Error not HTTP 200");
            return;
        }

        // Klasa która ma kody jako stałe wpisane
        // HttpStatus.

        String body = EntityUtils.toString(httpEntity);

        logger.error(body);

    }
}
