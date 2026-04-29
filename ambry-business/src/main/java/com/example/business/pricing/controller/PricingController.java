package com.example.business.pricing.controller;

import com.example.business.pricing.service.PricingService;
import com.example.common.model.request.PricingRequest;
import com.example.common.result.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pricing")
public class PricingController {
    private final PricingService pricingService;

    public PricingController(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    @PostMapping("/quote")
    public Result<?> quote(@RequestBody PricingRequest request) {
        return Result.success(pricingService.quote(request));
    }
}
