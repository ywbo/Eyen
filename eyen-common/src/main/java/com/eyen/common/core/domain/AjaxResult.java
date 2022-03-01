package com.eyen.common.core.domain;

import java.util.HashMap;

/**
 * 操作消息提醒
 *
 * @author yuwenbo
 * @date 2022/02/28 23:55
 **/
public class AjaxResult extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    public static final String CODE_TAG = "code";

    /**
     * 返回内容
     */
    public static final String MSG_TAG = "msg";

    /**
     * 数据对象
     */
    public static final String DATA_TAG = "data";

    /**
     * 返回成功消息
     *
     * @param msg
     * @return AjaxResult
     */
    public static AjaxResult success(String msg) {
        AjaxResult json = new AjaxResult();
        json.put("msg", msg);
        json.put("code", 200);
        return json;
    }

    /**
     * 返回成功
     */
    public static AjaxResult success() {
        return AjaxResult.success("操作成功");
    }

    public static AjaxResult error() {
        return error(500, "操作失败");
    }

    public static AjaxResult error(String msg) {
        return error(500, msg);
    }

    public static AjaxResult error(int code, String msg) {
        AjaxResult json = new AjaxResult();
        json.put("code", code);
        json.put("msg", msg);
        return json;
    }

    public static AjaxResult successData(int code, Object value) {
        AjaxResult json = new AjaxResult();
        json.put("code", code);
        json.put("data", value);
        return json;
    }
}
