package com.example.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.business.mapper.DictItemMapper;
import com.example.business.service.DictItemService;
import com.example.common.entity.SysDictItemEntity;
import org.springframework.stereotype.Service;

@Service
public class DictItemServiceImpl extends ServiceImpl<DictItemMapper, SysDictItemEntity> implements DictItemService {
}
