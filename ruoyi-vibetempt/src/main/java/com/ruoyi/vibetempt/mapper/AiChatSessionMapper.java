package com.ruoyi.vibetempt.mapper;

import java.util.List;
import com.ruoyi.vibetempt.domain.AiChatSession;

/**
 * 聊天会话状态Mapper接口
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
public interface AiChatSessionMapper 
{
    /**
     * 查询聊天会话状态
     * 
     * @param id 聊天会话状态主键
     * @return 聊天会话状态
     */
    public AiChatSession selectAiChatSessionById(Long id);

    /**
     * 查询聊天会话状态列表
     * 
     * @param aiChatSession 聊天会话状态
     * @return 聊天会话状态集合
     */
    public List<AiChatSession> selectAiChatSessionList(AiChatSession aiChatSession);

    /**
     * 新增聊天会话状态
     * 
     * @param aiChatSession 聊天会话状态
     * @return 结果
     */
    public int insertAiChatSession(AiChatSession aiChatSession);

    /**
     * 修改聊天会话状态
     * 
     * @param aiChatSession 聊天会话状态
     * @return 结果
     */
    public int updateAiChatSession(AiChatSession aiChatSession);

    /**
     * 删除聊天会话状态
     * 
     * @param id 聊天会话状态主键
     * @return 结果
     */
    public int deleteAiChatSessionById(Long id);

    /**
     * 批量删除聊天会话状态
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAiChatSessionByIds(Long[] ids);
}
