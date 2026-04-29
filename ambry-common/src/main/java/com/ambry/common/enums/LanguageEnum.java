package com.ambry.common.enums;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author zhanwen.qiu
 */
@Getter
public enum LanguageEnum implements EnumInterface<String> {
    /**
     * 中文
     */
    ZH("zh"),

    /**
     * 英语
     */
    EN("en"),

    /**
     * 法语
     */
    FR("fr"),

    /**
     * 德语
     */
    DE("de"),

    /**
     * 日语
     */
    JA("ja"),

    /**
     * 韩语
     */
    KO("ko");

    /**
     * 语言编码
     */
    @EnumValue
    final String lang;

    LanguageEnum(String lang) {
        this.lang = lang;
    }

    public static LanguageEnum getLanguage() {
        String language = LocaleContextHolder.getLocale().getLanguage();
        return match(language);
    }

    public static boolean isZh() {
        LanguageEnum nowLang = getLanguage();
        return ZH == nowLang;
    }

    public static LanguageEnum nameOf(String language) {
        if (StringUtils.isBlank(language)) {
            return ZH;
        }
        LanguageEnum target = ZH;
        LanguageEnum[] languages = LanguageEnum.values();
        for (int i = 0; i < languages.length; i++) {
            LanguageEnum li = languages[i];
            if (language.startsWith(li.lang)) {
                target = li;
                break;
            }
        }
        return target;
    }

    /**
     * 判断是否存在默认语言
     */
    public static boolean checkDefaultLang(List<SysI18nAO> detailName) {
        for (SysI18nAO SysI18nAO : detailName) {
            if (LanguageEnum.ZH.getLang().equals(SysI18nAO.getLangCode()) && !StrUtil.isAllEmpty(SysI18nAO.getI18nValue())) {
                return true;
            }
        }
        return false;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static LanguageEnum match(Object code) {
        return EnumUtil.match(LanguageEnum.class, code);
    }

    @Override
    public String getCode() {
        return this.lang;
    }
}
