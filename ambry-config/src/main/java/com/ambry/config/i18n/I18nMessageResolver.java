package com.ambry.config.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class I18nMessageResolver {
    private final MessageSource messageSource;

    public I18nMessageResolver(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String message(String key, Locale locale, Object... args) {
        try {
            return messageSource.getMessage(key, args, locale);
        } catch (NoSuchMessageException exception) {
            return key;
        }
    }
}
