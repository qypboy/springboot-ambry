package com.ambry.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ambry.business.mapper.OrderItemMapper;
import com.ambry.business.service.OrderItemService;
import com.ambry.common.entity.MallOrderItemEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, MallOrderItemEntity> implements OrderItemService {
}
