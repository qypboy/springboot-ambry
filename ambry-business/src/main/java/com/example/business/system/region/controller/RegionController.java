package com.example.business.system.region.controller;

import com.example.business.system.region.service.RegionService;
import com.example.common.enums.RegionLevel;
import com.example.common.model.request.RegionQueryRequest;
import com.example.common.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/system/regions")
public class RegionController {
    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping
    public Result<?> list(@RequestParam(required = false) String parentCode,
                          @RequestParam(required = false) RegionLevel level,
                          @RequestParam(required = false) String keyword) {
        return Result.success(regionService.list(new RegionQueryRequest(parentCode, level, keyword)));
    }

    @GetMapping("/tree")
    public Result<?> tree(@RequestParam(defaultValue = "0") String parentCode) {
        return Result.success(regionService.tree(parentCode));
    }
}
