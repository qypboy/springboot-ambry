package com.ambry.common.context;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "当前登录用户信息")
public record LoginUser(
        @Schema(description = "用户ID") Long userId,
        @Schema(description = "账号") String username,
        @Schema(description = "工号") String userNo,
        @Schema(description = "角色编码列表") List<String> roleCodes
) {
    public static LoginUser anonymous() {
        return new LoginUser(0L, "anonymous", "anonymous", List.of());
    }
}
