package com.ambry.business.controller;

import com.ambry.business.manager.RoleManager;
import com.ambry.common.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "角色接口", description = "角色配置查询")
@RestController
@RequestMapping("/api/system/roles")
public class RoleController {
    private final RoleManager roleManager;

    public RoleController(RoleManager roleManager) {
        this.roleManager = roleManager;
    }

    @Operation(summary = "角色列表", description = "返回角色配置并按locale翻译名称")
    @GetMapping
    public Result<?> list() {
        return Result.success(roleManager.list());
    }
}

