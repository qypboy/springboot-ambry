package com.example.business.goods.service;

import com.example.common.model.request.GoodsSaveRequest;
import com.example.common.model.response.GoodsResponse;

import java.util.List;

public interface GoodsService {
    List<GoodsResponse> list(String keyword, String categoryCode);

    GoodsResponse save(GoodsSaveRequest request);

    GoodsResponse detail(Long id);
}
