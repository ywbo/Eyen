package com.eyen.portal.dao;

import com.eyen.interfaces.entity.SysConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 参数配置 数据层
 *
 * @author yuwenbo
 * @date 2022/03/13 22:06
 **/
@Mapper
public interface SysConfigDao {
    /**
     * 查询参数配置信息
     *
     * @param config 参数配置信息
     * @return 参数配置信息
     */
    SysConfig selectConfig(SysConfig config);

    /**
     * 查询参数配置列表
     *
     * @param config 参数配置信息
     * @return 参数配置集合
     */
    List<SysConfig> selectConfigList(SysConfig config);

    /**
     * 根据键名查询参数配置信息
     *
     * @param configKey 参数键名
     * @return 参数配置信息
     */
    SysConfig checkConfigKeyUnique(String configKey);

    /**
     * 新增参数配置
     *
     * @param config 参数配置信息
     * @return 结果
     */
    int insertConfig(SysConfig config);

    /**
     * 修改参数配置
     *
     * @param config 参数配置信息
     * @return 结果
     */
    int updateConfig(SysConfig config);

    /**
     * 删除参数配置
     *
     * @param configId 参数主键
     * @return 结果
     */
    int deleteConfigById(Long configId);

    /**
     * 批量删除参数配置
     *
     * @param configIds 需要删除的数据ID
     * @return 结果
     */
    int deleteConfigByIds(String[] configIds);
}
