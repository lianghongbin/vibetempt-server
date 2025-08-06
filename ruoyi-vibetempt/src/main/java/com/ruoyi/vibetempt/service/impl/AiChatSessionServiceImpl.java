package com.ruoyi.vibetempt.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.vibetempt.mapper.AiChatSessionMapper;
import com.ruoyi.vibetempt.domain.AiChatSession;
import com.ruoyi.vibetempt.service.AiChatSessionService;

/**
 * 聊天会话状态Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
@Service
public class AiChatSessionServiceImpl implements AiChatSessionService 
{
    @Autowired
    private AiChatSessionMapper aiChatSessionMapper;

    /**
     * 查询聊天会话状态
     * 
     * @param id 聊天会话状态主键
     * @return 聊天会话状态
     */
    @Override
    public AiChatSession selectAiChatSessionById(Long id)
    {
        return aiChatSessionMapper.selectAiChatSessionById(id);
    }

    /**
     * 查询聊天会话状态列表
     * 
     * @param aiChatSession 聊天会话状态
     * @return 聊天会话状态
     */
    @Override
    public List<AiChatSession> selectAiChatSessionList(AiChatSession aiChatSession)
    {
        return aiChatSessionMapper.selectAiChatSessionList(aiChatSession);
    }

    /**
     * 新增聊天会话状态
     * 
     * @param aiChatSession 聊天会话状态
     * @return 结果
     */
    @Override
    public int insertAiChatSession(AiChatSession aiChatSession)
    {
        aiChatSession.setCreateTime(DateUtils.getNowDate());
        return aiChatSessionMapper.insertAiChatSession(aiChatSession);
    }

    /**
     * 修改聊天会话状态
     * 
     * @param aiChatSession 聊天会话状态
     * @return 结果
     */
    @Override
    public int updateAiChatSession(AiChatSession aiChatSession)
    {
        aiChatSession.setUpdateTime(DateUtils.getNowDate());
        return aiChatSessionMapper.updateAiChatSession(aiChatSession);
    }

    /**
     * 批量删除聊天会话状态
     * 
     * @param ids 需要删除的聊天会话状态主键
     * @return 结果
     */
    @Override
    public int deleteAiChatSessionByIds(Long[] ids)
    {
        return aiChatSessionMapper.deleteAiChatSessionByIds(ids);
    }

    /**
     * 删除聊天会话状态信息
     * 
     * @param id 聊天会话状态主键
     * @return 结果
     */
    @Override
    public int deleteAiChatSessionById(Long id)
    {
        return aiChatSessionMapper.deleteAiChatSessionById(id);
    }
}
