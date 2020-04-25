package com.poc.ibmmq;

import com.poc.ibmmq.properties.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class IbmmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(IbmmqApplication.class, args);
    }

}
