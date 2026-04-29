package com.example.common.model.response;

import com.example.common.enums.OrderStatus;

import java.math.BigDecimal;
import java.util.List;

public record OrderResponse(String orderNo, BigDecimal totalAmount, OrderStatus status, String receiverRegionName, String receiverAddress, List<OrderItemResponse> items) {
    public record OrderItemResponse(Long goodsId, String goodsName, BigDecimal price, Integer quantity) {
    }
}
