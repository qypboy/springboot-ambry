package com.ambry.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("base_i18n")
@Schema(description = "国际化文本实体")
public class BaseI18nEntity extends BaseEntity {
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键ID")
    private Long id;
    @Schema(description = "国际化key")
    private String i18nKey;
    @Schema(description = "语言")
    private String locale;
    @Schema(description = "国际化值")
    private String i18nValue;
    @Schema(description = "备注")
    private String remark;
}

