package com.example.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mall_order_item")
public class MallOrderItem extends BaseEntity {
    private Long orderId;
    private Long goodsId;
    private String goodsName;
    private BigDecimal price;
    private Integer quantity;
    private String customOptionsJson;
}
