package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.AiCharacter;

/**
 * AI角色Mapper接口
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
public interface AiCharacterMapper 
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
     * 删除AI角色
     * 
     * @param id AI角色主键
     * @return 结果
     */
    public int deleteAiCharacterById(Long id);

    /**
     * 批量删除AI角色
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAiCharacterByIds(Long[] ids);
}
