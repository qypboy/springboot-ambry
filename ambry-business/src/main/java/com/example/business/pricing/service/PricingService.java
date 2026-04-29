package com.example.business.pricing.service;

import com.example.common.model.request.PricingRequest;
import com.example.common.model.response.PricingResponse;

public interface PricingService {
    PricingResponse quote(PricingRequest request);
}
