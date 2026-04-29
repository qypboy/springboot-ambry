package com.ambry.common.model.response;

import com.ambry.common.enums.RegionLevel;

import java.util.List;

public record RegionResponse(String code, String parentCode, String name, RegionLevel level, String fullName, List<RegionResponse> children) {
}
