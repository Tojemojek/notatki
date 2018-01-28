package pl.javawwa.odersapp.products.client;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import java.util.List;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;


@RunWith(SpringRunner.class)
@SpringBootTest
@RestClientTest(ProductClientImpl.class)
public class ProductClientImplMockTest {


    @Autowired
    private ProductClient productClient;

    @Autowired
    private MockRestServiceServer mockRestServiceServer;


    @Before
    public void setUp() {
        mockRestServiceServer.expect(requestTo("/products/1"))
                .andRespond(withSuccess(
                        "{\"id\":1,\"name\":\"Co innego\",\"productType\":\"Jedzonko\",\"quantity\":462}", MediaType.APPLICATION_JSON));
    }


    @Test
    public void findAll() {
        List<ProductDto> all = productClient.findAll();
        System.out.println(all.size());

        Assert.assertTrue(all.size() > 90);
    }

    @Test
    public void findById() {

        ProductDto byId = productClient.findById(1);
        Assert.assertEquals("Co innego", byId.getName());

    }
}