package com.example.business.system.dict.service.impl;

import com.example.business.system.dict.service.DictService;
import com.example.common.model.request.DictSaveRequest;
import com.example.common.model.response.DictItemResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class DictServiceImpl implements DictService {
    private final Map<String, List<DictItemResponse>> items = new ConcurrentHashMap<>();

    public DictServiceImpl() {
        items.put("order_status", new ArrayList<>(List.of(
                new DictItemResponse("order_status", "WAIT_CONFIRM", "待确认", 1),
                new DictItemResponse("order_status", "PRODUCING", "生产中", 2),
                new DictItemResponse("order_status", "COMPLETED", "已完成", 3)
        )));
        items.put("goods_type", new ArrayList<>(List.of(
                new DictItemResponse("goods_type", "WINDOW", "门窗", 1),
                new DictItemResponse("goods_type", "CABINET", "橱柜", 2),
                new DictItemResponse("goods_type", "GLASS", "玻璃", 3),
                new DictItemResponse("goods_type", "ACCESSORY", "配件", 4)
        )));
    }

    @Override
    public List<DictItemResponse> listItems(String dictCode) {
        return items.getOrDefault(dictCode, List.of());
    }

    @Override
    public DictItemResponse saveItem(DictSaveRequest request) {
        DictItemResponse response = new DictItemResponse(request.dictCode(), request.itemValue(), request.itemLabel(), request.sort());
        items.computeIfAbsent(request.dictCode(), ignored -> new ArrayList<>()).add(response);
        return response;
    }
}
