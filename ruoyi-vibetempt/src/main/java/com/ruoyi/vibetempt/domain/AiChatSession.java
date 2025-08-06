package com.ruoyi.vibetempt.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 聊天会话状态对象 ai_chat_session
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
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
    private Boolean isActive;

    /** 当前会话ID */
    @Excel(name = "当前会话ID")
    private Long currentConversationId;

    /** 上下文数据 */
    @Excel(name = "上下文数据")
    private Object contextData;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;
}
