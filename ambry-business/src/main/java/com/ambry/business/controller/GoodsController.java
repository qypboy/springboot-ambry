package com.ambry.business.controller;

import com.ambry.business.manager.GoodsManager;
import com.ambry.common.enums.UserRole;
import com.ambry.common.model.PageRequest;
import com.ambry.common.model.request.GoodsSaveRequest;
import com.ambry.common.result.Result;
import com.ambry.common.security.RequireRole;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "商品接口", description = "商品查询和后台商品维护")
@RestController
@RequestMapping("/api/goods")
public class GoodsController {
    private final GoodsManager goodsManager;

    public GoodsController(GoodsManager goodsManager) {
        this.goodsManager = goodsManager;
    }

    @Operation(summary = "分页查询商品", description = "支持关键字和分类筛选")
    @GetMapping
    public Result<?> page(@RequestParam(required = false) Long pageNo,
                          @RequestParam(required = false) Long pageSize,
                          @RequestParam(required = false) String keyword,
                          @RequestParam(required = false) String categoryCode) {
        return Result.success(goodsManager.page(new PageRequest(pageNo, pageSize), keyword, categoryCode));
    }

    @Operation(summary = "商品详情", description = "按ID查询商品")
    @GetMapping("/{id}")
    public Result<?> detail(@PathVariable Long id) {
        return Result.success(goodsManager.detail(id));
    }

    @RequireRole({UserRole.ADMIN, UserRole.STAFF})
    @Operation(summary = "保存商品", description = "新增商品")
    @PostMapping
    public Result<?> save(@RequestBody GoodsSaveRequest request) {
        return Result.success(goodsManager.save(request));
    }
}
