package com.ambry.common.model.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "登录注册返回")
public record AuthResponse(
        @Schema(description = "用户ID") Long userId,
        @Schema(description = "账号") String username,
        @Schema(description = "角色编码列表") List<String> roleCodes,
        @Schema(description = "访问令牌") String token
) {
}
