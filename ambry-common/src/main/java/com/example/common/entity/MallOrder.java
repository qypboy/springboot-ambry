package com.example.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.common.enums.OrderStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mall_order")
public class MallOrder extends BaseEntity {
    private String orderNo;
    private Long userId;
    private BigDecimal totalAmount;
    private OrderStatus status;
    private String receiverName;
    private String receiverPhone;
    private String receiverRegionCode;
    private String receiverRegionName;
    private String receiverAddress;
}
