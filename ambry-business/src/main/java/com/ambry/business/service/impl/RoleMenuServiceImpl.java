package com.ambry.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ambry.business.mapper.RoleMenuMapper;
import com.ambry.business.service.RoleMenuService;
import com.ambry.common.entity.SysRoleMenuEntity;
import org.springframework.stereotype.Service;

@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, SysRoleMenuEntity> implements RoleMenuService {
}

