package com.ambry.common.model.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "角色返回")
public record RoleResponse(
        @Schema(description = "角色编码") String roleCode,
        @Schema(description = "角色名称") String roleName,
        @Schema(description = "角色名称i18nKey") String roleNameI18nKey,
        @Schema(description = "排序") Integer sort,
        @Schema(description = "是否启用") Integer enabled
) {
}

