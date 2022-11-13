package com.eyen.portal.service;

import com.eyen.portal.model.auto.sysnotice.SysNotice;
import com.eyen.portal.model.auto.sysnotice.SysNoticeExample;
import com.eyen.portal.model.auto.sysnotice.TsysUser;
import com.eyen.portal.model.custom.TablePost;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 系统公告
 *
 * @author yuwenbo
 * @date 2022/11/9 22:05
 **/
public interface SysNoticeService {
    /**
     * 分页查询
     *
     * @param tablepar
     * @param name
     * @return
     */
    PageInfo<SysNotice> list(TablePost tablepar, String name);

    /**
     * 对应用户的所有公告信息
     *
     * @param tsysUser
     * @param tablepar
     * @param name
     * @return
     */
    PageInfo<SysNotice> list(TsysUser tsysUser, TablePost tablepar, String name);

    int deleteByPrimaryKey(String ids);

    SysNotice selectByPrimaryKey(String id);

    int insertSelective(SysNotice record);

    int updateByPrimaryKeySelective(SysNotice record);

    int updateByExampleSelective(SysNotice record, SysNoticeExample example);

    int updateByExample(SysNotice record, SysNoticeExample example);

    List<SysNotice> selectByExample(SysNoticeExample example);

    long countByExample(SysNoticeExample example);

    int deleteByExample(SysNoticeExample example);

    /**
     * 检查name
     *
     * @param sysNotice
     * @return
     */
    int checkNameUnique(SysNotice sysNotice);

    /**
     * 获取用户未阅读公告
     *
     * @param tsysUser
     * @param state    阅读状态  0未阅读 1 阅读  -1全部
     * @return
     * @author fuce
     * @Date 2019年9月8日 上午3:36:21
     */
    List<SysNotice> getuserNoticeNotRead(TsysUser tsysUser, int state);

    /**
     * 根据公告id把当前用户的公告置为以查看
     *
     * @param noticeid
     * @author fuce
     * @Date 2019年9月8日 下午7:14:19
     */
    void editUserState(String noticeid);

    /**
     * 获取最新8条公告
     *
     * @return
     */
    List<SysNotice> getNEW();
}
