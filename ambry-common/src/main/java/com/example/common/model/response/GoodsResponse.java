package com.example.common.model.response;

import java.math.BigDecimal;

public record GoodsResponse(Long id, String name, String categoryCode, String materialCode, BigDecimal price, Integer stock, String description, String imageUrl) {
}
