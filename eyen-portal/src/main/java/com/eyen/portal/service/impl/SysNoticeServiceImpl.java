package com.eyen.portal.service.impl;

import com.eyen.common.core.base.BaseService;
import com.eyen.portal.model.custom.TablePost;
import com.eyen.portal.service.SysNoticeService;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 系统公告
 *
 * @author yuwenbo
 * @date 2022/11/9 22:10
 **/
public class SysNoticeServiceImpl implements SysNoticeService, BaseService<SysNotice, SysNoticeExample> {

    @Override
    public PageInfo<SysNotice> list(TablePost tablepar, String name) {
        return null;
    }

    @Override
    public PageInfo<SysNotice> list(TsysUser tsysUser, TablePost tablepar, String name) {
        return null;
    }

    @Override
    public int deleteByPrimaryKey(String ids) {
        return 0;
    }

    @Override
    public SysNotice selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int insertSelective(SysNotice record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(SysNotice record) {
        return 0;
    }

    @Override
    public int updateByExampleSelective(SysNotice record, SysNoticeExample example) {
        return 0;
    }

    @Override
    public int updateByExample(SysNotice record, SysNoticeExample example) {
        return 0;
    }

    @Override
    public List<SysNotice> selectByExample(SysNoticeExample example) {
        return null;
    }

    @Override
    public long countByExample(SysNoticeExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(SysNoticeExample example) {
        return 0;
    }

    @Override
    public int checkNameUnique(SysNotice sysNotice) {
        return 0;
    }

    @Override
    public List<SysNotice> getuserNoticeNotRead(TsysUser tsysUser, int state) {
        return null;
    }

    @Override
    public void editUserState(String noticeid) {

    }

    @Override
    public List<SysNotice> getNEW() {
        return null;
    }
}
