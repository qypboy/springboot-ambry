package com.example.business.system.region.service.impl;

import com.example.business.system.region.service.RegionService;
import com.example.common.enums.RegionLevel;
import com.example.common.model.request.RegionQueryRequest;
import com.example.common.model.response.RegionResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    @Override
    public List<RegionResponse> list(RegionQueryRequest request) {
        String parentCode = request == null ? null : request.parentCode();
        if ("440106001".equals(parentCode)) {
            return List.of(new RegionResponse("440106001001", "440106001", "石牌村", RegionLevel.VILLAGE, "广东省广州市天河区石牌街道石牌村", List.of()));
        }
        return List.of(
                new RegionResponse("440000", "0", "广东省", RegionLevel.PROVINCE, "广东省", List.of()),
                new RegionResponse("440100", "440000", "广州市", RegionLevel.CITY, "广东省广州市", List.of()),
                new RegionResponse("440106", "440100", "天河区", RegionLevel.DISTRICT, "广东省广州市天河区", List.of()),
                new RegionResponse("440106001", "440106", "石牌街道", RegionLevel.TOWN, "广东省广州市天河区石牌街道", List.of())
        );
    }

    @Override
    public List<RegionResponse> tree(String parentCode) {
        RegionResponse village = new RegionResponse("440106001001", "440106001", "石牌村", RegionLevel.VILLAGE, "广东省广州市天河区石牌街道石牌村", List.of());
        RegionResponse town = new RegionResponse("440106001", "440106", "石牌街道", RegionLevel.TOWN, "广东省广州市天河区石牌街道", List.of(village));
        RegionResponse district = new RegionResponse("440106", "440100", "天河区", RegionLevel.DISTRICT, "广东省广州市天河区", List.of(town));
        RegionResponse city = new RegionResponse("440100", "440000", "广州市", RegionLevel.CITY, "广东省广州市", List.of(district));
        return List.of(new RegionResponse("440000", "0", "广东省", RegionLevel.PROVINCE, "广东省", List.of(city)));
    }
}
