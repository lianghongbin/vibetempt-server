package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色记忆对象 ai_character_memory
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
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
    private Object memoryValue;

    /** 重要程度(1-5) */
    @Excel(name = "重要程度(1-5)")
    private Integer importanceLevel;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;
}
