package com.ambry.common.model.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "注册请求")
public record RegisterRequest(
        @Schema(description = "账号") String username,
        @Schema(description = "密码") String password,
        @Schema(description = "手机号") String phone,
        @Schema(description = "地址") String address
) {
}
