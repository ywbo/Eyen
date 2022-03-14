package com.eyen.common.core.base;

import com.eyen.common.core.domain.AjaxResult;
import com.eyen.common.core.domain.ResuTree;
import com.eyen.common.core.domain.ResultTable;
import com.eyen.common.core.domain.entity.SysUser;
import com.eyen.common.core.page.PageDomain;
import com.eyen.common.core.page.TableDataInfo;
import com.eyen.common.core.page.TableSupport;
import com.eyen.common.utils.PageUtils;
import com.eyen.common.utils.ServletUtils;
import com.eyen.common.utils.ShiroUtils;
import com.eyen.common.utils.StringUtils;
import com.eyen.common.utils.sql.SqlUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author yuwenbo
 * @description web层通用数据处理
 * @date 2022/02/28 22:26
 **/
public class BaseController {
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
     * 设置请求分页数据
     */
    protected void startPage() {
        PageUtils.startPage();
    }

    /**
     * 设置请求排序数据
     */
    protected void startOrderBy() {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        if (StringUtils.isNotEmpty(pageDomain.getOrderBy())) {
            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
            PageHelper.orderBy(orderBy);
        }
    }

    /**
     * 获取request
     */
    public HttpServletRequest getRequest() {
        return ServletUtils.getRequest();
    }

    /**
     * 获取response
     */
    public HttpServletResponse getResponse() {
        return ServletUtils.getResponse();
    }

    /**
     * 获取session
     */
    public HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * 响应请求分页数据
     */
    protected TableDataInfo getDataTable(List<?> list) {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(0);
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
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
    public String redirect(String url) {
        return StringUtils.format("redirect:{}", url);
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

    /**
     * 获取用户缓存信息
     */
    public SysUser getSysUser() {
        return ShiroUtils.getSysUser();
    }

    /**
     * 设置用户缓存信息
     */
    public void setSysUser(SysUser user) {
        ShiroUtils.setSysUser(user);
    }

    /**
     * 获取登录用户id
     */
    public Long getUserId() {
        return getSysUser().getUserId();
    }

    /**
     * 获取登录用户名
     */
    public String getLoginName() {
        return getSysUser().getLoginName();
    }
}
