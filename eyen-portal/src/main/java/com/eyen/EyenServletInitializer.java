package com.eyen;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * portal 容器中部署
 *
 * @author yuwenbo
 * @date 2022/04/24 22:33
 **/
public class EyenServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EyenPortalApplication.class);
    }
}
