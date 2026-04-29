package com.ambry.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_menu")
@Schema(description = "系统菜单实体")
public class SysMenuEntity extends BaseEntity {
    @TableId(type = IdType.AUTO)
    @Schema(description = "菜单主键ID")
    private Long id;
    @Schema(description = "菜单编码")
    private String menuCode;
    @Schema(description = "菜单名称i18nKey")
    private String menuNameI18nKey;
    @Schema(description = "父菜单编码")
    private String parentCode;
    @Schema(description = "权限编码")
    private String permissionCode;
    @Schema(description = "路由路径")
    private String routePath;
    @Schema(description = "组件路径")
    private String componentPath;
    @Schema(description = "图标")
    private String icon;
    @Schema(description = "菜单类型")
    private String menuType;
    @Schema(description = "排序")
    private Integer sort;
    @Schema(description = "是否启用")
    private Integer enabled;
    @Schema(description = "备注")
    private String remark;
}

