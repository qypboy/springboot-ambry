package com.example.common.model.response;

import com.example.common.enums.UserRole;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "登录注册返回")
public record AuthResponse(
        @Schema(description = "用户ID") Long userId,
        @Schema(description = "账号") String username,
        @Schema(description = "角色") UserRole role,
        @Schema(description = "访问令牌") String token
) {
}
