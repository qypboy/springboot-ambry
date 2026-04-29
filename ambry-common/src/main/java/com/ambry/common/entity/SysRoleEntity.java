package com.ambry.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role")
@Schema(description = "系统角色实体")
public class SysRoleEntity extends BaseEntity {
    @TableId(type = IdType.AUTO)
    @Schema(description = "角色主键ID")
    private Long id;
    @Schema(description = "角色编码")
    private String roleCode;
    @Schema(description = "角色名称i18nKey")
    private String roleNameI18nKey;
    @Schema(description = "排序")
    private Integer sort;
    @Schema(description = "是否启用")
    private Integer enabled;
    @Schema(description = "备注")
    private String remark;
}
