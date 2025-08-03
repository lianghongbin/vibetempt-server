package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AiCharacterMemoryMapper;
import com.ruoyi.system.domain.AiCharacterMemory;
import com.ruoyi.system.service.IAiCharacterMemoryService;

/**
 * 角色记忆Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
@Service
public class AiCharacterMemoryServiceImpl implements IAiCharacterMemoryService 
{
    @Autowired
    private AiCharacterMemoryMapper aiCharacterMemoryMapper;

    /**
     * 查询角色记忆
     * 
     * @param id 角色记忆主键
     * @return 角色记忆
     */
    @Override
    public AiCharacterMemory selectAiCharacterMemoryById(Long id)
    {
        return aiCharacterMemoryMapper.selectAiCharacterMemoryById(id);
    }

    /**
     * 查询角色记忆列表
     * 
     * @param aiCharacterMemory 角色记忆
     * @return 角色记忆
     */
    @Override
    public List<AiCharacterMemory> selectAiCharacterMemoryList(AiCharacterMemory aiCharacterMemory)
    {
        return aiCharacterMemoryMapper.selectAiCharacterMemoryList(aiCharacterMemory);
    }

    /**
     * 新增角色记忆
     * 
     * @param aiCharacterMemory 角色记忆
     * @return 结果
     */
    @Override
    public int insertAiCharacterMemory(AiCharacterMemory aiCharacterMemory)
    {
        aiCharacterMemory.setCreateTime(DateUtils.getNowDate());
        return aiCharacterMemoryMapper.insertAiCharacterMemory(aiCharacterMemory);
    }

    /**
     * 修改角色记忆
     * 
     * @param aiCharacterMemory 角色记忆
     * @return 结果
     */
    @Override
    public int updateAiCharacterMemory(AiCharacterMemory aiCharacterMemory)
    {
        aiCharacterMemory.setUpdateTime(DateUtils.getNowDate());
        return aiCharacterMemoryMapper.updateAiCharacterMemory(aiCharacterMemory);
    }

    /**
     * 批量删除角色记忆
     * 
     * @param ids 需要删除的角色记忆主键
     * @return 结果
     */
    @Override
    public int deleteAiCharacterMemoryByIds(Long[] ids)
    {
        return aiCharacterMemoryMapper.deleteAiCharacterMemoryByIds(ids);
    }

    /**
     * 删除角色记忆信息
     * 
     * @param id 角色记忆主键
     * @return 结果
     */
    @Override
    public int deleteAiCharacterMemoryById(Long id)
    {
        return aiCharacterMemoryMapper.deleteAiCharacterMemoryById(id);
    }
}
