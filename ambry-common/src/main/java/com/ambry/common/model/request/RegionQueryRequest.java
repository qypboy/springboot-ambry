package com.ambry.common.model.request;

import com.ambry.common.enums.RegionLevelEnum;

public record RegionQueryRequest(String parentCode, RegionLevelEnum level, String keyword) {
}
