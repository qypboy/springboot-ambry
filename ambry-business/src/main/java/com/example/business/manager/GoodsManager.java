package com.example.business.manager;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.business.service.GoodsService;
import com.example.common.entity.GoodsEntity;
import com.example.common.model.PageRequest;
import com.example.common.model.PageResponse;
import com.example.common.model.request.GoodsSaveRequest;
import com.example.common.model.response.GoodsResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class GoodsManager {
    private final GoodsService goodsService;

    public GoodsManager(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    public PageResponse<GoodsResponse> page(PageRequest pageRequest, String keyword, String categoryCode) {
        Page<GoodsEntity> page = goodsService.lambdaQuery()
                .like(StringUtils.hasText(keyword), GoodsEntity::getName, keyword)
                .eq(StringUtils.hasText(categoryCode), GoodsEntity::getCategoryCode, categoryCode)
                .eq(GoodsEntity::getDeleted, 0)
                .page(new Page<>(pageRequest.current(), pageRequest.size()));
        return new PageResponse<>(page.getRecords().stream().map(this::toResponse).toList(), page.getTotal(), page.getCurrent(), page.getSize());
    }

    public GoodsResponse save(GoodsSaveRequest request) {
        GoodsEntity entity = new GoodsEntity();
        entity.setName(request.name());
        entity.setCategoryCode(request.categoryCode());
        entity.setMaterialCode(request.materialCode());
        entity.setPrice(request.price());
        entity.setStock(request.stock());
        entity.setDescription(request.description());
        entity.setImageUrl(request.imageUrl());
        entity.setEnabled(1);
        goodsService.save(entity);
        return toResponse(entity);
    }

    public GoodsResponse detail(Long id) {
        return toResponse(goodsService.getById(id));
    }

    private GoodsResponse toResponse(GoodsEntity entity) {
        return new GoodsResponse(entity.getId(), entity.getName(), entity.getCategoryCode(), entity.getMaterialCode(), entity.getPrice(), entity.getStock(), entity.getDescription(), entity.getImageUrl());
    }
}
