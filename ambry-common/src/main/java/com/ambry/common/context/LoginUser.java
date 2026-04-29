package com.ambry.common.context;

import com.ambry.common.enums.UserRole;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "当前登录用户信息")
public record LoginUser(
        @Schema(description = "用户ID") Long userId,
        @Schema(description = "账号") String username,
        @Schema(description = "工号") String userNo,
        @Schema(description = "角色") UserRole role
) {
    public static LoginUser anonymous() {
        return new LoginUser(0L, "anonymous", "anonymous", UserRole.CUSTOMER);
    }
}
