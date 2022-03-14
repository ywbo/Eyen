package com.eyen.portal.web.controller.system;


import com.eyen.common.convert.ConvertType;
import com.eyen.common.core.base.BaseController;
import com.eyen.common.utils.ServletUtils;
import com.eyen.framework.web.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yuwenbo
 * @description 首页登录验证
 * @date 2022/02/28 22:21
 **/
@Controller
public class SysLoginController extends BaseController {
    /**
     * 是否开启记住我功能
     */
    @Value("true")
    private boolean rememberMe;

    @Autowired
    private ConfigService configService;

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        // 如果是Ajax请求，返回Json字符串
        if (ServletUtils.isAjaxRequest(request)) {
            return ServletUtils.renderString(response, "{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }
        // 是否开启记住我
        modelMap.put("isRememberMe", rememberMe);
        // 是否开启新用户注册
        modelMap.put("isAllowRegister", ConvertType.toBool(configService.getKey("sys.account.registerUser"), false));
        return "login";
    }

}
