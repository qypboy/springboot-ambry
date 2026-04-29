package com.ambry.business.controller;

import com.ambry.business.manager.DictManager;
import com.ambry.common.enums.UserRoleEnum;
import com.ambry.common.model.request.DictSaveRequest;
import com.ambry.common.result.Result;
import com.ambry.common.security.RequireRole;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "字典接口", description = "系统字典维护")
@RestController
@RequestMapping("/api/system/dicts")
public class DictController {
    private final DictManager dictManager;

    public DictController(DictManager dictManager) {
        this.dictManager = dictManager;
    }

    @Operation(summary = "字典项列表", description = "按字典编码查询字典项")
    @GetMapping("/{dictCode}/items")
    public Result<?> items(@PathVariable String dictCode) {
        return Result.success(dictManager.listItems(dictCode));
    }

    @RequireRole({UserRoleEnum.ADMIN, UserRoleEnum.STAFF})
    @Operation(summary = "保存字典项", description = "新增字典项")
    @PostMapping("/items")
    public Result<?> saveItem(@RequestBody DictSaveRequest request) {
        return Result.success(dictManager.saveItem(request));
    }
}
