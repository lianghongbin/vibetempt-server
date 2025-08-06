package com.ruoyi.vibetempt.controller;

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
import com.ruoyi.vibetempt.domain.AiConversation;
import com.ruoyi.vibetempt.service.AiConversationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 对话会话Controller
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
@RestController
@RequestMapping("/vibetempt/conversation")
public class AiConversationController extends BaseController
{
    @Autowired
    private AiConversationService aiConversationService;

    /**
     * 查询对话会话列表
     */
    @PreAuthorize("@ss.hasPermi('vibetempt:conversation:list')")
    @GetMapping("/list")
    public TableDataInfo list(AiConversation aiConversation)
    {
        startPage();
        List<AiConversation> list = aiConversationService.selectAiConversationList(aiConversation);
        return getDataTable(list);
    }

    /**
     * 导出对话会话列表
     */
    @PreAuthorize("@ss.hasPermi('vibetempt:conversation:export')")
    @Log(title = "对话会话", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AiConversation aiConversation)
    {
        List<AiConversation> list = aiConversationService.selectAiConversationList(aiConversation);
        ExcelUtil<AiConversation> util = new ExcelUtil<AiConversation>(AiConversation.class);
        util.exportExcel(response, list, "对话会话数据");
    }

    /**
     * 获取对话会话详细信息
     */
    @PreAuthorize("@ss.hasPermi('vibetempt:conversation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(aiConversationService.selectAiConversationById(id));
    }

    /**
     * 新增对话会话
     */
    @PreAuthorize("@ss.hasPermi('vibetempt:conversation:add')")
    @Log(title = "对话会话", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AiConversation aiConversation)
    {
        return toAjax(aiConversationService.insertAiConversation(aiConversation));
    }

    /**
     * 修改对话会话
     */
    @PreAuthorize("@ss.hasPermi('vibetempt:conversation:edit')")
    @Log(title = "对话会话", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AiConversation aiConversation)
    {
        return toAjax(aiConversationService.updateAiConversation(aiConversation));
    }

    /**
     * 删除对话会话
     */
    @PreAuthorize("@ss.hasPermi('vibetempt:conversation:remove')")
    @Log(title = "对话会话", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(aiConversationService.deleteAiConversationByIds(ids));
    }
}
