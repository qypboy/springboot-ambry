package com.ambry.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ambry.business.mapper.RoleMapper;
import com.ambry.business.service.RoleService;
import com.ambry.common.entity.SysRoleEntity;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, SysRoleEntity> implements RoleService {
}
