package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户角色关系对象 ai_user_character_relation
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
public class AiUserCharacterRelation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 关系ID */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 角色ID */
    @Excel(name = "角色ID")
    private Long characterId;

    /** 关系等级(1-10) */
    @Excel(name = "关系等级(1-10)")
    private Long relationshipLevel;

    /** 情感状态 */
    @Excel(name = "情感状态")
    private String emotionalState;

    /** 信任度(1-10) */
    @Excel(name = "信任度(1-10)")
    private Long trustLevel;

    /** 总互动次数 */
    @Excel(name = "总互动次数")
    private Long totalInteractions;

    /** 总消息数 */
    @Excel(name = "总消息数")
    private Long totalMessages;

    /** 首次互动时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "首次互动时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date firstInteractionTime;

    /** 最后互动时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后互动时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastInteractionTime;

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

    public void setRelationshipLevel(Long relationshipLevel) 
    {
        this.relationshipLevel = relationshipLevel;
    }

    public Long getRelationshipLevel() 
    {
        return relationshipLevel;
    }

    public void setEmotionalState(String emotionalState) 
    {
        this.emotionalState = emotionalState;
    }

    public String getEmotionalState() 
    {
        return emotionalState;
    }

    public void setTrustLevel(Long trustLevel) 
    {
        this.trustLevel = trustLevel;
    }

    public Long getTrustLevel() 
    {
        return trustLevel;
    }

    public void setTotalInteractions(Long totalInteractions) 
    {
        this.totalInteractions = totalInteractions;
    }

    public Long getTotalInteractions() 
    {
        return totalInteractions;
    }

    public void setTotalMessages(Long totalMessages) 
    {
        this.totalMessages = totalMessages;
    }

    public Long getTotalMessages() 
    {
        return totalMessages;
    }

    public void setFirstInteractionTime(Date firstInteractionTime) 
    {
        this.firstInteractionTime = firstInteractionTime;
    }

    public Date getFirstInteractionTime() 
    {
        return firstInteractionTime;
    }

    public void setLastInteractionTime(Date lastInteractionTime) 
    {
        this.lastInteractionTime = lastInteractionTime;
    }

    public Date getLastInteractionTime() 
    {
        return lastInteractionTime;
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
            .append("relationshipLevel", getRelationshipLevel())
            .append("emotionalState", getEmotionalState())
            .append("trustLevel", getTrustLevel())
            .append("totalInteractions", getTotalInteractions())
            .append("totalMessages", getTotalMessages())
            .append("firstInteractionTime", getFirstInteractionTime())
            .append("lastInteractionTime", getLastInteractionTime())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
