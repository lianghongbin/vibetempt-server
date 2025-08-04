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
import com.ruoyi.system.domain.AiMessage;
import com.ruoyi.system.service.AiMessageService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 消息Controller
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
@RestController
@RequestMapping("/system/message")
public class AiMessageController extends BaseController
{
    @Autowired
    private AiMessageService aiMessageService;

    /**
     * 查询消息列表
     */
    @PreAuthorize("@ss.hasPermi('system:message:list')")
    @GetMapping("/list")
    public TableDataInfo list(AiMessage aiMessage)
    {
        startPage();
        List<AiMessage> list = aiMessageService.selectAiMessageList(aiMessage);
        return getDataTable(list);
    }

    /**
     * 导出消息列表
     */
    @PreAuthorize("@ss.hasPermi('system:message:export')")
    @Log(title = "消息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AiMessage aiMessage)
    {
        List<AiMessage> list = aiMessageService.selectAiMessageList(aiMessage);
        ExcelUtil<AiMessage> util = new ExcelUtil<AiMessage>(AiMessage.class);
        util.exportExcel(response, list, "消息数据");
    }

    /**
     * 获取消息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:message:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(aiMessageService.selectAiMessageById(id));
    }

    /**
     * 新增消息
     */
    @PreAuthorize("@ss.hasPermi('system:message:add')")
    @Log(title = "消息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AiMessage aiMessage)
    {
        return toAjax(aiMessageService.insertAiMessage(aiMessage));
    }

    /**
     * 修改消息
     */
    @PreAuthorize("@ss.hasPermi('system:message:edit')")
    @Log(title = "消息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AiMessage aiMessage)
    {
        return toAjax(aiMessageService.updateAiMessage(aiMessage));
    }

    /**
     * 删除消息
     */
    @PreAuthorize("@ss.hasPermi('system:message:remove')")
    @Log(title = "消息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(aiMessageService.deleteAiMessageByIds(ids));
    }
}
