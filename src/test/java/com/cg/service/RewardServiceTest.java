package com.cg.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RewardServiceTest {

    private RewardService rewardService = new RewardService();

    @Test
    void testCalculateRewardsForSingleCustomer() {
        List<CustomerTransaction> transactions = List.of(
                new CustomerTransaction("CUST1001", LocalDate.of(2025, 4, 1), 195),
                new CustomerTransaction("CUST1002", LocalDate.of(2025, 5, 5), 75)
        );

        Map<String, Map<String, Integer>> rewards = rewardService.calculateRewards(transactions);


        assertTrue(rewards.containsKey("CUST1001"));
        assertEquals(90, rewards.get("CUST1001").get("APRIL"));
    }
}