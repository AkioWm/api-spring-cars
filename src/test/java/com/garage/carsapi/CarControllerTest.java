package com.garage.carsapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class CarControllerTest {

    private MockMvc mockMvc;

    public CarControllerTest(MockMvc mockMvc){
        this.mockMvc = mockMvc;
    }

    @Test
    public void testGetCars() throws Exception {
        mockMvc.perform(get("/cars"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].makeName", is("Nissan")));
    }

    @Test
    public void testOneCar() throws Exception {
        mockMvc.perform(get("/car/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("modelName", is("GTR")));
    }
}
