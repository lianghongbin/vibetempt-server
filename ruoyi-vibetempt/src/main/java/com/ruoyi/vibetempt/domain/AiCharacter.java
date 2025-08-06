package com.ruoyi.vibetempt.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * AI角色对象 ai_character
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AiCharacter extends BaseEntity
{
    @Serial
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
    private boolean isActive;

    /** 是否公开 */
    @Excel(name = "是否公开")
    private boolean isPublic;

    /** 使用用户数 */
    @Excel(name = "使用用户数")
    private Integer totalUsers;

    /** 总对话数 */
    @Excel(name = "总对话数")
    private Integer totalConversations;

    /** 总消息数 */
    @Excel(name = "总消息数")
    private Integer totalMessages;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;
}
