package com.ambry.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ambry.business.mapper.OrderMapper;
import com.ambry.business.service.OrderService;
import com.ambry.common.entity.MallOrderEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, MallOrderEntity> implements OrderService {
}
