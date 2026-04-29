package com.example.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mall_order_item")
@Schema(description = "订单明细实体")
public class MallOrderItemEntity extends BaseEntity {
    @TableId(type = IdType.AUTO)
    @Schema(description = "订单明细主键ID")
    private Long id;
    @Schema(description = "订单ID")
    private Long orderId;
    @Schema(description = "商品ID")
    private Long goodsId;
    @Schema(description = "商品名称快照")
    private String goodsName;
    @Schema(description = "单价快照")
    private BigDecimal price;
    @Schema(description = "数量")
    private Integer quantity;
    @Schema(description = "定制参数JSON")
    private String customOptionsJson;
}
