package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * AI角色对象 ai_character
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
public class AiCharacter extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 角色ID */
    private Long id;

    /** 角色名称 */
    @Excel(name = "角色名称")
    private String name;

    /** 角色描述 */
    @Excel(name = "角色描述")
    private String description;

    /** 性格设定 */
    @Excel(name = "性格设定")
    private String personality;

    /** 头像URL */
    @Excel(name = "头像URL")
    private String avatarUrl;

    /** 角色类型：girlfriend-女友,friend-朋友,mentor-导师,assistant-助手 */
    @Excel(name = "角色类型：girlfriend-女友,friend-朋友,mentor-导师,assistant-助手")
    private String characterType;

    /** 创建者ID */
    @Excel(name = "创建者ID")
    private Long creatorId;

    /** 是否激活 */
    @Excel(name = "是否激活")
    private Integer isActive;

    /** 是否公开 */
    @Excel(name = "是否公开")
    private Integer isPublic;

    /** 使用用户数 */
    @Excel(name = "使用用户数")
    private Long totalUsers;

    /** 总对话数 */
    @Excel(name = "总对话数")
    private Long totalConversations;

    /** 总消息数 */
    @Excel(name = "总消息数")
    private Long totalMessages;

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

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setPersonality(String personality) 
    {
        this.personality = personality;
    }

    public String getPersonality() 
    {
        return personality;
    }

    public void setAvatarUrl(String avatarUrl) 
    {
        this.avatarUrl = avatarUrl;
    }

    public String getAvatarUrl() 
    {
        return avatarUrl;
    }

    public void setCharacterType(String characterType) 
    {
        this.characterType = characterType;
    }

    public String getCharacterType() 
    {
        return characterType;
    }

    public void setCreatorId(Long creatorId) 
    {
        this.creatorId = creatorId;
    }

    public Long getCreatorId() 
    {
        return creatorId;
    }

    public void setIsActive(Integer isActive) 
    {
        this.isActive = isActive;
    }

    public Integer getIsActive() 
    {
        return isActive;
    }

    public void setIsPublic(Integer isPublic) 
    {
        this.isPublic = isPublic;
    }

    public Integer getIsPublic() 
    {
        return isPublic;
    }

    public void setTotalUsers(Long totalUsers) 
    {
        this.totalUsers = totalUsers;
    }

    public Long getTotalUsers() 
    {
        return totalUsers;
    }

    public void setTotalConversations(Long totalConversations) 
    {
        this.totalConversations = totalConversations;
    }

    public Long getTotalConversations() 
    {
        return totalConversations;
    }

    public void setTotalMessages(Long totalMessages) 
    {
        this.totalMessages = totalMessages;
    }

    public Long getTotalMessages() 
    {
        return totalMessages;
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
            .append("name", getName())
            .append("description", getDescription())
            .append("personality", getPersonality())
            .append("avatarUrl", getAvatarUrl())
            .append("characterType", getCharacterType())
            .append("creatorId", getCreatorId())
            .append("isActive", getIsActive())
            .append("isPublic", getIsPublic())
            .append("totalUsers", getTotalUsers())
            .append("totalConversations", getTotalConversations())
            .append("totalMessages", getTotalMessages())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
