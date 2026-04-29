package com.example.common.model.response;

import java.math.BigDecimal;
import java.util.List;

public record PricingResponse(BigDecimal area, Integer quantity, BigDecimal totalPrice, List<PricingLineResponse> lines) {
    public record PricingLineResponse(String name, String expression, BigDecimal amount) {
    }
}
