package com.cg.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RewardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCalculateRewards() throws Exception {
        String jsonRequest = """
        [
          {
            "customerId": "CUST1001",
            "transactionDate": "2025-04-01",
            "amount": 120
          },
          {
            "customerId": "CUST1001",
            "transactionDate": "2025-04-10",
            "amount": 75
          }
        ]
        """;

        mockMvc.perform(post("/customer/rewards/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                ;
    }
}