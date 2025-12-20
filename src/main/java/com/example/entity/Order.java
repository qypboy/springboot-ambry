package com.example.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("order")
public class Order {
    
    @TableId(type = IdType.AUTO)
    private Long id;
    
    private Long userId;
    
    private String orderNumber;
    
    private BigDecimal totalPrice;
    
    private String status; // 订单状态：待付款、已付款、配送中、已完成、已取消
    
    private String receiverName;
    
    private String receiverPhone;
    
    private String receiverAddress;
    
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    
    @TableLogic
    private Integer deleted;
}