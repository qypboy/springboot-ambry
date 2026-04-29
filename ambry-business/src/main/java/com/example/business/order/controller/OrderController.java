package com.example.business.order.controller;

import com.example.business.order.service.OrderService;
import com.example.common.model.request.OrderCreateRequest;
import com.example.common.result.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public Result<?> list(@RequestParam(required = false) Long userId) {
        return Result.success(orderService.list(userId));
    }

    @PostMapping
    public Result<?> create(@RequestBody OrderCreateRequest request) {
        return Result.success(orderService.create(request));
    }
}
