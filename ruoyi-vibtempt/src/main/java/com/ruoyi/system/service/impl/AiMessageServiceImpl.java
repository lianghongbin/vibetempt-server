package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AiMessageMapper;
import com.ruoyi.system.domain.AiMessage;
import com.ruoyi.system.service.IAiMessageService;

/**
 * 消息Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
@Service
public class AiMessageServiceImpl implements IAiMessageService 
{
    @Autowired
    private AiMessageMapper aiMessageMapper;

    /**
     * 查询消息
     * 
     * @param id 消息主键
     * @return 消息
     */
    @Override
    public AiMessage selectAiMessageById(Long id)
    {
        return aiMessageMapper.selectAiMessageById(id);
    }

    /**
     * 查询消息列表
     * 
     * @param aiMessage 消息
     * @return 消息
     */
    @Override
    public List<AiMessage> selectAiMessageList(AiMessage aiMessage)
    {
        return aiMessageMapper.selectAiMessageList(aiMessage);
    }

    /**
     * 新增消息
     * 
     * @param aiMessage 消息
     * @return 结果
     */
    @Override
    public int insertAiMessage(AiMessage aiMessage)
    {
        aiMessage.setCreateTime(DateUtils.getNowDate());
        return aiMessageMapper.insertAiMessage(aiMessage);
    }

    /**
     * 修改消息
     * 
     * @param aiMessage 消息
     * @return 结果
     */
    @Override
    public int updateAiMessage(AiMessage aiMessage)
    {
        aiMessage.setUpdateTime(DateUtils.getNowDate());
        return aiMessageMapper.updateAiMessage(aiMessage);
    }

    /**
     * 批量删除消息
     * 
     * @param ids 需要删除的消息主键
     * @return 结果
     */
    @Override
    public int deleteAiMessageByIds(Long[] ids)
    {
        return aiMessageMapper.deleteAiMessageByIds(ids);
    }

    /**
     * 删除消息信息
     * 
     * @param id 消息主键
     * @return 结果
     */
    @Override
    public int deleteAiMessageById(Long id)
    {
        return aiMessageMapper.deleteAiMessageById(id);
    }
}
