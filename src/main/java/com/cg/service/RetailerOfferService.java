package com.cg.service;


import com.cg.model.RewardResponse;
import com.cg.model.TransactionRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service class to calculate reward points for customer transactions.
 */
@Service
public class RetailerOfferService {

    /**
     * Calculates reward points grouped by month and customer.
     * @param transactions list of transaction requests
     * @return Map containing customerId and list of monthly reward summaries
     */
    public List<RewardResponse> calculateRewards(List<TransactionRequest> transactions) {
        Map<String, Map<Month, Integer>> rewardMap = new HashMap<>();

        for (TransactionRequest tx : transactions) {
            int points = calculatePoints(tx.getAmount());
           // if (points == 0) continue;

            LocalDate date = LocalDate.parse(tx.getTransactionDate());
            Month month = date.getMonth();
            rewardMap
                    .computeIfAbsent(tx.getCustomerId(), k -> new HashMap<>())
                    .merge(month, points, Integer::sum);
        }

        return rewardMap.entrySet().stream()
                .map(entry -> {
                    String customerId = entry.getKey();
                    int total = entry.getValue().values().stream().mapToInt(Integer::intValue).sum();
                    return new RewardResponse(customerId, entry.getValue(), total);
                }).collect(Collectors.toList());
    }

    /**
     * Calculates reward points based on transaction amount.
     * - 2 points for every dollar over $100
     * - 1 point for every dollar between $50 and $100
     *
     * @param amount transaction amount
     * @return reward points
     */
    private int calculatePoints(int amount) {
        int points = 0;
        if (amount > 100) {
            points += (int) (2 * (amount - 100));
            points += 50; // from 50 to 100
        } else if (amount > 50) {
            points += (int) (amount - 50);
        }
        // No points if amount <= 50
        return points;
    }
}
