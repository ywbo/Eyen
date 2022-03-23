package com.eyen.portal;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * web容器中部署
 *
 * @author yuwenbo
 * @date 2022/03/15 22:50
 **/
public class EyenServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(EyenPortalApplication.class);
    }
}
