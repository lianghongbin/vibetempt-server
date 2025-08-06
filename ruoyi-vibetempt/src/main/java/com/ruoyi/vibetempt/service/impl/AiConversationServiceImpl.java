package com.ruoyi.vibetempt.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.vibetempt.mapper.AiConversationMapper;
import com.ruoyi.vibetempt.domain.AiConversation;
import com.ruoyi.vibetempt.service.AiConversationService;

/**
 * 对话会话Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
@Service
public class AiConversationServiceImpl implements AiConversationService 
{
    @Autowired
    private AiConversationMapper aiConversationMapper;

    /**
     * 查询对话会话
     * 
     * @param id 对话会话主键
     * @return 对话会话
     */
    @Override
    public AiConversation selectAiConversationById(Long id)
    {
        return aiConversationMapper.selectAiConversationById(id);
    }

    /**
     * 查询对话会话列表
     * 
     * @param aiConversation 对话会话
     * @return 对话会话
     */
    @Override
    public List<AiConversation> selectAiConversationList(AiConversation aiConversation)
    {
        return aiConversationMapper.selectAiConversationList(aiConversation);
    }

    /**
     * 新增对话会话
     * 
     * @param aiConversation 对话会话
     * @return 结果
     */
    @Override
    public int insertAiConversation(AiConversation aiConversation)
    {
        aiConversation.setCreateTime(DateUtils.getNowDate());
        return aiConversationMapper.insertAiConversation(aiConversation);
    }

    /**
     * 修改对话会话
     * 
     * @param aiConversation 对话会话
     * @return 结果
     */
    @Override
    public int updateAiConversation(AiConversation aiConversation)
    {
        aiConversation.setUpdateTime(DateUtils.getNowDate());
        return aiConversationMapper.updateAiConversation(aiConversation);
    }

    /**
     * 批量删除对话会话
     * 
     * @param ids 需要删除的对话会话主键
     * @return 结果
     */
    @Override
    public int deleteAiConversationByIds(Long[] ids)
    {
        return aiConversationMapper.deleteAiConversationByIds(ids);
    }

    /**
     * 删除对话会话信息
     * 
     * @param id 对话会话主键
     * @return 结果
     */
    @Override
    public int deleteAiConversationById(Long id)
    {
        return aiConversationMapper.deleteAiConversationById(id);
    }
}
