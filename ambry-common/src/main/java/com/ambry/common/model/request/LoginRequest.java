package com.ambry.common.model.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "登录请求")
public record LoginRequest(
        @Schema(description = "账号", requiredMode = Schema.RequiredMode.REQUIRED) String username,
        @Schema(description = "密码", requiredMode = Schema.RequiredMode.REQUIRED) String password
) {
}
