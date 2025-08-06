package com.ruoyi.vibetempt.mapper;

import java.util.List;
import com.ruoyi.vibetempt.domain.AiConversation;

/**
 * 对话会话Mapper接口
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
public interface AiConversationMapper 
{
    /**
     * 查询对话会话
     * 
     * @param id 对话会话主键
     * @return 对话会话
     */
    public AiConversation selectAiConversationById(Long id);

    /**
     * 查询对话会话列表
     * 
     * @param aiConversation 对话会话
     * @return 对话会话集合
     */
    public List<AiConversation> selectAiConversationList(AiConversation aiConversation);

    /**
     * 新增对话会话
     * 
     * @param aiConversation 对话会话
     * @return 结果
     */
    public int insertAiConversation(AiConversation aiConversation);

    /**
     * 修改对话会话
     * 
     * @param aiConversation 对话会话
     * @return 结果
     */
    public int updateAiConversation(AiConversation aiConversation);

    /**
     * 删除对话会话
     * 
     * @param id 对话会话主键
     * @return 结果
     */
    public int deleteAiConversationById(Long id);

    /**
     * 批量删除对话会话
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAiConversationByIds(Long[] ids);
}
