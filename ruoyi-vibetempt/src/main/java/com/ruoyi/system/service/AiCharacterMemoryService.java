package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.AiCharacterMemory;

/**
 * 角色记忆Service接口
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
public interface AiCharacterMemoryService 
{
    /**
     * 查询角色记忆
     * 
     * @param id 角色记忆主键
     * @return 角色记忆
     */
    public AiCharacterMemory selectAiCharacterMemoryById(Long id);

    /**
     * 查询角色记忆列表
     * 
     * @param aiCharacterMemory 角色记忆
     * @return 角色记忆集合
     */
    public List<AiCharacterMemory> selectAiCharacterMemoryList(AiCharacterMemory aiCharacterMemory);

    /**
     * 新增角色记忆
     * 
     * @param aiCharacterMemory 角色记忆
     * @return 结果
     */
    public int insertAiCharacterMemory(AiCharacterMemory aiCharacterMemory);

    /**
     * 修改角色记忆
     * 
     * @param aiCharacterMemory 角色记忆
     * @return 结果
     */
    public int updateAiCharacterMemory(AiCharacterMemory aiCharacterMemory);

    /**
     * 批量删除角色记忆
     * 
     * @param ids 需要删除的角色记忆主键集合
     * @return 结果
     */
    public int deleteAiCharacterMemoryByIds(Long[] ids);

    /**
     * 删除角色记忆信息
     * 
     * @param id 角色记忆主键
     * @return 结果
     */
    public int deleteAiCharacterMemoryById(Long id);
}
