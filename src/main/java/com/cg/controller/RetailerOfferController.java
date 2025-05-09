package com.cg.controller;

import com.cg.model.RewardResponse;
import com.cg.model.TransactionRequest;
import com.cg.service.RetailerOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer/rewards")
public class RetailerOfferController {

    @Autowired
    private RetailerOfferService retailerOfferService;

    @PostMapping("/calculate")
    public ResponseEntity<List<RewardResponse>> calculateRewards(@RequestBody List<TransactionRequest> transactions) {
        List<RewardResponse> response = retailerOfferService.calculateRewards(transactions);
        return ResponseEntity.ok(response);
    }
}