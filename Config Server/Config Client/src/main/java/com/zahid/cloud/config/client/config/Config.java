package com.zahid.cloud.config.client.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@ConfigurationProperties("greetings")
@RefreshScope
@Data
public class Config{
    String say;
}
