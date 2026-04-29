package com.ambry.common.exception;

import com.ambry.common.enums.CodeMessageEnum;

public class CommonException extends RuntimeException {
    private String code;

    public CommonException() {
        super();
    }

    public CommonException(String message) {
        super(message);
        this.code = "500";
    }

    public CommonException(String message, String code) {
        super(message);
        this.code = code;
    }

    public CommonException(CodeMessageEnum enumParam) {
        super(enumParam.getMessage());
        this.code = enumParam.getCode();
    }

    public CommonException(CodeMessageEnum enumParam, Object... params) {
        super(enumParam.getMessage(params));
        this.code = enumParam.getCode();
    }


    public CommonException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
