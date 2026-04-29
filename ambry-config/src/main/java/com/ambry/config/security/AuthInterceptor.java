package com.ambry.config.security;

import com.ambry.common.context.LoginUser;
import com.ambry.common.context.UserContext;
import com.ambry.common.enums.UserRoleEnum;
import com.ambry.common.exception.BusinessException;
import com.ambry.common.security.RequireRole;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Arrays;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    private final JwtTokenProvider jwtTokenProvider;

    public AuthInterceptor(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            UserContext.set(jwtTokenProvider.parse(header.substring(7)));
        }
        if (handler instanceof HandlerMethod handlerMethod) {
            checkRole(handlerMethod);
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        UserContext.clear();
    }

    private void checkRole(HandlerMethod handlerMethod) {
        RequireRole requireRole = handlerMethod.getMethodAnnotation(RequireRole.class);
        if (requireRole == null) {
            requireRole = handlerMethod.getBeanType().getAnnotation(RequireRole.class);
        }
        if (requireRole == null) {
            return;
        }
        LoginUser user = UserContext.get();
        UserRoleEnum role = user.role();
        boolean allowed = Arrays.asList(requireRole.value()).contains(role);
        if (!allowed) {
            throw new BusinessException("无权限访问");
        }
    }
}
