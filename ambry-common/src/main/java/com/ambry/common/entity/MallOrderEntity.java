package com.ambry.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ambry.common.enums.OrderStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mall_order")
@Schema(description = "订单实体")
public class MallOrderEntity extends BaseEntity {
    @TableId(type = IdType.AUTO)
    @Schema(description = "订单主键ID")
    private Long id;
    @Schema(description = "订单号")
    private String orderNo;
    @Schema(description = "用户ID")
    private Long userId;
    @Schema(description = "总金额")
    private BigDecimal totalAmount;
    @Schema(description = "订单状态")
    private OrderStatus status;
    @Schema(description = "收货人")
    private String receiverName;
    @Schema(description = "收货电话")
    private String receiverPhone;
    @Schema(description = "收货区域编码")
    private String receiverRegionCode;
    @Schema(description = "收货区域名称快照")
    private String receiverRegionName;
    @Schema(description = "详细地址")
    private String receiverAddress;
}
