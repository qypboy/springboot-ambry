package com.ambry.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.ambry.common.enums.RegionLevel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_region")
@Schema(description = "中国区域实体，支持省市区镇村")
public class SysRegionEntity extends BaseEntity {
    @TableId(type = IdType.AUTO)
    @Schema(description = "区域主键ID")
    private Long id;
    @Schema(description = "行政区划代码")
    private String code;
    @Schema(description = "父级代码")
    private String parentCode;
    @Schema(description = "区域名称")
    private String name;
    @Schema(description = "区域级别")
    private RegionLevel level;
    @Schema(description = "完整名称")
    private String fullName;
    @Schema(description = "路径")
    private String path;
    @Schema(description = "排序")
    private Integer sort;
    @Schema(description = "是否启用")
    private Integer enabled;
    @Schema(description = "数据来源")
    private String source;
    @Schema(description = "数据版本")
    private String version;
}
