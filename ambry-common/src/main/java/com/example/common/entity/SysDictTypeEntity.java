package com.example.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_dict_type")
@Schema(description = "字典类型实体")
public class SysDictTypeEntity extends BaseEntity {
    @TableId(type = IdType.AUTO)
    @Schema(description = "字典类型主键ID")
    private Long id;
    @Schema(description = "字典编码")
    private String dictCode;
    @Schema(description = "字典名称")
    private String dictName;
    @Schema(description = "状态")
    private Integer status;
    @Schema(description = "备注")
    private String remark;
}
