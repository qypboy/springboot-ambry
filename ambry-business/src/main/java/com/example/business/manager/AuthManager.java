package com.example.business.manager;

import com.example.business.service.UserService;
import com.example.common.context.LoginUser;
import com.example.common.entity.SysUserEntity;
import com.example.common.enums.UserRole;
import com.example.common.exception.BusinessException;
import com.example.common.model.request.LoginRequest;
import com.example.common.model.request.RegisterRequest;
import com.example.common.model.response.AuthResponse;
import com.example.config.security.JwtTokenProvider;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.stereotype.Component;

@Component
@Schema(description = "认证业务编排")
public class AuthManager {
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthManager(UserService userService, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public AuthResponse login(LoginRequest request) {
        SysUserEntity user = userService.lambdaQuery().eq(SysUserEntity::getUsername, request.username()).one();
        if (user == null || !user.getPassword().equals(request.password())) {
            throw new BusinessException("用户名或密码错误");
        }
        LoginUser loginUser = new LoginUser(user.getId(), user.getUsername(), user.getUsername(), user.getRole());
        return new AuthResponse(user.getId(), user.getUsername(), user.getRole(), jwtTokenProvider.createToken(loginUser));
    }

    public AuthResponse register(RegisterRequest request) {
        SysUserEntity user = new SysUserEntity();
        user.setUsername(request.username());
        user.setPassword(request.password());
        user.setPhone(request.phone());
        user.setAddress(request.address());
        user.setRole(UserRole.CUSTOMER);
        user.setEnabled(1);
        userService.save(user);
        LoginUser loginUser = new LoginUser(user.getId(), user.getUsername(), user.getUsername(), user.getRole());
        return new AuthResponse(user.getId(), user.getUsername(), user.getRole(), jwtTokenProvider.createToken(loginUser));
    }
}
