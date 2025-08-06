package com.ruoyi.vibetempt.mapper;

import java.util.List;
import com.ruoyi.vibetempt.domain.AiCharacterMemory;

/**
 * 角色记忆Mapper接口
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
public interface AiCharacterMemoryMapper 
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
     * 删除角色记忆
     * 
     * @param id 角色记忆主键
     * @return 结果
     */
    public int deleteAiCharacterMemoryById(Long id);

    /**
     * 批量删除角色记忆
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAiCharacterMemoryByIds(Long[] ids);
}
