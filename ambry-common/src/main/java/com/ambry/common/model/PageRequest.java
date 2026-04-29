package com.ambry.common.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "分页请求")
public record PageRequest(
        @Schema(description = "页码，从1开始", example = "1") Long pageNo,
        @Schema(description = "每页条数", example = "10") Long pageSize
) {
    public long current() {
        return pageNo == null || pageNo < 1 ? 1 : pageNo;
    }

    public long size() {
        return pageSize == null || pageSize < 1 ? 10 : pageSize;
    }
}
