package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AiUserCharacterRelationMapper;
import com.ruoyi.system.domain.AiUserCharacterRelation;
import com.ruoyi.system.service.AiUserCharacterRelationService;

/**
 * 用户角色关系Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
@Service
public class AiUserCharacterRelationServiceImpl implements AiUserCharacterRelationService 
{
    @Autowired
    private AiUserCharacterRelationMapper aiUserCharacterRelationMapper;

    /**
     * 查询用户角色关系
     * 
     * @param id 用户角色关系主键
     * @return 用户角色关系
     */
    @Override
    public AiUserCharacterRelation selectAiUserCharacterRelationById(Long id)
    {
        return aiUserCharacterRelationMapper.selectAiUserCharacterRelationById(id);
    }

    /**
     * 查询用户角色关系列表
     * 
     * @param aiUserCharacterRelation 用户角色关系
     * @return 用户角色关系
     */
    @Override
    public List<AiUserCharacterRelation> selectAiUserCharacterRelationList(AiUserCharacterRelation aiUserCharacterRelation)
    {
        return aiUserCharacterRelationMapper.selectAiUserCharacterRelationList(aiUserCharacterRelation);
    }

    /**
     * 新增用户角色关系
     * 
     * @param aiUserCharacterRelation 用户角色关系
     * @return 结果
     */
    @Override
    public int insertAiUserCharacterRelation(AiUserCharacterRelation aiUserCharacterRelation)
    {
        aiUserCharacterRelation.setCreateTime(DateUtils.getNowDate());
        return aiUserCharacterRelationMapper.insertAiUserCharacterRelation(aiUserCharacterRelation);
    }

    /**
     * 修改用户角色关系
     * 
     * @param aiUserCharacterRelation 用户角色关系
     * @return 结果
     */
    @Override
    public int updateAiUserCharacterRelation(AiUserCharacterRelation aiUserCharacterRelation)
    {
        aiUserCharacterRelation.setUpdateTime(DateUtils.getNowDate());
        return aiUserCharacterRelationMapper.updateAiUserCharacterRelation(aiUserCharacterRelation);
    }

    /**
     * 批量删除用户角色关系
     * 
     * @param ids 需要删除的用户角色关系主键
     * @return 结果
     */
    @Override
    public int deleteAiUserCharacterRelationByIds(Long[] ids)
    {
        return aiUserCharacterRelationMapper.deleteAiUserCharacterRelationByIds(ids);
    }

    /**
     * 删除用户角色关系信息
     * 
     * @param id 用户角色关系主键
     * @return 结果
     */
    @Override
    public int deleteAiUserCharacterRelationById(Long id)
    {
        return aiUserCharacterRelationMapper.deleteAiUserCharacterRelationById(id);
    }
}
