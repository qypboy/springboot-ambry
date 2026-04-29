package com.ambry.business.security;

import com.ambry.business.service.MenuService;
import com.ambry.business.service.RoleMenuService;
import com.ambry.business.service.UserRoleService;
import com.ambry.common.entity.SysMenuEntity;
import com.ambry.common.entity.SysRoleMenuEntity;
import com.ambry.common.security.PermissionChecker;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DatabasePermissionChecker implements PermissionChecker {
    private final UserRoleService userRoleService;
    private final RoleMenuService roleMenuService;
    private final MenuService menuService;

    public DatabasePermissionChecker(UserRoleService userRoleService, RoleMenuService roleMenuService, MenuService menuService) {
        this.userRoleService = userRoleService;
        this.roleMenuService = roleMenuService;
        this.menuService = menuService;
    }

    @Override
    public boolean hasAnyPermission(Long userId, Collection<String> permissions) {
        if (userId == null || CollectionUtils.isEmpty(permissions)) {
            return false;
        }
        Set<String> required = permissions.stream().filter(StringUtils::hasText).collect(Collectors.toSet());
        if (required.isEmpty()) {
            return false;
        }
        List<String> roleCodes = userRoleService.lambdaQuery()
                .eq(com.ambry.common.entity.SysUserRoleEntity::getUserId, userId)
                .eq(com.ambry.common.entity.SysUserRoleEntity::getDeleted, 0)
                .list()
                .stream()
                .map(com.ambry.common.entity.SysUserRoleEntity::getRoleCode)
                .filter(StringUtils::hasText)
                .toList();
        if (roleCodes.isEmpty()) {
            return false;
        }
        List<String> menuCodes = roleMenuService.lambdaQuery()
                .in(SysRoleMenuEntity::getRoleCode, roleCodes)
                .eq(SysRoleMenuEntity::getDeleted, 0)
                .list()
                .stream()
                .map(SysRoleMenuEntity::getMenuCode)
                .filter(StringUtils::hasText)
                .distinct()
                .toList();
        if (menuCodes.isEmpty()) {
            return false;
        }
        return menuService.lambdaQuery()
                .in(SysMenuEntity::getMenuCode, menuCodes)
                .in(SysMenuEntity::getPermissionCode, required)
                .eq(SysMenuEntity::getEnabled, 1)
                .eq(SysMenuEntity::getDeleted, 0)
                .count() > 0;
    }
}

