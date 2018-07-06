package com.bluepro.boy.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

@RunWith(value = SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BoyControllerTest {
    @Autowired
    private MockMvc mock;

    @Test
    public void findAllBoy() throws Exception {
        mock.perform(MockMvcRequestBuilders.get("/boys"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}