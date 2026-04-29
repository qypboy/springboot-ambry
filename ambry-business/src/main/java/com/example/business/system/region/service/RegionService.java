package com.example.business.system.region.service;

import com.example.common.model.request.RegionQueryRequest;
import com.example.common.model.response.RegionResponse;

import java.util.List;

public interface RegionService {
    List<RegionResponse> list(RegionQueryRequest request);

    List<RegionResponse> tree(String parentCode);
}
