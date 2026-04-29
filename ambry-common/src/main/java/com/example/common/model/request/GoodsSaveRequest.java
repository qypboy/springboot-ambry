package com.example.common.model.request;

import java.math.BigDecimal;

public record GoodsSaveRequest(String name, String categoryCode, String materialCode, BigDecimal price, Integer stock, String description, String imageUrl) {
}
