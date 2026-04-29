package com.example.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.business.mapper.OrderMapper;
import com.example.business.service.OrderService;
import com.example.common.entity.MallOrderEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, MallOrderEntity> implements OrderService {
}
