package com.example.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("goods")
public class Goods extends BaseEntity {
    private String name;
    private String categoryCode;
    private String materialCode;
    private BigDecimal price;
    private Integer stock;
    private String description;
    private String imageUrl;
    private Integer enabled;
}
