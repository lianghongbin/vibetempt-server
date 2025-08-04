package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 聊天统计对象 ai_chat_analytics
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AiChatAnalytics extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 统计ID */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 角色ID */
    @Excel(name = "角色ID")
    private Long characterId;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 消息数量 */
    @Excel(name = "消息数量")
    private Integer messageCount;

    /** 会话数量 */
    @Excel(name = "会话数量")
    private Integer conversationCount;

    /** 总时长（分钟） */
    @Excel(name = "总时长（分钟）")
    private Integer totalDuration;

    /** 使用的Token数 */
    @Excel(name = "使用的Token数")
    private Integer tokensUsed;

    /** 平均情感分数 */
    @Excel(name = "平均情感分数")
    private BigDecimal averageSentiment;

    /** 主导情感 */
    @Excel(name = "主导情感")
    private String dominantEmotion;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;
}
