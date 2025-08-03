package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 消息对象 ai_message
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
public class AiMessage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 消息ID */
    private Long id;

    /** 会话ID */
    @Excel(name = "会话ID")
    private Long conversationId;

    /** 消息内容 */
    @Excel(name = "消息内容")
    private String content;

    /** 消息类型：user-用户,ai-AI,system-系统 */
    @Excel(name = "消息类型：user-用户,ai-AI,system-系统")
    private String messageType;

    /** 使用的Token数 */
    @Excel(name = "使用的Token数")
    private Long tokensUsed;

    /** 使用的模型 */
    @Excel(name = "使用的模型")
    private String modelUsed;

    /** 情感上下文 */
    @Excel(name = "情感上下文")
    private String emotionalContext;

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

    public void setConversationId(Long conversationId) 
    {
        this.conversationId = conversationId;
    }

    public Long getConversationId() 
    {
        return conversationId;
    }

    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    public void setMessageType(String messageType) 
    {
        this.messageType = messageType;
    }

    public String getMessageType() 
    {
        return messageType;
    }

    public void setTokensUsed(Long tokensUsed) 
    {
        this.tokensUsed = tokensUsed;
    }

    public Long getTokensUsed() 
    {
        return tokensUsed;
    }

    public void setModelUsed(String modelUsed) 
    {
        this.modelUsed = modelUsed;
    }

    public String getModelUsed() 
    {
        return modelUsed;
    }

    public void setEmotionalContext(String emotionalContext) 
    {
        this.emotionalContext = emotionalContext;
    }

    public String getEmotionalContext() 
    {
        return emotionalContext;
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
            .append("conversationId", getConversationId())
            .append("content", getContent())
            .append("messageType", getMessageType())
            .append("tokensUsed", getTokensUsed())
            .append("modelUsed", getModelUsed())
            .append("emotionalContext", getEmotionalContext())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
