package com.example.business.order.service;

import com.example.common.model.request.OrderCreateRequest;
import com.example.common.model.response.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse create(OrderCreateRequest request);

    List<OrderResponse> list(Long userId);
}
