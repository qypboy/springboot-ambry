package com.ambry.config.security;

import com.ambry.common.context.LoginUser;
import com.ambry.common.enums.CodeMessageEnum;
import com.ambry.common.enums.UserRoleEnum;
import com.ambry.common.exception.CommonException;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;

@Component
public class JwtTokenProvider {
    private final SecurityProperties properties;

    public JwtTokenProvider(SecurityProperties properties) {
        this.properties = properties;
    }

    public String createToken(LoginUser user) {
        String payload = user.userId() + "|" + user.username() + "|" + user.userNo() + "|" + user.role() + "|" +
                (Instant.now().getEpochSecond() + properties.getExpireSeconds());
        String encoded = Base64.getUrlEncoder().withoutPadding().encodeToString(payload.getBytes(StandardCharsets.UTF_8));
        return encoded + "." + sign(encoded);
    }

    public LoginUser parse(String token) {
        String[] parts = token == null ? new String[0] : token.split("\\.");
        if (parts.length != 2 || !sign(parts[0]).equals(parts[1])) {
            throw new CommonException(CodeMessageEnum.AUTH_INVALID_TOKEN);
        }
        String payload = new String(Base64.getUrlDecoder().decode(parts[0]), StandardCharsets.UTF_8);
        String[] values = payload.split("\\|");
        if (values.length != 5 || Long.parseLong(values[4]) < Instant.now().getEpochSecond()) {
            throw new CommonException(CodeMessageEnum.AUTH_EXPIRED_TOKEN);
        }
        return new LoginUser(Long.parseLong(values[0]), values[1], values[2], UserRoleEnum.valueOf(values[3]));
    }

    private String sign(String payload) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(properties.getTokenSecret().getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            return Base64.getUrlEncoder().withoutPadding().encodeToString(mac.doFinal(payload.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            throw new IllegalStateException("无法生成令牌签名", e);
        }
    }
}
