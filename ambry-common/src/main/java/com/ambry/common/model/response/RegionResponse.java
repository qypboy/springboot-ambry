package com.ambry.common.model.response;

import com.ambry.common.enums.RegionLevelEnum;

import java.util.List;

public record RegionResponse(String code, String parentCode, String name, RegionLevelEnum level, String fullName, List<RegionResponse> children) {
}
