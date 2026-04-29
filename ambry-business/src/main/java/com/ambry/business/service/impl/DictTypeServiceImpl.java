package com.ambry.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ambry.business.mapper.DictTypeMapper;
import com.ambry.business.service.DictTypeService;
import com.ambry.common.entity.SysDictTypeEntity;
import org.springframework.stereotype.Service;

@Service
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, SysDictTypeEntity> implements DictTypeService {
}
