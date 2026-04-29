package com.ambry.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;
import java.util.ResourceBundle;
import java.text.MessageFormat;

/**
 * @author zhanwen.qiu
 * @Desc
 * @version: 1.0
 * @date 2024/01/03 15:06
 */
@Slf4j
public class MessageUtils {

    public static String message(String code, Object... args) {
        Locale locale = LocaleContextHolder.getLocale();
        return message(code, locale, args);
    }

    /**
     * 解析指定 locale 的消息。
     * <p>
     * 当翻译 key 不存在时，回退返回 {@code code} 本身。
     */
    public static String message(String code, Locale locale, Object... args) {
        try {
            MessageSource messageSource = SpringUtils.getBean("messageSource");
            if (locale == null) {
                locale = Locale.SIMPLIFIED_CHINESE;
            }
            Locale resolvedLocale = Locale.SIMPLIFIED_CHINESE.equals(locale) ? Locale.SIMPLIFIED_CHINESE : Locale.US;
            log.debug("message code: {}, args: {}, locale: {}", code, args, resolvedLocale);
            return messageSource.getMessage(code, args, resolvedLocale);
        } catch (NoSuchMessageException e) {
            return code;
        } catch (IllegalStateException e) {
            // 非 Spring 场景：fallback 到 ResourceBundle
            return resourceBundleMessage(code, locale, args);
        } catch (Exception e) {
            log.error("MessageUtils.message error", e);
            return resourceBundleMessage(code, locale, args);
        }
    }

    private static String resourceBundleMessage(String code, Locale locale, Object... args) {
        Locale resolvedLocale = (locale == null || Locale.SIMPLIFIED_CHINESE.equals(locale)) ? Locale.SIMPLIFIED_CHINESE : Locale.US;
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("i18n/messages", resolvedLocale);
            String pattern = bundle.getString(code);
            return MessageFormat.format(pattern, args);
        } catch (Exception e) {
            return code;
        }
    }


}
