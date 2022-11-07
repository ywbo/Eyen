package com.eyen.portal.service.impl;

import com.eyen.common.core.base.BaseService;
import com.eyen.common.utils.ConvertUtil;
import com.eyen.common.utils.SnowflakeIdWorker;
import com.eyen.portal.dao.auto.SysNoticeUserDao;
import com.eyen.portal.model.auto.sysnotice.SysNoticeUser;
import com.eyen.portal.model.auto.sysnotice.SysNoticeUserItem;
import com.eyen.portal.model.custom.TablePost;
import com.eyen.portal.service.SysNoticeUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 公告_用户外键 SysNoticeUserService
 *
 * @author yuwenbo
 * @date 2022/11/7 23:34
 **/
@Service
public class SysNoticeUserServiceImpl implements SysNoticeUserService, BaseService<SysNoticeUser, SysNoticeUserItem> {
    @Resource
    private SysNoticeUserDao sysNoticeUserDao;

    /**
     * 分页查询
     *
     * @param tablepar
     * @param name
     * @return
     */
    @Override
    public PageInfo<SysNoticeUser> list(TablePost tablepar, String name) {
        SysNoticeUserItem testExample = new SysNoticeUserItem();

        testExample.setOrderByClause("id ASC");
        if (name != null && !"".equals(name)) {
            testExample.createCriteria().andUserIdLike("%" + name + "%");
        }

        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
        List<SysNoticeUser> list = sysNoticeUserDao.selectByExample(testExample);
        PageInfo<SysNoticeUser> pageInfo = new PageInfo<SysNoticeUser>(list);
        return pageInfo;
    }

    @Override
    public int deleteByPrimaryKey(String ids) {
        List<String> lists = ConvertUtil.toListStrArray(ids);
        SysNoticeUserItem example = new SysNoticeUserItem();
        example.createCriteria().andIdIn(lists);
        return sysNoticeUserDao.deleteByExample(example);
    }


    @Override
    public SysNoticeUser selectByPrimaryKey(String id) {

        return sysNoticeUserDao.selectByPrimaryKey(id);
    }


    @Override
    public int updateByPrimaryKeySelective(SysNoticeUser record) {
        return sysNoticeUserDao.updateByPrimaryKeySelective(record);
    }

    /**
     * 添加
     */
    @Override
    public int insertSelective(SysNoticeUser record) {
        //添加雪花主键id
        record.setId(SnowflakeIdWorker.getUUID());
        return sysNoticeUserDao.insertSelective(record);
    }


    @Override
    public int updateByExampleSelective(SysNoticeUser record, SysNoticeUserItem example) {

        return sysNoticeUserDao.updateByExampleSelective(record, example);
    }


    @Override
    public int updateByExample(SysNoticeUser record, SysNoticeUserItem example) {

        return sysNoticeUserDao.updateByExample(record, example);
    }

    @Override
    public List<SysNoticeUser> selectByExample(SysNoticeUserItem example) {

        return sysNoticeUserDao.selectByExample(example);
    }


    @Override
    public long countByExample(SysNoticeUserItem example) {

        return sysNoticeUserDao.countByExample(example);
    }


    @Override
    public int deleteByExample(SysNoticeUserItem example) {

        return sysNoticeUserDao.deleteByExample(example);
    }

    /**
     * 检查name
     *
     * @param sysNoticeUser
     * @return
     */
    @Override
    public int checkNameUnique(SysNoticeUser sysNoticeUser) {
        SysNoticeUserItem example = new SysNoticeUserItem();
        example.createCriteria().andUserIdEqualTo(sysNoticeUser.getUserId());
        List<SysNoticeUser> list = sysNoticeUserDao.selectByExample(example);
        return list.size();
    }

}
