package nl.thk.api.controllers;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalculationManualControllerTest {

    @Autowired
    MockMvc mockMvc;

    //BE Integration tests..
    @Test
    @Order(0)
    void additon() throws Exception {

        String expectedResponse = "{\"calculation\":\"11+7=18.0\"}";

        mockMvc.perform(post("/manual/fe/calculations/add")
                .content("{\"a\": \"11\",\"b\": \"7\" }")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponse))
                .andReturn();
    }

    @Test
    @Order(1)
    void additonFaultyA() throws Exception {

        String expectedResponse = "{\"calculation\":\"0+7=7.0\"}";

        mockMvc.perform(post("/manual/fe/calculations/add")
                .content("{\"a\": \"null\",\"b\": \"7\" }")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponse))
                .andReturn();
    }

    @Test
    @Order(2)
    void additonFaultyB() throws Exception { //Shuld this be thrown.

        String expectedResponse = "{\"calculation\":\"11+0=11.0\"}";

        mockMvc.perform(post("/manual/fe/calculations/add")
                .content("{\"a\": \"11\"}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponse))
                .andReturn();
    }

    @Test
    @Order(3)
    void additonNothingPlusNothing() throws Exception {

        String expectedResponse = "{\"calculation\":\"0+0=0.0\"}";

        mockMvc.perform(post("/manual/fe/calculations/add")
                .content("{}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponse))
                .andReturn();
    }

    // Etc for subtract & multiply and divide.. but more of the same
    // What is different is..
    @Test
    @Order(4)
    void getAllCalculations() throws Exception {

        mockMvc.perform(get("/manual/fe/calculations")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", isA(ArrayList.class)))
                .andExpect(jsonPath("$.*", hasSize(4)))
                .andExpect(jsonPath("$[0].created", startsWith("20")))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].calculation", is("11+7=18.0")))
                .andReturn();
    }

}
