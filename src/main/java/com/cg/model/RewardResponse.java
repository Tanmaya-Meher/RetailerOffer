package com.cg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Month;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RewardResponse {

//    private String customerId;
//    private Map<String,Integer> monthlyPoints;
//
//    private int totalPoints;

    private String customerId;
    private Map<Month, Integer> rewardsByMonth;
    private int totalRewards;
}
