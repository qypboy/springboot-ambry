package com.example.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.common.enums.UserRole;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mall_user")
public class MallUser extends BaseEntity {
    private String username;
    private String password;
    private String phone;
    private String address;
    private UserRole role;
    private Integer enabled;
}
