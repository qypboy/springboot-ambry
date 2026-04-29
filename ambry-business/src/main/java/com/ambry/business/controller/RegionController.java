package com.ambry.business.controller;

import com.ambry.business.manager.RegionManager;
import com.ambry.common.enums.RegionLevel;
import com.ambry.common.model.request.RegionQueryRequest;
import com.ambry.common.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "区域接口", description = "中国省市区镇村区域查询")
@RestController
@RequestMapping("/api/system/regions")
public class RegionController {
    private final RegionManager regionManager;

    public RegionController(RegionManager regionManager) {
        this.regionManager = regionManager;
    }

    @Operation(summary = "区域列表", description = "按父级、层级、关键字查询区域")
    @GetMapping
    public Result<?> list(@RequestParam(required = false) String parentCode,
                          @RequestParam(required = false) RegionLevel level,
                          @RequestParam(required = false) String keyword) {
        return Result.success(regionManager.list(new RegionQueryRequest(parentCode, level, keyword)));
    }

    @Operation(summary = "区域树", description = "查询省市区镇村树形结构")
    @GetMapping("/tree")
    public Result<?> tree(@RequestParam(defaultValue = "0") String parentCode) {
        return Result.success(regionManager.tree(parentCode));
    }
}
