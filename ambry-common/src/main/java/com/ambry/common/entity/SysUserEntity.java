package com.ambry.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ambry.common.enums.UserRole;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user")
@Schema(description = "系统用户实体")
public class SysUserEntity extends BaseEntity {
    @TableId(type = IdType.AUTO)
    @Schema(description = "用户主键ID")
    private Long id;
    @Schema(description = "账号")
    private String username;
    @Schema(description = "密码")
    private String password;
    @Schema(description = "手机号")
    private String phone;
    @Schema(description = "地址")
    private String address;
    @Schema(description = "角色编码")
    private UserRole role;
    @Schema(description = "是否启用")
    private Integer enabled;
}
