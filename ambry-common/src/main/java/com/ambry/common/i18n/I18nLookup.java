package com.ambry.common.i18n;

import java.util.Locale;

public interface I18nLookup {
    String text(String i18nKey, Locale locale);
}

