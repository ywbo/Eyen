package com.eyen.portal.dao.auto;

import com.eyen.portal.model.auto.sysnotice.SysNoticeUser;
import com.eyen.portal.model.auto.sysnotice.SysNoticeUserItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户公告dao
 *
 * @author yuwenbo
 * @date 2022/11/7 22:59
 **/
public interface SysNoticeUserDao {
    long countByExample(SysNoticeUserItem example);

    int deleteByExample(SysNoticeUserItem example);

    int deleteByPrimaryKey(String id);

    int insert(SysNoticeUser record);

    int insertSelective(SysNoticeUser record);

    List<SysNoticeUser> selectByExample(SysNoticeUserItem example);

    SysNoticeUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysNoticeUser record, @Param("example") SysNoticeUserItem example);

    int updateByExample(@Param("record") SysNoticeUser record, @Param("example") SysNoticeUserItem example);

    int updateByPrimaryKeySelective(SysNoticeUser record);

    int updateByPrimaryKey(SysNoticeUser record);
}
