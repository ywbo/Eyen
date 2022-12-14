package com.eyen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class, scanBasePackages = "com.eyen.portal.*")
public class EyenPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(EyenPortalApplication.class, args);
    }

}
