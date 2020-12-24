package com.example.swaggerexample.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
public class CategoriesControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("OK ")
    public void shouldReturnOKOnGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/categories"))
                .andExpect(status().isOk());
    }
}
