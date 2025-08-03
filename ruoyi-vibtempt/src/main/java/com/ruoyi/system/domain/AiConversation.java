package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 对话会话对象 ai_conversation
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
public class AiConversation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 会话ID */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 角色ID */
    @Excel(name = "角色ID")
    private Long characterId;

    /** 会话标题 */
    @Excel(name = "会话标题")
    private String title;

    /** 会话描述 */
    @Excel(name = "会话描述")
    private String description;

    /** 状态：active-活跃,paused-暂停,ended-结束 */
    @Excel(name = "状态：active-活跃,paused-暂停,ended-结束")
    private String status;

    /** 消息数量 */
    @Excel(name = "消息数量")
    private Long messageCount;

    /** 总Token数 */
    @Excel(name = "总Token数")
    private Long totalTokens;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 最后消息时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后消息时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastMessageTime;

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

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setMessageCount(Long messageCount) 
    {
        this.messageCount = messageCount;
    }

    public Long getMessageCount() 
    {
        return messageCount;
    }

    public void setTotalTokens(Long totalTokens) 
    {
        this.totalTokens = totalTokens;
    }

    public Long getTotalTokens() 
    {
        return totalTokens;
    }

    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }

    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }

    public void setLastMessageTime(Date lastMessageTime) 
    {
        this.lastMessageTime = lastMessageTime;
    }

    public Date getLastMessageTime() 
    {
        return lastMessageTime;
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
            .append("title", getTitle())
            .append("description", getDescription())
            .append("status", getStatus())
            .append("messageCount", getMessageCount())
            .append("totalTokens", getTotalTokens())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("lastMessageTime", getLastMessageTime())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
