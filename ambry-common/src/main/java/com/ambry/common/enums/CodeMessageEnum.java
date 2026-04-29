package com.ambry.common.enums;


import com.ambry.common.util.MessageUtils;

/**
 * @author zhanwen.qiu
 * @date 2026/04/21 17:48
 * [错误来源---一位数] [项目---两位数] [模块---两位数][错误码---两位数]
 * 错误来源  0-保留  1-用户输入  2-系统内部  3-外部系统
 * 项目 00 保留  01-99 可用（目前dpmp为01，base为02）
 * 模块 00-保留 01-99 可用（项目下的模块，自己定义）
 * 错误码 00-保留 01-99可用（真正的错误码，自己定义）
 * 为兼容其他系统状态码  200为成功  500为未知错误
 * 为0保留的不要使用
 */
public enum CodeMessageEnum {

    SUCCESS("200", "操作成功"),
    FAIL("500", "失败"),

    COMMON_10000001("10000001", "参数错误"),
    COMMON_10000002("10000002", "系统内部错误"),
    COMMON_10000003("10000003", "外部系统响应错误"),

    I18N_NOT_NULL("1020501", "多语言不能为空"),
    I18N_ERROR("1020502", "获取国际化信息失败"),

    AUTH_INVALID_CREDENTIAL("11000001", "用户名或密码错误"),
    AUTH_INVALID_TOKEN("11000002", "登录令牌无效"),
    AUTH_EXPIRED_TOKEN("11000003", "登录令牌已过期"),
    AUTH_FORBIDDEN("11000004", "无权限访问"),

    GOODS_NOT_FOUND("12000001", "商品不存在"),
    ;

    private final String code;
    private final String message;

    CodeMessageEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return MessageUtils.message(code);
    }

    /**
     * 注意此方法与getMessage()的区别，当不传参数时，程序会运行getMessage()方法，而不是此方法
     *
     * @param params 需替换固定文本中占位符的字符串
     * @return 所需要的配置错误提示信息
     */
    public String getMessage(Object... params) {
        return MessageUtils.message(code, params);
    }
}
