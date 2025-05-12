package com.cg.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
    @NotBlank(message = "customerId is required")
    private String customerId;
    @NotNull(message = "transactionDate is required")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "transactionDate must be in the format yyyy-MM-dd")
    private String transactionDate; // Format: yyyy-MM-dd
    @Positive(message = "amount must be greater than 0")
    private int amount;
}
