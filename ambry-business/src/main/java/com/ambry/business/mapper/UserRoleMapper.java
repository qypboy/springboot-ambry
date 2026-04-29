package com.ambry.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ambry.common.entity.SysUserRoleEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleMapper extends BaseMapper<SysUserRoleEntity> {
}

