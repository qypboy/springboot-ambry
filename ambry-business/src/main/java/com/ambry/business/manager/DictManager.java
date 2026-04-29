package com.ambry.business.manager;

import com.ambry.business.service.DictItemService;
import com.ambry.common.entity.SysDictItemEntity;
import com.ambry.common.model.request.DictSaveRequest;
import com.ambry.common.model.response.DictItemResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DictManager {
    private final DictItemService dictItemService;

    public DictManager(DictItemService dictItemService) {
        this.dictItemService = dictItemService;
    }

    public List<DictItemResponse> listItems(String dictCode) {
        return dictItemService.lambdaQuery()
                .eq(SysDictItemEntity::getDictCode, dictCode)
                .eq(SysDictItemEntity::getDeleted, 0)
                .orderByAsc(SysDictItemEntity::getSort)
                .list()
                .stream()
                .map(item -> new DictItemResponse(item.getDictCode(), item.getItemValue(), item.getItemLabel(), item.getSort()))
                .toList();
    }

    public DictItemResponse saveItem(DictSaveRequest request) {
        SysDictItemEntity entity = new SysDictItemEntity();
        entity.setDictCode(request.dictCode());
        entity.setItemValue(request.itemValue());
        entity.setItemLabel(request.itemLabel());
        entity.setSort(request.sort());
        entity.setStatus(1);
        entity.setRemark(request.remark());
        dictItemService.save(entity);
        return new DictItemResponse(entity.getDictCode(), entity.getItemValue(), entity.getItemLabel(), entity.getSort());
    }
}
