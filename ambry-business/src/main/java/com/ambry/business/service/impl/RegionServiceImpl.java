package com.ambry.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ambry.business.mapper.RegionMapper;
import com.ambry.business.service.RegionService;
import com.ambry.common.entity.SysRegionEntity;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl extends ServiceImpl<RegionMapper, SysRegionEntity> implements RegionService {
}
