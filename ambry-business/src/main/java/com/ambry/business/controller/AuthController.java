package com.ambry.business.controller;

import com.ambry.business.manager.AuthManager;
import com.ambry.common.model.request.LoginRequest;
import com.ambry.common.model.request.RegisterRequest;
import com.ambry.common.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "认证接口", description = "登录、注册、JWT签发")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthManager authManager;

    public AuthController(AuthManager authManager) {
        this.authManager = authManager;
    }

    @Operation(summary = "用户登录", description = "校验账号密码并返回JWT令牌")
    @PostMapping("/login")
    public Result<?> login(@RequestBody LoginRequest request) {
        return Result.success(authManager.login(request));
    }

    @Operation(summary = "用户注册", description = "注册客户账号并返回JWT令牌")
    @PostMapping("/register")
    public Result<?> register(@RequestBody RegisterRequest request) {
        return Result.success(authManager.register(request));
    }
}
