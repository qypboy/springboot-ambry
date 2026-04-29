package com.ambry.business.controller;

import com.ambry.business.manager.PricingManager;
import com.ambry.common.model.request.PricingRequest;
import com.ambry.common.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "定制计价接口", description = "门窗、橱柜、玻璃、配件定制报价")
@RestController
@RequestMapping("/api/pricing")
public class PricingController {
    private final PricingManager pricingManager;

    public PricingController(PricingManager pricingManager) {
        this.pricingManager = pricingManager;
    }

    @Operation(summary = "定制报价", description = "根据尺寸、材质、玻璃、配件计算报价")
    @PostMapping("/quote")
    public Result<?> quote(@RequestBody PricingRequest request) {
        return Result.success(pricingManager.quote(request));
    }
}
