package com.ambry.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role_menu")
@Schema(description = "角色菜单关系实体")
public class SysRoleMenuEntity extends BaseEntity {
    @TableId(type = IdType.AUTO)
    @Schema(description = "关系主键ID")
    private Long id;
    @Schema(description = "角色编码")
    private String roleCode;
    @Schema(description = "菜单编码")
    private String menuCode;
}

