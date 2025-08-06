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
import com.ruoyi.vibetempt.domain.AiUserCharacterRelation;
import com.ruoyi.vibetempt.service.AiUserCharacterRelationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户角色关系Controller
 * 
 * @author ruoyi
 * @date 2025-08-02
 */
@RestController
@RequestMapping("/vibetempt/relation")
public class AiUserCharacterRelationController extends BaseController
{
    @Autowired
    private AiUserCharacterRelationService aiUserCharacterRelationService;

    /**
     * 查询用户角色关系列表
     */
    @PreAuthorize("@ss.hasPermi('vibetempt:relation:list')")
    @GetMapping("/list")
    public TableDataInfo list(AiUserCharacterRelation aiUserCharacterRelation)
    {
        startPage();
        List<AiUserCharacterRelation> list = aiUserCharacterRelationService.selectAiUserCharacterRelationList(aiUserCharacterRelation);
        return getDataTable(list);
    }

    /**
     * 导出用户角色关系列表
     */
    @PreAuthorize("@ss.hasPermi('vibetempt:relation:export')")
    @Log(title = "用户角色关系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AiUserCharacterRelation aiUserCharacterRelation)
    {
        List<AiUserCharacterRelation> list = aiUserCharacterRelationService.selectAiUserCharacterRelationList(aiUserCharacterRelation);
        ExcelUtil<AiUserCharacterRelation> util = new ExcelUtil<AiUserCharacterRelation>(AiUserCharacterRelation.class);
        util.exportExcel(response, list, "用户角色关系数据");
    }

    /**
     * 获取用户角色关系详细信息
     */
    @PreAuthorize("@ss.hasPermi('vibetempt:relation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(aiUserCharacterRelationService.selectAiUserCharacterRelationById(id));
    }

    /**
     * 新增用户角色关系
     */
    @PreAuthorize("@ss.hasPermi('vibetempt:relation:add')")
    @Log(title = "用户角色关系", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AiUserCharacterRelation aiUserCharacterRelation)
    {
        return toAjax(aiUserCharacterRelationService.insertAiUserCharacterRelation(aiUserCharacterRelation));
    }

    /**
     * 修改用户角色关系
     */
    @PreAuthorize("@ss.hasPermi('vibetempt:relation:edit')")
    @Log(title = "用户角色关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AiUserCharacterRelation aiUserCharacterRelation)
    {
        return toAjax(aiUserCharacterRelationService.updateAiUserCharacterRelation(aiUserCharacterRelation));
    }

    /**
     * 删除用户角色关系
     */
    @PreAuthorize("@ss.hasPermi('vibetempt:relation:remove')")
    @Log(title = "用户角色关系", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(aiUserCharacterRelationService.deleteAiUserCharacterRelationByIds(ids));
    }
}
