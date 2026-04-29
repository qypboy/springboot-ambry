package com.example.integration.sms;

import com.example.integration.config.ThirdPartyFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "smsClient", url = "${ambry.integration.sms-url:http://localhost:18080}", configuration = ThirdPartyFeignConfig.class)
public interface SmsClient {

    @PostMapping("/sms/send")
    Map<String, Object> send(@RequestBody Map<String, Object> payload);
}
