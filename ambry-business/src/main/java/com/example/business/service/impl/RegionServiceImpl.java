package com.example.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.business.mapper.RegionMapper;
import com.example.business.service.RegionService;
import com.example.common.entity.SysRegionEntity;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl extends ServiceImpl<RegionMapper, SysRegionEntity> implements RegionService {
}
