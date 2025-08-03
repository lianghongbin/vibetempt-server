package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 聊天会话状态对象 ai_chat_session
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
public class AiChatSession extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 会话状态ID */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 角色ID */
    @Excel(name = "角色ID")
    private Long characterId;

    /** 是否活跃 */
    @Excel(name = "是否活跃")
    private Integer isActive;

    /** 当前会话ID */
    @Excel(name = "当前会话ID")
    private Long currentConversationId;

    /** 上下文数据 */
    @Excel(name = "上下文数据")
    private String contextData;

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

    public void setIsActive(Integer isActive) 
    {
        this.isActive = isActive;
    }

    public Integer getIsActive() 
    {
        return isActive;
    }

    public void setCurrentConversationId(Long currentConversationId) 
    {
        this.currentConversationId = currentConversationId;
    }

    public Long getCurrentConversationId() 
    {
        return currentConversationId;
    }

    public void setContextData(String contextData) 
    {
        this.contextData = contextData;
    }

    public String getContextData() 
    {
        return contextData;
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
            .append("isActive", getIsActive())
            .append("currentConversationId", getCurrentConversationId())
            .append("contextData", getContextData())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
