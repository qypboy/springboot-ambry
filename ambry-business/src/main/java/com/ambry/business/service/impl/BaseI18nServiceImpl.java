package com.ambry.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ambry.business.mapper.BaseI18nMapper;
import com.ambry.business.service.BaseI18nService;
import com.ambry.common.entity.BaseI18nEntity;
import org.springframework.stereotype.Service;

@Service
public class BaseI18nServiceImpl extends ServiceImpl<BaseI18nMapper, BaseI18nEntity> implements BaseI18nService {
}

