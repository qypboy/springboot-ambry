package com.example.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.business.mapper.OrderItemMapper;
import com.example.business.service.OrderItemService;
import com.example.common.entity.MallOrderItemEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, MallOrderItemEntity> implements OrderItemService {
}
