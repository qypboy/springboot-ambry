package com.ambry.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ambry.common.entity.MallOrderItemEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderItemMapper extends BaseMapper<MallOrderItemEntity> {
}
