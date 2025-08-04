package com.ruoyi.system.controller;

import java.util.List;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.AiChatSession;
import com.ruoyi.system.service.AiChatSessionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 聊天会话状态Controller
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
@RestController
@RequestMapping("/system/session")
public class AiChatSessionController extends BaseController
{
    @Autowired
    private AiChatSessionService aiChatSessionService;

    /**
     * 查询聊天会话状态列表
     */
    @PreAuthorize("@ss.hasPermi('system:session:list')")
    @GetMapping("/list")
    public TableDataInfo list(AiChatSession aiChatSession)
    {
        startPage();
        List<AiChatSession> list = aiChatSessionService.selectAiChatSessionList(aiChatSession);
        return getDataTable(list);
    }

    /**
     * 导出聊天会话状态列表
     */
    @PreAuthorize("@ss.hasPermi('system:session:export')")
    @Log(title = "聊天会话状态", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AiChatSession aiChatSession)
    {
        List<AiChatSession> list = aiChatSessionService.selectAiChatSessionList(aiChatSession);
        ExcelUtil<AiChatSession> util = new ExcelUtil<AiChatSession>(AiChatSession.class);
        util.exportExcel(response, list, "聊天会话状态数据");
    }

    /**
     * 获取聊天会话状态详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:session:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(aiChatSessionService.selectAiChatSessionById(id));
    }

    /**
     * 新增聊天会话状态
     */
    @PreAuthorize("@ss.hasPermi('system:session:add')")
    @Log(title = "聊天会话状态", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AiChatSession aiChatSession)
    {
        return toAjax(aiChatSessionService.insertAiChatSession(aiChatSession));
    }

    /**
     * 修改聊天会话状态
     */
    @PreAuthorize("@ss.hasPermi('system:session:edit')")
    @Log(title = "聊天会话状态", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AiChatSession aiChatSession)
    {
        return toAjax(aiChatSessionService.updateAiChatSession(aiChatSession));
    }

    /**
     * 删除聊天会话状态
     */
    @PreAuthorize("@ss.hasPermi('system:session:remove')")
    @Log(title = "聊天会话状态", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(aiChatSessionService.deleteAiChatSessionByIds(ids));
    }
}
