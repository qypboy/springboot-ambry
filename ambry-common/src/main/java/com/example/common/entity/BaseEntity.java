package com.example.common.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "基础实体，所有表实体必须继承")
public abstract class BaseEntity {
    @Schema(description = "是否删除：0-否，1-是")
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;

    @Schema(description = "创建人")
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    @Schema(description = "创建人工号")
    @TableField(fill = FieldFill.INSERT)
    private String createByNo;

    @Schema(description = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @Schema(description = "更新人")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    @Schema(description = "更新人工号")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateByNo;

    @Schema(description = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
