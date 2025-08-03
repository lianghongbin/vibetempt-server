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
import com.ruoyi.system.domain.AiCharacterMemory;
import com.ruoyi.system.service.IAiCharacterMemoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 角色记忆Controller
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
@RestController
@RequestMapping("/system/memory")
public class AiCharacterMemoryController extends BaseController
{
    @Autowired
    private IAiCharacterMemoryService aiCharacterMemoryService;

    /**
     * 查询角色记忆列表
     */
    @PreAuthorize("@ss.hasPermi('system:memory:list')")
    @GetMapping("/list")
    public TableDataInfo list(AiCharacterMemory aiCharacterMemory)
    {
        startPage();
        List<AiCharacterMemory> list = aiCharacterMemoryService.selectAiCharacterMemoryList(aiCharacterMemory);
        return getDataTable(list);
    }

    /**
     * 导出角色记忆列表
     */
    @PreAuthorize("@ss.hasPermi('system:memory:export')")
    @Log(title = "角色记忆", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AiCharacterMemory aiCharacterMemory)
    {
        List<AiCharacterMemory> list = aiCharacterMemoryService.selectAiCharacterMemoryList(aiCharacterMemory);
        ExcelUtil<AiCharacterMemory> util = new ExcelUtil<AiCharacterMemory>(AiCharacterMemory.class);
        util.exportExcel(response, list, "角色记忆数据");
    }

    /**
     * 获取角色记忆详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:memory:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(aiCharacterMemoryService.selectAiCharacterMemoryById(id));
    }

    /**
     * 新增角色记忆
     */
    @PreAuthorize("@ss.hasPermi('system:memory:add')")
    @Log(title = "角色记忆", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AiCharacterMemory aiCharacterMemory)
    {
        return toAjax(aiCharacterMemoryService.insertAiCharacterMemory(aiCharacterMemory));
    }

    /**
     * 修改角色记忆
     */
    @PreAuthorize("@ss.hasPermi('system:memory:edit')")
    @Log(title = "角色记忆", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AiCharacterMemory aiCharacterMemory)
    {
        return toAjax(aiCharacterMemoryService.updateAiCharacterMemory(aiCharacterMemory));
    }

    /**
     * 删除角色记忆
     */
    @PreAuthorize("@ss.hasPermi('system:memory:remove')")
    @Log(title = "角色记忆", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(aiCharacterMemoryService.deleteAiCharacterMemoryByIds(ids));
    }
}
