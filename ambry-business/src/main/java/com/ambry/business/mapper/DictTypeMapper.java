package com.ambry.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ambry.common.entity.SysDictTypeEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DictTypeMapper extends BaseMapper<SysDictTypeEntity> {
}
