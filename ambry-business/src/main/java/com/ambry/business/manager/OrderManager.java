package com.ambry.business.manager;

import com.alibaba.fastjson2.JSON;
import com.ambry.business.service.GoodsService;
import com.ambry.business.service.OrderItemService;
import com.ambry.business.service.OrderService;
import com.ambry.common.entity.GoodsEntity;
import com.ambry.common.entity.MallOrderEntity;
import com.ambry.common.entity.MallOrderItemEntity;
import com.ambry.common.enums.OrderStatusEnum;
import com.ambry.common.model.request.OrderCreateRequest;
import com.ambry.common.model.response.OrderResponse;
import com.ambry.common.util.OrderNoUtil;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Component
public class OrderManager {
    private final OrderService orderService;
    private final OrderItemService orderItemService;
    private final GoodsService goodsService;

    public OrderManager(OrderService orderService, OrderItemService orderItemService, GoodsService goodsService) {
        this.orderService = orderService;
        this.orderItemService = orderItemService;
        this.goodsService = goodsService;
    }

    @Transactional(rollbackFor = Exception.class)
    public OrderResponse create(OrderCreateRequest request) {
        MallOrderEntity order = new MallOrderEntity();
        order.setOrderNo(OrderNoUtil.next());
        order.setUserId(request.userId());
        order.setStatus(OrderStatusEnum.WAIT_CONFIRM);
        order.setReceiverName(request.receiverName());
        order.setReceiverPhone(request.receiverPhone());
        order.setReceiverRegionCode(request.receiverRegionCode());
        order.setReceiverRegionName(request.receiverRegionName());
        order.setReceiverAddress(request.receiverAddress());
        order.setTotalAmount(BigDecimal.ZERO);
        orderService.save(order);
        List<OrderResponse.OrderItemResponse> items = request.goodsList().stream().map(goods -> buildOrderItem(order, goods)).toList();
        BigDecimal total = items.stream().map(item -> item.price().multiply(BigDecimal.valueOf(item.quantity()))).reduce(BigDecimal.ZERO, BigDecimal::add);
        order.setTotalAmount(total);
        orderService.updateById(order);
        return new OrderResponse(order.getOrderNo(), total, order.getStatus(), order.getReceiverRegionName(), order.getReceiverAddress(), items);
    }

    public List<OrderResponse> list(Long userId) {
        return orderService.lambdaQuery()
                .eq(userId != null, MallOrderEntity::getUserId, userId)
                .eq(MallOrderEntity::getDeleted, 0)
                .list()
                .stream()
                .map(order -> new OrderResponse(order.getOrderNo(), order.getTotalAmount(), order.getStatus(), order.getReceiverRegionName(), order.getReceiverAddress(), List.of()))
                .toList();
    }

    private OrderResponse.OrderItemResponse buildOrderItem(MallOrderEntity order, OrderCreateRequest.OrderGoodsRequest request) {
        GoodsEntity goods = goodsService.getById(request.goodsId());
        MallOrderItemEntity item = new MallOrderItemEntity();
        item.setOrderId(order.getId());
        item.setGoodsId(goods.getId());
        item.setGoodsName(goods.getName());
        item.setPrice(goods.getPrice());
        item.setQuantity(request.quantity());
        item.setCustomOptionsJson(JSON.toJSONString(request.customOptions()));
        orderItemService.save(item);
        return new OrderResponse.OrderItemResponse(goods.getId(), goods.getName(), goods.getPrice(), request.quantity());
    }
}
