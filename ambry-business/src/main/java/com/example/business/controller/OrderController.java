package com.example.business.controller;

import com.example.business.manager.OrderManager;
import com.example.common.model.request.OrderCreateRequest;
import com.example.common.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "订单接口", description = "订单创建、订单查询、订单明细快照")
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderManager orderManager;

    public OrderController(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    @Operation(summary = "订单列表", description = "按用户查询订单")
    @GetMapping
    public Result<?> list(@RequestParam(required = false) Long userId) {
        return Result.success(orderManager.list(userId));
    }

    @Operation(summary = "创建订单", description = "创建订单并保存商品快照")
    @PostMapping
    public Result<?> create(@RequestBody OrderCreateRequest request) {
        return Result.success(orderManager.create(request));
    }
}
