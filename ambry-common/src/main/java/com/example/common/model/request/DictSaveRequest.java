package com.example.common.model.request;

public record DictSaveRequest(String dictCode, String itemValue, String itemLabel, Integer sort, String remark) {
}
