package com.ambry.common.constant;

public final class MessageKeys {
    private MessageKeys() {
    }

    public static final String AUTH_INVALID_CREDENTIAL = "error.auth.invalid-credential";
    public static final String AUTH_INVALID_TOKEN = "error.auth.invalid-token";
    public static final String AUTH_EXPIRED_TOKEN = "error.auth.expired-token";
    public static final String AUTH_FORBIDDEN = "error.auth.forbidden";
    public static final String VALIDATION_FAILED = "error.validation.failed";
    public static final String SYSTEM_ERROR = "error.system";
    public static final String GOODS_NOT_FOUND = "error.goods.not-found";
}
