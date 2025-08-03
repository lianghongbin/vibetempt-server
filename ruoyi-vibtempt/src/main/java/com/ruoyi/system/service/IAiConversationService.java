package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.AiConversation;

/**
 * 对话会话Service接口
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
public interface IAiConversationService 
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
     * 批量删除对话会话
     * 
     * @param ids 需要删除的对话会话主键集合
     * @return 结果
     */
    public int deleteAiConversationByIds(Long[] ids);

    /**
     * 删除对话会话信息
     * 
     * @param id 对话会话主键
     * @return 结果
     */
    public int deleteAiConversationById(Long id);
}
