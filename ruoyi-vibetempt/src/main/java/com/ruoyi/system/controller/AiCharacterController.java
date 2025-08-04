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
import com.ruoyi.system.domain.AiCharacter;
import com.ruoyi.system.service.AiCharacterService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * AI角色Controller
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
@RestController
@RequestMapping("/system/character")
public class AiCharacterController extends BaseController
{
    @Autowired
    private AiCharacterService aiCharacterService;

    /**
     * 查询AI角色列表
     */
    @PreAuthorize("@ss.hasPermi('system:character:list')")
    @GetMapping("/list")
    public TableDataInfo list(AiCharacter aiCharacter)
    {
        startPage();
        List<AiCharacter> list = aiCharacterService.selectAiCharacterList(aiCharacter);
        return getDataTable(list);
    }

    /**
     * 导出AI角色列表
     */
    @PreAuthorize("@ss.hasPermi('system:character:export')")
    @Log(title = "AI角色", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AiCharacter aiCharacter)
    {
        List<AiCharacter> list = aiCharacterService.selectAiCharacterList(aiCharacter);
        ExcelUtil<AiCharacter> util = new ExcelUtil<AiCharacter>(AiCharacter.class);
        util.exportExcel(response, list, "AI角色数据");
    }

    /**
     * 获取AI角色详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:character:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(aiCharacterService.selectAiCharacterById(id));
    }

    /**
     * 新增AI角色
     */
    @PreAuthorize("@ss.hasPermi('system:character:add')")
    @Log(title = "AI角色", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AiCharacter aiCharacter)
    {
        return toAjax(aiCharacterService.insertAiCharacter(aiCharacter));
    }

    /**
     * 修改AI角色
     */
    @PreAuthorize("@ss.hasPermi('system:character:edit')")
    @Log(title = "AI角色", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AiCharacter aiCharacter)
    {
        return toAjax(aiCharacterService.updateAiCharacter(aiCharacter));
    }

    /**
     * 删除AI角色
     */
    @PreAuthorize("@ss.hasPermi('system:character:remove')")
    @Log(title = "AI角色", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(aiCharacterService.deleteAiCharacterByIds(ids));
    }
}
