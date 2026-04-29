package com.example.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.business.mapper.UserMapper;
import com.example.business.service.UserService;
import com.example.common.entity.SysUserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, SysUserEntity> implements UserService {
}
