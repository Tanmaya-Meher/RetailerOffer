package com.cg.model;

import lombok.Data;

@Data
public class TransactionRequest {
    private String customerId;
    private String transactionDate; // Format: yyyy-MM-dd
    private int amount;
}
