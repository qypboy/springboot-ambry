package com.ambry.common.util;

import com.ambry.common.enums.CodeMessageEnum;
import com.ambry.common.exception.CommonException;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Optional;

/**
 * 自定义断言
 *
 * @author jie.lv
 */
@Slf4j
public class Assert {

    private Assert() {
    }

    private static boolean isNotEmpty(Object target) {
        if (target == null) {
            return false;
        }
        if (target instanceof CharSequence seq) {
            return seq.toString().trim().length() > 0;
        }
        if (target instanceof Collection<?> c) {
            return !c.isEmpty();
        }
        if (target instanceof java.util.Map<?, ?> m) {
            return !m.isEmpty();
        }
        if (target.getClass().isArray()) {
            return java.lang.reflect.Array.getLength(target) > 0;
        }
        if (target instanceof Optional<?> opt) {
            return opt.isPresent();
        }
        return true;
    }


    /**
     * 断言不为空，为空则抛出异常
     *
     * @param target  目标对象
     * @param message 错误描述信息
     */
    public static void notEmpty(Object target, String message) {
        notEmpty(target, CodeMessageEnum.COMMON_10000001.getCode(), message);
    }

    public static void notEmpty(Object target, CodeMessageEnum message) {
        isTrue(isNotEmpty(target), message);
    }


    /**
     * 断言不为空，为空则抛出异常
     *
     * @param target  目标对象
     * @param code    错误状态码
     * @param message 错误描述信息
     */
    public static void notEmpty(Object target, String code, String message) {
        isTrue(isNotEmpty(target), code, message);
    }

    /* *****************************************************************Assert String Not Blank********************************************************************** */

    /**
     * 断言字符串不为空
     *
     * @param target  检测目标
     * @param code    错误码
     * @param message 错误描述
     */
    public static void notBlank(String target, String code, String message) {
        isTrue(target != null && !target.trim().isEmpty(), code, message);
    }

    /**
     * 断言字符串不能为空
     *
     * @param target  检测对象
     * @param message 错误描述
     */
    @SuppressWarnings("unused")
    public static void notBlank(String target, String message) {
        notBlank(target, CodeMessageEnum.COMMON_10000001.getCode(), message);
    }

    /* ****************************************************************Assert Boolean Is True********************************************************************** */

    /**
     * 断言为true  如果为false 抛出自定义异常
     *
     * @param flag        条件
     * @param codeMessage 错误信息
     */
    @SuppressWarnings("unused")
    public static void isTrue(boolean flag, CodeMessageEnum codeMessage) {
        isFalse(!flag, codeMessage);
    }


    /**
     * 断言为true  如果为false 抛出自定义异常
     *
     * @param flag    条件
     * @param message 错误描述
     */
    public static void isTrue(boolean flag, String message) {
        isTrue(flag, CodeMessageEnum.COMMON_10000001.getCode(), message);
    }

    /**
     * 断言为true  如果为false 抛出自定义异常
     *
     * @param flag    条件
     * @param message 错误描述
     */
    public static void isTrue(boolean flag, String code, String message) {
        isFalse(!flag, code, message);
    }

    /* ****************************************************************Assert Boolean Is False********************************************************************** */

    /**
     * 断言为false  如果为true 抛出自定义异常
     *
     * @param flag    条件
     * @param message 错误描述
     */
    @SuppressWarnings("unused")
    public static void isFalse(boolean flag, String message) {
        isFalse(flag, CodeMessageEnum.COMMON_10000001.getCode(), message);
    }

    /**
     * 断言为false  如果为true 抛出自定义异常
     *
     * @param flag    条件
     * @param message 错误描述
     */
    public static void isFalse(boolean flag, String code, String message) {
        if (flag) {
            // CommonException(String message, String code) 参数顺序：message 在前，code 在后
            throw new CommonException(message, code);
        }
    }

    /**
     * 断言为false  如果为true 抛出自定义异常
     *
     * @param flag        条件
     * @param codeMessage 错误信息
     */
    @SuppressWarnings("unused")
    public static void isFalse(boolean flag, CodeMessageEnum codeMessage) {
        if (flag) {
            throw new CommonException(codeMessage);
        }
    }

    /**
     * 端检对象是否不为空
     *
     * @param obj         检查对象
     * @param codeMessage 错误信息
     * @param params      错误参数
     */
    public static void notNull(Object obj, CodeMessageEnum codeMessage, Object... params) {
        boolean res = obj != null;
        if (res && obj instanceof Optional<?>) {
            res = ((Optional<?>) obj).isPresent();
        }
        judge(res, codeMessage, params);
    }

    /**
     * 端检字符串是否为空
     *
     * @param str         检查字符串
     * @param codeMessage 错误信息
     * @param params      错误参数
     */
    public static void isBlank(String str, CodeMessageEnum codeMessage, Object... params) {
        judge(str == null || str.trim().isEmpty(), codeMessage, params);
    }

    /**
     * 端检字符串是否不为空
     *
     * @param str         检查字符串
     * @param codeMessage 错误信息
     * @param params      错误参数
     */
    public static void notBlank(String str, CodeMessageEnum codeMessage, Object... params) {
        judge(str != null && !str.trim().isEmpty(), codeMessage, params);
    }

    /**
     * 端检集合是否为空
     *
     * @param collection  检查集合
     * @param codeMessage 错误信息
     * @param params      错误参数
     * @param <T>         集合元素类型
     */
    public static <T> void isCollectionEmpty(Collection<T> collection, CodeMessageEnum codeMessage, Object... params) {
        judge(collection == null || collection.isEmpty(), codeMessage, params);
    }

    /**
     * 端检集合是否不为空
     *
     * @param collection  检查集合
     * @param codeMessage 错误信息
     * @param params      错误参数
     * @param <T>         集合元素类型
     */
    public static <T> void notCollectionEmpty(Collection<T> collection, CodeMessageEnum codeMessage, Object... params) {
        judge(collection != null && !collection.isEmpty(), codeMessage, params);
    }


    /**
     * 抛出自定义异常
     *
     * @param codeMessage 错误信息
     * @param params      错误参数
     */
    public static void throwEx(CodeMessageEnum codeMessage, Object... params) {
        throw new CommonException(codeMessage, params);
    }

    /**
     * 判断结果是否为true,不为true则抛出自定义异常
     *
     * @param judgeResult 判断结果
     * @param message     异常信息
     */
    public static void judge(boolean judgeResult, String message) {
        if (!judgeResult) {
            throw new CommonException(message);
        }
    }

    /**
     * 判断结果是否为true,不为true则抛出自定义异常
     *
     * @param judgeResult 判断结果
     * @param codeMessage 异常信息
     * @param params      异常参数
     */
    public static void judge(boolean judgeResult, CodeMessageEnum codeMessage, Object... params) {
        if (!judgeResult) {
            throw new CommonException(codeMessage, params);
        }
    }

}
