package com.example.business.system.dict.service;

import com.example.common.model.request.DictSaveRequest;
import com.example.common.model.response.DictItemResponse;

import java.util.List;

public interface DictService {
    List<DictItemResponse> listItems(String dictCode);

    DictItemResponse saveItem(DictSaveRequest request);
}
