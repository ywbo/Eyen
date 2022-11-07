package com.eyen.portal.service;

import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SysFileService {

    /**
     * 分页查询
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<SysFile> list(Tablepar tablepar, String name);


    /**
     * 检查文件名字
     *
     * @param tsysFile
     * @return
     */
    int checkNameUnique(SysFile tsysFile);


    /**
     * 修改信息
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysFile record);


    /**
     * 删除文件信息全部
     *
     * @param ids 文件集合 1,2,3
     */
    int deleteByPrimaryKey(String ids);

    int insertSelective(SysFile record);

    SysFile selectByPrimaryKey(String id);


    int updateByPrimaryKeySelective(SysFile record);

    int updateByExampleSelective(SysFile record, SysFileExample example);

    int updateByExample(SysFile record, SysFileExample example);

    List<SysFile> selectByExample(SysFileExample example);

    long countByExample(SysFileExample example);

    int deleteByExample(SysFileExample example);
}
