package com.example.business.goods.controller;

import com.example.business.goods.service.GoodsService;
import com.example.common.model.request.GoodsSaveRequest;
import com.example.common.result.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/goods")
public class GoodsController {
    private final GoodsService goodsService;

    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping
    public Result<?> list(@RequestParam(required = false) String keyword,
                          @RequestParam(required = false) String categoryCode) {
        return Result.success(goodsService.list(keyword, categoryCode));
    }

    @GetMapping("/{id}")
    public Result<?> detail(@PathVariable Long id) {
        return Result.success(goodsService.detail(id));
    }

    @PostMapping
    public Result<?> save(@RequestBody GoodsSaveRequest request) {
        return Result.success(goodsService.save(request));
    }
}
