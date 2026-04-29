package com.example.common.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "分页返回")
public record PageResponse<T>(
        @Schema(description = "数据列表") List<T> records,
        @Schema(description = "总条数") Long total,
        @Schema(description = "页码") Long pageNo,
        @Schema(description = "每页条数") Long pageSize
) {
}
