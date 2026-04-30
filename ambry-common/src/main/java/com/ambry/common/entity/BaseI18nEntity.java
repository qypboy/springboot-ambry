package com.ambry.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.transsion.mps.util.i18n.enums.I18nModuleEnum;
import com.transsion.mps.util.i18n.enums.LanguageEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@TableName("base_i18n")
@EqualsAndHashCode(callSuper = true)
public class BaseI18nEntity extends BaseEntity {

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 模块
     */
    private I18nModuleEnum module;

    /**
     * 键
     */
    @TableField(value = "`key`")
    private Long key;

    /**
     * 值
     */
    private String value;

    /**
     * 语言
     */
    private LanguageEnum language;
}