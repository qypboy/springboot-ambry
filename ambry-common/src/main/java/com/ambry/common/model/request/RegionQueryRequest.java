package com.ambry.common.model.request;

import com.ambry.common.enums.RegionLevel;

public record RegionQueryRequest(String parentCode, RegionLevel level, String keyword) {
}
