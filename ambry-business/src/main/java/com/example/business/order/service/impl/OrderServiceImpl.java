package com.example.business.order.service.impl;

import com.example.business.goods.service.GoodsService;
import com.example.business.order.service.OrderService;
import com.example.common.enums.OrderStatus;
import com.example.common.model.request.OrderCreateRequest;
import com.example.common.model.response.GoodsResponse;
import com.example.common.model.response.OrderResponse;
import com.example.common.util.OrderNoUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final GoodsService goodsService;
    private final List<OrderResponse> orders = new ArrayList<>();

    public OrderServiceImpl(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @Override
    public OrderResponse create(OrderCreateRequest request) {
        List<OrderResponse.OrderItemResponse> items = request.goodsList().stream().map(goods -> {
            GoodsResponse detail = goodsService.detail(goods.goodsId());
            return new OrderResponse.OrderItemResponse(detail.id(), detail.name(), detail.price(), goods.quantity());
        }).toList();
        BigDecimal total = items.stream()
                .map(item -> item.price().multiply(BigDecimal.valueOf(item.quantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        OrderResponse response = new OrderResponse(OrderNoUtil.next(), total, OrderStatus.WAIT_CONFIRM, request.receiverRegionName(), request.receiverAddress(), items);
        orders.add(response);
        return response;
    }

    @Override
    public List<OrderResponse> list(Long userId) {
        return orders;
    }
}
