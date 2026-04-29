package com.ambry.config.security;

import com.ambry.common.context.LoginUser;
import com.ambry.common.context.UserContext;
import com.ambry.common.enums.CodeMessageEnum;
import com.ambry.common.exception.CommonException;
import com.ambry.common.security.PermissionChecker;
import com.ambry.common.security.RequirePermission;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Arrays;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    private final JwtTokenProvider jwtTokenProvider;
    private final PermissionChecker permissionChecker;

    public AuthInterceptor(JwtTokenProvider jwtTokenProvider, PermissionChecker permissionChecker) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.permissionChecker = permissionChecker;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            UserContext.set(jwtTokenProvider.parse(header.substring(7)));
        }
        if (handler instanceof HandlerMethod handlerMethod) {
            checkPermission(handlerMethod);
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        UserContext.clear();
    }

    private void checkPermission(HandlerMethod handlerMethod) {
        RequirePermission requirePermission = handlerMethod.getMethodAnnotation(RequirePermission.class);
        if (requirePermission == null) {
            requirePermission = handlerMethod.getBeanType().getAnnotation(RequirePermission.class);
        }
        if (requirePermission == null) {
            return;
        }
        LoginUser user = UserContext.get();
        if (user == null || user.userId() == null || user.userId() <= 0) {
            throw new CommonException(CodeMessageEnum.AUTH_FORBIDDEN);
        }
        boolean allowed = permissionChecker.hasAnyPermission(user.userId(), Arrays.asList(requirePermission.value()));
        if (!allowed) {
            throw new CommonException(CodeMessageEnum.AUTH_FORBIDDEN);
        }
    }
}
