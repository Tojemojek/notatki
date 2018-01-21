package pl.kostrowski.spring.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldTestfindAll() throws Exception {
        mockMvc.perform(get("/products/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name",is("Jabko")))
                .andExpect(jsonPath("$[0].productType",is("FOOD")))
                .andExpect(jsonPath("$[1].name",is("HoraCórka")))
                .andExpect(jsonPath("$[1].productType",is("ELECTRONICS")));
    }


    @Test
    public void shouldTestfindAllWithContents() throws Exception {
        mockMvc.perform(get("/products/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is("Jabko")))
                .andExpect(jsonPath("$.productType",is("FOOD")));
    }
}


