package com.example.common.model.request;

import java.math.BigDecimal;
import java.util.Map;

public record PricingRequest(String goodsType, BigDecimal width, BigDecimal height, Integer quantity, String materialCode, String glassCode, Map<String, Integer> accessories) {
}
