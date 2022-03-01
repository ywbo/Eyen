package com.eyen.common.core.base;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.eyen.common.core.domain.AjaxResult;
import com.eyen.common.core.domain.ResuTree;
import com.eyen.common.core.domain.ResultTable;
import com.eyen.interfaces.base.BaseApi;

import cn.hutool.core.util.StrUtil;

/**
 * @author yuwenbo
 * @description web层通用数据处理
 * @date 2022/02/28 22:26
 **/
@Controller
public class BaseController implements BaseApi {
    /**
     * 日志
     */
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 将前台传过来的日志格式字符串，自动转换成Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * 返回响应结果
     */
    protected AjaxResult toAjax(int rows) {
        return rows > 0 ? success() : error();
    }

    /**
     * 返回成功
     */
    public AjaxResult success() {
        return AjaxResult.success();
    }

    /**
     * 返回失败
     */
    public AjaxResult error() {
        return AjaxResult.error();
    }

    /**
     * 返回成功消息
     *
     * @param message
     * @return
     */
    public AjaxResult success(String message) {
        return AjaxResult.success(message);
    }

    /**
     * 返回失败消息
     *
     * @param message
     * @return
     */
    public AjaxResult error(String message) {
        return AjaxResult.error(message);
    }

    /**
     * 返回错误码消息
     *
     * @param code
     * @param message
     * @return
     */
    public AjaxResult error(int code, String message) {
        return AjaxResult.error(code, message);
    }

    /**
     * 返回Object数据
     *
     * @param code
     * @param data
     * @return
     */
    public AjaxResult retobject(int code, Object data) {
        return AjaxResult.successData(code, data);
    }

    /**
     * 页面跳转
     */
    /**
     * 页面跳转
     */
    public String redirect(String url) {
        return StrUtil.format("redirect:{}", url);
    }

    /**
     * Describe: 返回 Tree 数据 Param data Return Tree数据
     */
    protected static ResuTree dataTree(Object data) {
        ResuTree resuTree = new ResuTree();
        resuTree.setData(data);
        return resuTree;
    }

    /**
     * Describe: 返回数据表格数据 分页 Param data Return 表格分页数据
     */
    protected static ResultTable pageTable(Object data, long count) {
        return ResultTable.pageTable(count, data);
    }

    /**
     * Describe: 返回数据表格数据 Param data Return 表格分页数据
     */
    protected static ResultTable dataTable(Object data) {
        return ResultTable.dataTable(data);
    }

    /**
     * Describe: 返回树状表格数据 分页 Param data Return 表格分页数据
     */
    protected static ResultTable treeTable(Object data) {
        return ResultTable.dataTable(data);
    }
}
