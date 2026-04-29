package com.example.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.example.common.context.LoginUser;
import com.example.common.context.UserContext;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AuditMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        LoginUser user = UserContext.get();
        strictInsertFill(metaObject, "deleted", Integer.class, 0);
        strictInsertFill(metaObject, "createBy", String.class, user.username());
        strictInsertFill(metaObject, "createByNo", String.class, user.userNo());
        strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        strictInsertFill(metaObject, "updateBy", String.class, user.username());
        strictInsertFill(metaObject, "updateByNo", String.class, user.userNo());
        strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        LoginUser user = UserContext.get();
        strictUpdateFill(metaObject, "updateBy", String.class, user.username());
        strictUpdateFill(metaObject, "updateByNo", String.class, user.userNo());
        strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }
}
