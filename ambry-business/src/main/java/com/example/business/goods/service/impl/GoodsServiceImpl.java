package com.example.business.goods.service.impl;

import com.example.business.goods.service.GoodsService;
import com.example.common.exception.BusinessException;
import com.example.common.model.request.GoodsSaveRequest;
import com.example.common.model.response.GoodsResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GoodsServiceImpl implements GoodsService {
    private final AtomicLong id = new AtomicLong(100);
    private final List<GoodsResponse> goods = new ArrayList<>();

    public GoodsServiceImpl() {
        goods.add(new GoodsResponse(1L, "断桥铝窗", "WINDOW", "BROKEN_BRIDGE_ALUMINUM", new BigDecimal("1280.00"), 100, "隔热隔音门窗，可按尺寸定制", ""));
        goods.add(new GoodsResponse(2L, "整体橱柜", "CABINET", "SOLID_WOOD", new BigDecimal("1880.00"), 30, "厨房橱柜定制，支持台面与五金配置", ""));
    }

    @Override
    public List<GoodsResponse> list(String keyword, String categoryCode) {
        return goods.stream()
                .filter(item -> keyword == null || item.name().contains(keyword))
                .filter(item -> categoryCode == null || categoryCode.isBlank() || item.categoryCode().equals(categoryCode))
                .toList();
    }

    @Override
    public GoodsResponse save(GoodsSaveRequest request) {
        GoodsResponse response = new GoodsResponse(id.incrementAndGet(), request.name(), request.categoryCode(), request.materialCode(), request.price(), request.stock(), request.description(), request.imageUrl());
        goods.add(response);
        return response;
    }

    @Override
    public GoodsResponse detail(Long id) {
        return goods.stream().filter(item -> item.id().equals(id)).findFirst().orElseThrow(() -> new BusinessException("商品不存在"));
    }
}
