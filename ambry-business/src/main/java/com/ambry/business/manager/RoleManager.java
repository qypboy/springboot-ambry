package com.ambry.business.manager;

import com.ambry.business.service.RoleService;
import com.ambry.common.model.response.RoleResponse;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleManager {
    private final RoleService roleService;
    private final I18nLookup i18nLookup;

    public RoleManager(RoleService roleService, I18nLookup i18nLookup) {
        this.roleService = roleService;
        this.i18nLookup = i18nLookup;
    }

    public List<RoleResponse> list() {
        return roleService.lambdaQuery()
                .eq(com.ambry.common.entity.SysRoleEntity::getDeleted, 0)
                .orderByAsc(com.ambry.common.entity.SysRoleEntity::getSort)
                .list()
                .stream()
                .map(role -> new RoleResponse(
                        role.getRoleCode(),
                        i18nLookup.text(role.getRoleNameI18nKey(), LocaleContextHolder.getLocale()),
                        role.getRoleNameI18nKey(),
                        role.getSort(),
                        role.getEnabled()))
                .toList();
    }
}

