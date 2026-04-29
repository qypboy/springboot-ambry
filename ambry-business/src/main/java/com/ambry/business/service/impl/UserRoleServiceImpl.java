package com.ambry.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ambry.business.mapper.UserRoleMapper;
import com.ambry.business.service.UserRoleService;
import com.ambry.common.entity.SysUserRoleEntity;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, SysUserRoleEntity> implements UserRoleService {
}

