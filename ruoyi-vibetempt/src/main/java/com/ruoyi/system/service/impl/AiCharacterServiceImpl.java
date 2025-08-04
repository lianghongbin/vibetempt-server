package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AiCharacterMapper;
import com.ruoyi.system.domain.AiCharacter;
import com.ruoyi.system.service.AiCharacterService;

/**
 * AI角色Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
@Service
public class AiCharacterServiceImpl implements AiCharacterService 
{
    @Autowired
    private AiCharacterMapper aiCharacterMapper;

    /**
     * 查询AI角色
     * 
     * @param id AI角色主键
     * @return AI角色
     */
    @Override
    public AiCharacter selectAiCharacterById(Long id)
    {
        return aiCharacterMapper.selectAiCharacterById(id);
    }

    /**
     * 查询AI角色列表
     * 
     * @param aiCharacter AI角色
     * @return AI角色
     */
    @Override
    public List<AiCharacter> selectAiCharacterList(AiCharacter aiCharacter)
    {
        return aiCharacterMapper.selectAiCharacterList(aiCharacter);
    }

    /**
     * 新增AI角色
     * 
     * @param aiCharacter AI角色
     * @return 结果
     */
    @Override
    public int insertAiCharacter(AiCharacter aiCharacter)
    {
        aiCharacter.setCreateTime(DateUtils.getNowDate());
        return aiCharacterMapper.insertAiCharacter(aiCharacter);
    }

    /**
     * 修改AI角色
     * 
     * @param aiCharacter AI角色
     * @return 结果
     */
    @Override
    public int updateAiCharacter(AiCharacter aiCharacter)
    {
        aiCharacter.setUpdateTime(DateUtils.getNowDate());
        return aiCharacterMapper.updateAiCharacter(aiCharacter);
    }

    /**
     * 批量删除AI角色
     * 
     * @param ids 需要删除的AI角色主键
     * @return 结果
     */
    @Override
    public int deleteAiCharacterByIds(Long[] ids)
    {
        return aiCharacterMapper.deleteAiCharacterByIds(ids);
    }

    /**
     * 删除AI角色信息
     * 
     * @param id AI角色主键
     * @return 结果
     */
    @Override
    public int deleteAiCharacterById(Long id)
    {
        return aiCharacterMapper.deleteAiCharacterById(id);
    }
}
