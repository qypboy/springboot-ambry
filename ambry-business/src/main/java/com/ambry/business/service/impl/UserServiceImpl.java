package com.ambry.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ambry.business.mapper.UserMapper;
import com.ambry.business.service.UserService;
import com.ambry.common.entity.SysUserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, SysUserEntity> implements UserService {
}
