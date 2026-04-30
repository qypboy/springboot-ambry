package com.ambry.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;


public enum I18nModuleEnum implements EnumInterface<Integer> {

    USER(1),
    ;

    @EnumValue
    final int code;

    I18nModuleEnum(int code) {
        this.code = code;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static I18nModuleEnum match(Object code) {
        return EnumUtil.match(I18nModuleEnum.class, code);
    }

    @Override
    public Integer getCode() {
        return this.code;
    }
}