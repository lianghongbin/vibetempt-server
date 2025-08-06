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
import com.ruoyi.vibetempt.domain.AiChatAnalytics;
import com.ruoyi.vibetempt.service.AiChatAnalyticsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 聊天统计Controller
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
@RestController
@RequestMapping("/vibetempt/analytics")
public class AiChatAnalyticsController extends BaseController
{
    @Autowired
    private AiChatAnalyticsService aiChatAnalyticsService;

    /**
     * 查询聊天统计列表
     */
    @PreAuthorize("@ss.hasPermi('vibetempt:analytics:list')")
    @GetMapping("/list")
    public TableDataInfo list(AiChatAnalytics aiChatAnalytics)
    {
        startPage();
        List<AiChatAnalytics> list = aiChatAnalyticsService.selectAiChatAnalyticsList(aiChatAnalytics);
        return getDataTable(list);
    }

    /**
     * 导出聊天统计列表
     */
    @PreAuthorize("@ss.hasPermi('vibetempt:analytics:export')")
    @Log(title = "聊天统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AiChatAnalytics aiChatAnalytics)
    {
        List<AiChatAnalytics> list = aiChatAnalyticsService.selectAiChatAnalyticsList(aiChatAnalytics);
        ExcelUtil<AiChatAnalytics> util = new ExcelUtil<AiChatAnalytics>(AiChatAnalytics.class);
        util.exportExcel(response, list, "聊天统计数据");
    }

    /**
     * 获取聊天统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('vibetempt:analytics:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(aiChatAnalyticsService.selectAiChatAnalyticsById(id));
    }

    /**
     * 新增聊天统计
     */
    @PreAuthorize("@ss.hasPermi('vibetempt:analytics:add')")
    @Log(title = "聊天统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AiChatAnalytics aiChatAnalytics)
    {
        return toAjax(aiChatAnalyticsService.insertAiChatAnalytics(aiChatAnalytics));
    }

    /**
     * 修改聊天统计
     */
    @PreAuthorize("@ss.hasPermi('vibetempt:analytics:edit')")
    @Log(title = "聊天统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AiChatAnalytics aiChatAnalytics)
    {
        return toAjax(aiChatAnalyticsService.updateAiChatAnalytics(aiChatAnalytics));
    }

    /**
     * 删除聊天统计
     */
    @PreAuthorize("@ss.hasPermi('vibetempt:analytics:remove')")
    @Log(title = "聊天统计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(aiChatAnalyticsService.deleteAiChatAnalyticsByIds(ids));
    }
}
