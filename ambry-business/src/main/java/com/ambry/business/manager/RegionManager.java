package com.ambry.business.manager;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ambry.business.service.RegionService;
import com.ambry.common.entity.SysRegionEntity;
import com.ambry.common.model.request.RegionQueryRequest;
import com.ambry.common.model.response.RegionResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

@Component
public class RegionManager {
    private final RegionService regionService;

    public RegionManager(RegionService regionService) {
        this.regionService = regionService;
    }

    public List<RegionResponse> list(RegionQueryRequest request) {
        LambdaQueryWrapper<SysRegionEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StringUtils.hasText(request.parentCode()), SysRegionEntity::getParentCode, request.parentCode())
                .eq(request.level() != null, SysRegionEntity::getLevel, request.level())
                .like(StringUtils.hasText(request.keyword()), SysRegionEntity::getName, request.keyword())
                .eq(SysRegionEntity::getDeleted, 0)
                .orderByAsc(SysRegionEntity::getSort);
        return regionService.list(wrapper).stream().map(this::toResponse).toList();
    }

    public List<RegionResponse> tree(String parentCode) {
        List<SysRegionEntity> regions = regionService.lambdaQuery().eq(SysRegionEntity::getDeleted, 0).list();
        return buildTree(regions, parentCode == null ? "0" : parentCode);
    }

    private List<RegionResponse> buildTree(List<SysRegionEntity> regions, String parentCode) {
        return regions.stream()
                .filter(item -> parentCode.equals(item.getParentCode()))
                .map(item -> new RegionResponse(item.getCode(), item.getParentCode(), item.getName(), item.getLevel(), item.getFullName(), buildTree(regions, item.getCode())))
                .toList();
    }

    private RegionResponse toResponse(SysRegionEntity entity) {
        return new RegionResponse(entity.getCode(), entity.getParentCode(), entity.getName(), entity.getLevel(), entity.getFullName(), List.of());
    }
}
