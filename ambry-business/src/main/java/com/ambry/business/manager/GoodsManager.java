package com.ambry.business.manager;

import com.ambry.business.service.GoodsService;
import com.ambry.common.entity.GoodsEntity;
import com.ambry.common.enums.CodeMessageEnum;
import com.ambry.common.exception.CommonException;
import com.ambry.common.model.PageRequest;
import com.ambry.common.model.PageResponse;
import com.ambry.common.model.request.GoodsSaveRequest;
import com.ambry.common.model.response.GoodsResponse;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
        GoodsEntity entity = goodsService.getById(id);
        if (entity == null) {
            throw new CommonException(CodeMessageEnum.GOODS_NOT_FOUND);
        }
        return toResponse(entity);
    }

    private GoodsResponse toResponse(GoodsEntity entity) {
        return new GoodsResponse(entity.getId(), entity.getName(), entity.getCategoryCode(), entity.getMaterialCode(), entity.getPrice(), entity.getStock(), entity.getDescription(), entity.getImageUrl());
    }
}
