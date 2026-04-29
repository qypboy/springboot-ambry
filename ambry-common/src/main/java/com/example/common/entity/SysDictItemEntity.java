package com.example.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_dict_item")
@Schema(description = "字典项实体")
public class SysDictItemEntity extends BaseEntity {
    @TableId(type = IdType.AUTO)
    @Schema(description = "字典项主键ID")
    private Long id;
    @Schema(description = "字典编码")
    private String dictCode;
    @Schema(description = "字典值")
    private String itemValue;
    @Schema(description = "字典标签")
    private String itemLabel;
    @Schema(description = "排序")
    private Integer sort;
    @Schema(description = "状态")
    private Integer status;
    @Schema(description = "备注")
    private String remark;
}
