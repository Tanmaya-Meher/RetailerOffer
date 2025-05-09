package com.cg.service;

import com.cg.model.RewardResponse;
import com.cg.model.TransactionRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RetailerOfferServiceTest {

    @InjectMocks
    private RetailerOfferService retailerOfferService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCalculateRewardsForMultipleCustomers() {
        TransactionRequest tx1 = new TransactionRequest("CUST1", "2025-03-01", 120);
        TransactionRequest tx2 = new TransactionRequest("CUST1", "2025-03-20", 75);
        TransactionRequest tx3 = new TransactionRequest("CUST2", "2025-04-01", 130);
        TransactionRequest tx4 = new TransactionRequest("CUST2", "2025-04-15", 95);
        TransactionRequest tx5 = new TransactionRequest("CUST3", "2024-05-05", 45);

        List<RewardResponse> rewards = retailerOfferService.calculateRewards(Arrays.asList(tx1, tx2, tx3, tx4, tx5));
       // Map<String, RewardResponse> rewards = retailerOfferService.calculateRewards(transactions);

        RewardResponse cust1 = rewards.stream().filter(r -> r.getCustomerId().equals("CUST1")).findFirst().orElse(null);
        assertNotNull(cust1);
        assertEquals(115, cust1.getTotalRewards());

        RewardResponse cust2 = rewards.stream().filter(r -> r.getCustomerId().equals("CUST2")).findFirst().orElse(null);
        assertNotNull(cust2);
        assertEquals(155, cust2.getTotalRewards());

        //if spend is less then 50 then no reward point
        RewardResponse cust3 = rewards.stream().filter(r -> r.getCustomerId().equals("CUST3")).findFirst().orElse(null);
        assertNotNull(cust3);
        assertEquals(0, cust3.getTotalRewards());
    }
    }
