package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.AiUserCharacterRelation;

/**
 * 用户角色关系Mapper接口
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
public interface AiUserCharacterRelationMapper 
{
    /**
     * 查询用户角色关系
     * 
     * @param id 用户角色关系主键
     * @return 用户角色关系
     */
    public AiUserCharacterRelation selectAiUserCharacterRelationById(Long id);

    /**
     * 查询用户角色关系列表
     * 
     * @param aiUserCharacterRelation 用户角色关系
     * @return 用户角色关系集合
     */
    public List<AiUserCharacterRelation> selectAiUserCharacterRelationList(AiUserCharacterRelation aiUserCharacterRelation);

    /**
     * 新增用户角色关系
     * 
     * @param aiUserCharacterRelation 用户角色关系
     * @return 结果
     */
    public int insertAiUserCharacterRelation(AiUserCharacterRelation aiUserCharacterRelation);

    /**
     * 修改用户角色关系
     * 
     * @param aiUserCharacterRelation 用户角色关系
     * @return 结果
     */
    public int updateAiUserCharacterRelation(AiUserCharacterRelation aiUserCharacterRelation);

    /**
     * 删除用户角色关系
     * 
     * @param id 用户角色关系主键
     * @return 结果
     */
    public int deleteAiUserCharacterRelationById(Long id);

    /**
     * 批量删除用户角色关系
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAiUserCharacterRelationByIds(Long[] ids);
}
