package com.example.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.business.mapper.DictTypeMapper;
import com.example.business.service.DictTypeService;
import com.example.common.entity.SysDictTypeEntity;
import org.springframework.stereotype.Service;

@Service
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, SysDictTypeEntity> implements DictTypeService {
}
