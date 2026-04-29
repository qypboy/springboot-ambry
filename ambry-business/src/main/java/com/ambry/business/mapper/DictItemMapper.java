package com.ambry.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ambry.common.entity.SysDictItemEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DictItemMapper extends BaseMapper<SysDictItemEntity> {
}
