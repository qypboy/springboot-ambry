package com.ambry.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ambry.business.mapper.MenuMapper;
import com.ambry.business.service.MenuService;
import com.ambry.common.entity.SysMenuEntity;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, SysMenuEntity> implements MenuService {
}

