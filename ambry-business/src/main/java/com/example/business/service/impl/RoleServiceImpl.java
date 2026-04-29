package com.example.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.business.mapper.RoleMapper;
import com.example.business.service.RoleService;
import com.example.common.entity.SysRoleEntity;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, SysRoleEntity> implements RoleService {
}
