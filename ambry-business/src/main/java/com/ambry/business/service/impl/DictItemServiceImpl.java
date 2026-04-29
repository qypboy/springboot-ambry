package com.ambry.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ambry.business.mapper.DictItemMapper;
import com.ambry.business.service.DictItemService;
import com.ambry.common.entity.SysDictItemEntity;
import org.springframework.stereotype.Service;

@Service
public class DictItemServiceImpl extends ServiceImpl<DictItemMapper, SysDictItemEntity> implements DictItemService {
}
