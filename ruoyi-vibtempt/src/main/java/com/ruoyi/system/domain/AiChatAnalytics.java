package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 聊天统计对象 ai_chat_analytics
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
public class AiChatAnalytics extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 统计ID */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 角色ID */
    @Excel(name = "角色ID")
    private Long characterId;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 消息数量 */
    @Excel(name = "消息数量")
    private Long messageCount;

    /** 对话数量 */
    @Excel(name = "对话数量")
    private Long conversationCount;

    /** 总时长(分钟) */
    @Excel(name = "总时长(分钟)")
    private Long totalDuration;

    /** Token使用量 */
    @Excel(name = "Token使用量")
    private Long tokensUsed;

    /** 平均情感值 */
    @Excel(name = "平均情感值")
    private BigDecimal averageSentiment;

    /** 主要情感 */
    @Excel(name = "主要情感")
    private String dominantEmotion;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setCharacterId(Long characterId) 
    {
        this.characterId = characterId;
    }

    public Long getCharacterId() 
    {
        return characterId;
    }

    public void setDate(Date date) 
    {
        this.date = date;
    }

    public Date getDate() 
    {
        return date;
    }

    public void setMessageCount(Long messageCount) 
    {
        this.messageCount = messageCount;
    }

    public Long getMessageCount() 
    {
        return messageCount;
    }

    public void setConversationCount(Long conversationCount) 
    {
        this.conversationCount = conversationCount;
    }

    public Long getConversationCount() 
    {
        return conversationCount;
    }

    public void setTotalDuration(Long totalDuration) 
    {
        this.totalDuration = totalDuration;
    }

    public Long getTotalDuration() 
    {
        return totalDuration;
    }

    public void setTokensUsed(Long tokensUsed) 
    {
        this.tokensUsed = tokensUsed;
    }

    public Long getTokensUsed() 
    {
        return tokensUsed;
    }

    public void setAverageSentiment(BigDecimal averageSentiment) 
    {
        this.averageSentiment = averageSentiment;
    }

    public BigDecimal getAverageSentiment() 
    {
        return averageSentiment;
    }

    public void setDominantEmotion(String dominantEmotion) 
    {
        this.dominantEmotion = dominantEmotion;
    }

    public String getDominantEmotion() 
    {
        return dominantEmotion;
    }

    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("characterId", getCharacterId())
            .append("date", getDate())
            .append("messageCount", getMessageCount())
            .append("conversationCount", getConversationCount())
            .append("totalDuration", getTotalDuration())
            .append("tokensUsed", getTokensUsed())
            .append("averageSentiment", getAverageSentiment())
            .append("dominantEmotion", getDominantEmotion())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
