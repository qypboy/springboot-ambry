package com.example.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.common.entity.SysRegionEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegionMapper extends BaseMapper<SysRegionEntity> {
}
