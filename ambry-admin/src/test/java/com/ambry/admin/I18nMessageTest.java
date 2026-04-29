package com.ambry.admin;

import com.ambry.common.util.MessageUtils;
import com.ambry.common.enums.CodeMessageEnum;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

class I18nMessageTest {

    @Test
    void resolvesBusinessExceptionMessageByLocale() {
        assertThat(MessageUtils.message(CodeMessageEnum.AUTH_INVALID_CREDENTIAL.getCode(), Locale.SIMPLIFIED_CHINESE))
                .isEqualTo("用户名或密码错误");
        assertThat(MessageUtils.message(CodeMessageEnum.AUTH_INVALID_CREDENTIAL.getCode(), Locale.ENGLISH))
                .isEqualTo("Invalid username or password");
    }
}
