package com.ambry.business.controller;

import com.ambry.business.manager.MenuManager;
import com.ambry.common.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "菜单接口", description = "菜单配置查询")
@RestController
@RequestMapping("/api/system/menus")
public class MenuController {
    private final MenuManager menuManager;

    public MenuController(MenuManager menuManager) {
        this.menuManager = menuManager;
    }

    @Operation(summary = "菜单列表", description = "返回菜单配置并按locale翻译名称")
    @GetMapping
    public Result<?> list() {
        return Result.success(menuManager.list());
    }
}

