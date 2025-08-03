package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 角色记忆对象 ai_character_memory
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
public class AiCharacterMemory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记忆ID */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 角色ID */
    @Excel(name = "角色ID")
    private Long characterId;

    /** 记忆类型：basic_info-基本信息,preferences-偏好设置,important_events-重要事件,shared_moments-共同回忆,emotional_state-情感状态 */
    @Excel(name = "记忆类型：basic_info-基本信息,preferences-偏好设置,important_events-重要事件,shared_moments-共同回忆,emotional_state-情感状态")
    private String memoryType;

    /** 记忆键 */
    @Excel(name = "记忆键")
    private String memoryKey;

    /** 记忆值 */
    @Excel(name = "记忆值")
    private String memoryValue;

    /** 重要程度(1-5) */
    @Excel(name = "重要程度(1-5)")
    private Long importanceLevel;

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

    public void setMemoryType(String memoryType) 
    {
        this.memoryType = memoryType;
    }

    public String getMemoryType() 
    {
        return memoryType;
    }

    public void setMemoryKey(String memoryKey) 
    {
        this.memoryKey = memoryKey;
    }

    public String getMemoryKey() 
    {
        return memoryKey;
    }

    public void setMemoryValue(String memoryValue) 
    {
        this.memoryValue = memoryValue;
    }

    public String getMemoryValue() 
    {
        return memoryValue;
    }

    public void setImportanceLevel(Long importanceLevel) 
    {
        this.importanceLevel = importanceLevel;
    }

    public Long getImportanceLevel() 
    {
        return importanceLevel;
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
            .append("memoryType", getMemoryType())
            .append("memoryKey", getMemoryKey())
            .append("memoryValue", getMemoryValue())
            .append("importanceLevel", getImportanceLevel())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
