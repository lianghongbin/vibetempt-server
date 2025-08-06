package com.ruoyi.vibetempt.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.vibetempt.mapper.AiChatAnalyticsMapper;
import com.ruoyi.vibetempt.domain.AiChatAnalytics;
import com.ruoyi.vibetempt.service.AiChatAnalyticsService;

/**
 * 聊天统计Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
@Service
public class AiChatAnalyticsServiceImpl implements AiChatAnalyticsService 
{
    @Autowired
    private AiChatAnalyticsMapper aiChatAnalyticsMapper;

    /**
     * 查询聊天统计
     * 
     * @param id 聊天统计主键
     * @return 聊天统计
     */
    @Override
    public AiChatAnalytics selectAiChatAnalyticsById(Long id)
    {
        return aiChatAnalyticsMapper.selectAiChatAnalyticsById(id);
    }

    /**
     * 查询聊天统计列表
     * 
     * @param aiChatAnalytics 聊天统计
     * @return 聊天统计
     */
    @Override
    public List<AiChatAnalytics> selectAiChatAnalyticsList(AiChatAnalytics aiChatAnalytics)
    {
        return aiChatAnalyticsMapper.selectAiChatAnalyticsList(aiChatAnalytics);
    }

    /**
     * 新增聊天统计
     * 
     * @param aiChatAnalytics 聊天统计
     * @return 结果
     */
    @Override
    public int insertAiChatAnalytics(AiChatAnalytics aiChatAnalytics)
    {
        aiChatAnalytics.setCreateTime(DateUtils.getNowDate());
        return aiChatAnalyticsMapper.insertAiChatAnalytics(aiChatAnalytics);
    }

    /**
     * 修改聊天统计
     * 
     * @param aiChatAnalytics 聊天统计
     * @return 结果
     */
    @Override
    public int updateAiChatAnalytics(AiChatAnalytics aiChatAnalytics)
    {
        aiChatAnalytics.setUpdateTime(DateUtils.getNowDate());
        return aiChatAnalyticsMapper.updateAiChatAnalytics(aiChatAnalytics);
    }

    /**
     * 批量删除聊天统计
     * 
     * @param ids 需要删除的聊天统计主键
     * @return 结果
     */
    @Override
    public int deleteAiChatAnalyticsByIds(Long[] ids)
    {
        return aiChatAnalyticsMapper.deleteAiChatAnalyticsByIds(ids);
    }

    /**
     * 删除聊天统计信息
     * 
     * @param id 聊天统计主键
     * @return 结果
     */
    @Override
    public int deleteAiChatAnalyticsById(Long id)
    {
        return aiChatAnalyticsMapper.deleteAiChatAnalyticsById(id);
    }
}
