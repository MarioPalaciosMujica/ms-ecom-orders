package com.ecom.order.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;

@Component
@ConfigurationProperties
@PropertySource("application.properties")
@Data
public class AppConfig {

    @NotEmpty
    @Value("${ms.web_url}")
    private String msWebUrl;
}
