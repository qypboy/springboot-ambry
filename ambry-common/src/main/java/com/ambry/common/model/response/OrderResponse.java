package com.ambry.common.model.response;

import com.ambry.common.enums.OrderStatusEnum;

import java.math.BigDecimal;
import java.util.List;

public record OrderResponse(String orderNo, BigDecimal totalAmount, OrderStatusEnum status, String receiverRegionName, String receiverAddress, List<OrderItemResponse> items) {
    public record OrderItemResponse(Long goodsId, String goodsName, BigDecimal price, Integer quantity) {
    }
}
