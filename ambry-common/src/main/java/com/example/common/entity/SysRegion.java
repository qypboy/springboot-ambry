package com.example.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.common.enums.RegionLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_region")
public class SysRegion extends BaseEntity {
    private String code;
    private String parentCode;
    private String name;
    private RegionLevel level;
    private String fullName;
    private String path;
    private Integer sort;
    private Integer enabled;
    private String source;
    private String version;
}
