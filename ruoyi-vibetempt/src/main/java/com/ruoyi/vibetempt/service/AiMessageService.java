package com.ruoyi.vibetempt.service;

import java.util.List;
import com.ruoyi.vibetempt.domain.AiMessage;

/**
 * 消息Service接口
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
public interface AiMessageService 
{
    /**
     * 查询消息
     * 
     * @param id 消息主键
     * @return 消息
     */
    public AiMessage selectAiMessageById(Long id);

    /**
     * 查询消息列表
     * 
     * @param aiMessage 消息
     * @return 消息集合
     */
    public List<AiMessage> selectAiMessageList(AiMessage aiMessage);

    /**
     * 新增消息
     * 
     * @param aiMessage 消息
     * @return 结果
     */
    public int insertAiMessage(AiMessage aiMessage);

    /**
     * 修改消息
     * 
     * @param aiMessage 消息
     * @return 结果
     */
    public int updateAiMessage(AiMessage aiMessage);

    /**
     * 批量删除消息
     * 
     * @param ids 需要删除的消息主键集合
     * @return 结果
     */
    public int deleteAiMessageByIds(Long[] ids);

    /**
     * 删除消息信息
     * 
     * @param id 消息主键
     * @return 结果
     */
    public int deleteAiMessageById(Long id);
}
