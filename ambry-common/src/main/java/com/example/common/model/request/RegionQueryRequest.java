package com.example.common.model.request;

import com.example.common.enums.RegionLevel;

public record RegionQueryRequest(String parentCode, RegionLevel level, String keyword) {
}
