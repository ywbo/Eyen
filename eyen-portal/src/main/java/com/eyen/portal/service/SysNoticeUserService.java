package com.eyen.portal.service;

import com.eyen.portal.model.auto.sysnotice.SysNoticeUser;
import com.eyen.portal.model.auto.sysnotice.SysNoticeUserItem;
import com.eyen.portal.model.custom.TablePost;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 公告_用户外键 SysNoticeUserService
 *
 * @author yuwenbo
 * @date 2022/11/7 23:07
 */

public interface SysNoticeUserService {

    /**
     * 分页查询
     *
     * @param tablepar
     * @param name
     * @return
     */
    PageInfo<SysNoticeUser> list(TablePost tablepar, String name);

    int deleteByPrimaryKey(String ids);
    
    SysNoticeUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysNoticeUser record);

    /**
     * 添加
     */
    int insertSelective(SysNoticeUser record);

    int updateByExampleSelective(SysNoticeUser record, SysNoticeUserItem example);

    int updateByExample(SysNoticeUser record, SysNoticeUserItem example);

    List<SysNoticeUser> selectByExample(SysNoticeUserItem example);

    long countByExample(SysNoticeUserItem example);

    int deleteByExample(SysNoticeUserItem example);

    /**
     * 检查name
     *
     * @param sysNoticeUser
     * @return
     */
    public int checkNameUnique(SysNoticeUser sysNoticeUser);

}
