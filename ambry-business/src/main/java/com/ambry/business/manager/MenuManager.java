package com.ambry.business.manager;

import com.ambry.business.service.MenuService;
import com.ambry.common.model.response.MenuResponse;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MenuManager {
    private final MenuService menuService;
    private final I18nLookup i18nLookup;

    public MenuManager(MenuService menuService, I18nLookup i18nLookup) {
        this.menuService = menuService;
        this.i18nLookup = i18nLookup;
    }

    public List<MenuResponse> list() {
        return menuService.lambdaQuery()
                .eq(com.ambry.common.entity.SysMenuEntity::getDeleted, 0)
                .eq(com.ambry.common.entity.SysMenuEntity::getEnabled, 1)
                .orderByAsc(com.ambry.common.entity.SysMenuEntity::getSort)
                .list()
                .stream()
                .map(menu -> new MenuResponse(
                        menu.getMenuCode(),
                        i18nLookup.text(menu.getMenuNameI18nKey(), LocaleContextHolder.getLocale()),
                        menu.getMenuNameI18nKey(),
                        menu.getParentCode(),
                        menu.getPermissionCode(),
                        menu.getRoutePath(),
                        menu.getComponentPath(),
                        menu.getMenuType(),
                        menu.getSort()))
                .toList();
    }
}

