package com.eyen.framework.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * HTML调用Thymeleaf实现参数管理
 *
 * @author yuwenbo
 * @date 2022/03/11 22:10
 **/
@Service("config")
public class ConfigService {
    @Autowired
    private ISysConfigService configService;

    /**
     * 根据键名查询配置参数信息
     *
     * @param cfgKey 参数键名
     * @return 参数键值
     */
    public String getKey(String cfgKey) {
        return configService.selectConfigByKey(cfgKey);
    }
}
