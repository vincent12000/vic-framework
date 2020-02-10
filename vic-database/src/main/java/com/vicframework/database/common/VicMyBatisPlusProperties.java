package com.vicframework.database.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "vic.database.mybatis", ignoreUnknownFields = false)
@Data
public class VicMyBatisPlusProperties {

    private String mapperScanPath;
}
