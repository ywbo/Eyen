package com.eyen.framework.web.service.impl;

import com.eyen.framework.web.service.ConfigService;
import com.eyen.interfaces.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * HTML 调用 Thymeleaf 实现参数管理
 *
 * @author yuwenbo
 * @date 2022/04/24 22:43
 **/
@Service
public class ConfigServiceImpl implements ConfigService {
    @Autowired
    private ISysConfigService sysConfigService;

    /**
     * 根据键名查询配置参数信息
     *
     * @param cfgKey 参数键名
     * @return 参数键值
     */
    @Override
    public String getKey(String cfgKey) {
        return sysConfigService.selectConfigByKey(cfgKey);
    }
}
