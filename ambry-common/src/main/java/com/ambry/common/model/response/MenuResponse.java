package com.ambry.common.model.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "菜单返回")
public record MenuResponse(
        @Schema(description = "菜单编码") String menuCode,
        @Schema(description = "菜单名称") String menuName,
        @Schema(description = "菜单名称i18nKey") String menuNameI18nKey,
        @Schema(description = "父菜单编码") String parentCode,
        @Schema(description = "权限编码") String permissionCode,
        @Schema(description = "路由") String routePath,
        @Schema(description = "组件") String componentPath,
        @Schema(description = "菜单类型") String menuType,
        @Schema(description = "排序") Integer sort
) {
}

