package com.ruoyi.vibetempt.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 消息对象 ai_message
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
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
    @Excel(name = "消息类型")
    private String messageType;

    /** 使用的Token数 */
    @Excel(name = "使用的Token数")
    private Integer tokensUsed;

    /** 使用的模型 */
    @Excel(name = "使用的模型")
    private String modelUsed;

    /** 情感上下文 */
    @Excel(name = "情感上下文")
    private Object emotionalContext;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;
}
