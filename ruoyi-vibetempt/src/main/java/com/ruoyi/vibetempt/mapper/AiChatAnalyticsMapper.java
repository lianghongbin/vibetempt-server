package com.ruoyi.vibetempt.mapper;

import java.util.List;
import com.ruoyi.vibetempt.domain.AiChatAnalytics;

/**
 * 聊天统计Mapper接口
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
public interface AiChatAnalyticsMapper 
{
    /**
     * 查询聊天统计
     * 
     * @param id 聊天统计主键
     * @return 聊天统计
     */
    public AiChatAnalytics selectAiChatAnalyticsById(Long id);

    /**
     * 查询聊天统计列表
     * 
     * @param aiChatAnalytics 聊天统计
     * @return 聊天统计集合
     */
    public List<AiChatAnalytics> selectAiChatAnalyticsList(AiChatAnalytics aiChatAnalytics);

    /**
     * 新增聊天统计
     * 
     * @param aiChatAnalytics 聊天统计
     * @return 结果
     */
    public int insertAiChatAnalytics(AiChatAnalytics aiChatAnalytics);

    /**
     * 修改聊天统计
     * 
     * @param aiChatAnalytics 聊天统计
     * @return 结果
     */
    public int updateAiChatAnalytics(AiChatAnalytics aiChatAnalytics);

    /**
     * 删除聊天统计
     * 
     * @param id 聊天统计主键
     * @return 结果
     */
    public int deleteAiChatAnalyticsById(Long id);

    /**
     * 批量删除聊天统计
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAiChatAnalyticsByIds(Long[] ids);
}
