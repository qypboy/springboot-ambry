package com.ambry.common.model.response;

public record DictItemResponse(String dictCode, String itemValue, String itemLabel, Integer sort) {
}
