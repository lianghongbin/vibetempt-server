package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.AiCharacter;

/**
 * AI角色Service接口
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
public interface AiCharacterService 
{
    /**
     * 查询AI角色
     * 
     * @param id AI角色主键
     * @return AI角色
     */
    public AiCharacter selectAiCharacterById(Long id);

    /**
     * 查询AI角色列表
     * 
     * @param aiCharacter AI角色
     * @return AI角色集合
     */
    public List<AiCharacter> selectAiCharacterList(AiCharacter aiCharacter);

    /**
     * 新增AI角色
     * 
     * @param aiCharacter AI角色
     * @return 结果
     */
    public int insertAiCharacter(AiCharacter aiCharacter);

    /**
     * 修改AI角色
     * 
     * @param aiCharacter AI角色
     * @return 结果
     */
    public int updateAiCharacter(AiCharacter aiCharacter);

    /**
     * 批量删除AI角色
     * 
     * @param ids 需要删除的AI角色主键集合
     * @return 结果
     */
    public int deleteAiCharacterByIds(Long[] ids);

    /**
     * 删除AI角色信息
     * 
     * @param id AI角色主键
     * @return 结果
     */
    public int deleteAiCharacterById(Long id);
}
