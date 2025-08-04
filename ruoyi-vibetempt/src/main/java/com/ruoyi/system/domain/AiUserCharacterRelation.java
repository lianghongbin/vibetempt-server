package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 用户角色关系对象 ai_user_character_relation
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
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
    private Integer relationshipLevel;

    /** 情感状态 */
    @Excel(name = "情感状态")
    private String emotionalState;

    /** 信任度(1-10) */
    @Excel(name = "信任度(1-10)")
    private Integer trustLevel;

    /** 总互动次数 */
    @Excel(name = "总互动次数")
    private Integer totalInteractions;

    /** 总消息数 */
    @Excel(name = "总消息数")
    private Integer totalMessages;

    /** 首次互动时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "首次互动时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date firstInteractionTime;

    /** 最后互动时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "最后互动时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date lastInteractionTime;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;
}
