package com.ambry.business.i18n;

import com.ambry.business.service.BaseI18nService;
import com.ambry.common.entity.BaseI18nEntity;
import com.ambry.common.i18n.I18nLookup;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Locale;

@Component
public class DatabaseI18nLookup implements I18nLookup {
    private final BaseI18nService baseI18nService;

    public DatabaseI18nLookup(BaseI18nService baseI18nService) {
        this.baseI18nService = baseI18nService;
    }

    @Override
    public String text(String i18nKey, Locale locale) {
        if (!StringUtils.hasText(i18nKey)) {
            return i18nKey;
        }
        String localeCode = normalize(locale);
        BaseI18nEntity exact = baseI18nService.lambdaQuery()
                .eq(BaseI18nEntity::getI18nKey, i18nKey)
                .eq(BaseI18nEntity::getLocale, localeCode)
                .eq(BaseI18nEntity::getDeleted, 0)
                .one();
        if (exact != null && StringUtils.hasText(exact.getI18nValue())) {
            return exact.getI18nValue();
        }
        BaseI18nEntity fallback = baseI18nService.lambdaQuery()
                .eq(BaseI18nEntity::getI18nKey, i18nKey)
                .eq(BaseI18nEntity::getLocale, "zh_CN")
                .eq(BaseI18nEntity::getDeleted, 0)
                .one();
        return fallback == null ? i18nKey : fallback.getI18nValue();
    }

    private String normalize(Locale locale) {
        if (locale == null) {
            return "zh_CN";
        }
        if ("zh".equalsIgnoreCase(locale.getLanguage())) {
            return "zh_CN";
        }
        return "en";
    }
}

