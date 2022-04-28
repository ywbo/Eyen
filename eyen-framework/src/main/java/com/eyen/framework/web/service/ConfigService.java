package com.eyen.framework.web.service;

/**
 * HTML调用Thymeleaf实现参数管理
 *
 * @author yuwenbo
 * @date 2022/03/11 22:10
 **/
public interface ConfigService {

    /**
     * 根据键名查询配置参数信息
     *
     * @param cfgKey 参数键名
     * @return 参数键值
     */
    public String getKey(String cfgKey);
}
