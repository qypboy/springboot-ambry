package com.example.business.pricing.service.impl;

import com.example.business.pricing.service.PricingService;
import com.example.common.model.request.PricingRequest;
import com.example.common.model.response.PricingResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class PricingServiceImpl implements PricingService {

    @Override
    public PricingResponse quote(PricingRequest request) {
        int quantity = request.quantity() == null ? 1 : request.quantity();
        BigDecimal area = request.width().multiply(request.height()).setScale(2, RoundingMode.HALF_UP);
        BigDecimal base = area.multiply(new BigDecimal("275")).multiply(BigDecimal.valueOf(quantity));
        BigDecimal material = area.multiply(new BigDecimal("180")).multiply(BigDecimal.valueOf(quantity));
        BigDecimal glass = area.multiply(new BigDecimal("160")).multiply(BigDecimal.valueOf(quantity));
        BigDecimal accessory = request.accessories() == null ? BigDecimal.ZERO :
                request.accessories().values().stream().map(BigDecimal::valueOf).reduce(BigDecimal.ZERO, BigDecimal::add).multiply(new BigDecimal("60"));
        BigDecimal total = base.add(material).add(glass).add(accessory).setScale(2, RoundingMode.HALF_UP);
        return new PricingResponse(area, quantity, total, List.of(
                new PricingResponse.PricingLineResponse("基础面积", area + "㎡ x " + quantity, base),
                new PricingResponse.PricingLineResponse("材质", request.materialCode(), material),
                new PricingResponse.PricingLineResponse("玻璃", request.glassCode(), glass),
                new PricingResponse.PricingLineResponse("配件", String.valueOf(request.accessories()), accessory)
        ));
    }
}
