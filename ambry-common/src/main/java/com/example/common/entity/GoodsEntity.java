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
@TableName("goods")
@Schema(description = "商品实体")
public class GoodsEntity extends BaseEntity {
    @TableId(type = IdType.AUTO)
    @Schema(description = "商品主键ID")
    private Long id;
    @Schema(description = "商品名称")
    private String name;
    @Schema(description = "分类编码")
    private String categoryCode;
    @Schema(description = "材质编码")
    private String materialCode;
    @Schema(description = "价格")
    private BigDecimal price;
    @Schema(description = "库存")
    private Integer stock;
    @Schema(description = "描述")
    private String description;
    @Schema(description = "图片地址")
    private String imageUrl;
    @Schema(description = "是否启用")
    private Integer enabled;
}
