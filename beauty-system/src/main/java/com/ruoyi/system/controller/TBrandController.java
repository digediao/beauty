package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.system.domain.TBrand;
import com.ruoyi.system.service.ITBrandService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 品牌Controller
 * 
 * @author ruoyi
 * @date 2024-01-16
 */
@RestController
@RequestMapping("/beauty/brand")
public class TBrandController extends BaseController
{
    @Autowired
    private ITBrandService tBrandService;

    /**
     * 查询品牌列表
     */
    @PreAuthorize("@ss.hasPermi('beauty:brand:list')")
    @GetMapping("/list")
    public TableDataInfo list(TBrand tBrand)
    {
        startPage();
        List<TBrand> list = tBrandService.selectTBrandList(tBrand);
        return getDataTable(list);
    }

    /**
     * 导出品牌列表
     */
    @PreAuthorize("@ss.hasPermi('beauty:brand:export')")
    @Log(title = "品牌", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TBrand tBrand)
    {
        List<TBrand> list = tBrandService.selectTBrandList(tBrand);
        ExcelUtil<TBrand> util = new ExcelUtil<TBrand>(TBrand.class);
        util.exportExcel(response, list, "品牌数据");
    }

    /**
     * 获取品牌详细信息
     */
    @PreAuthorize("@ss.hasPermi('beauty:brand:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tBrandService.selectTBrandById(id));
    }

    /**
     * 新增品牌
     */
    @PreAuthorize("@ss.hasPermi('beauty:brand:add')")
    @Log(title = "品牌", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TBrand tBrand)
    {
        return toAjax(tBrandService.insertTBrand(tBrand));
    }

    /**
     * 修改品牌
     */
    @PreAuthorize("@ss.hasPermi('beauty:brand:edit')")
    @Log(title = "品牌", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TBrand tBrand)
    {
        return toAjax(tBrandService.updateTBrand(tBrand));
    }

    /**
     * 删除品牌
     */
    @PreAuthorize("@ss.hasPermi('beauty:brand:remove')")
    @Log(title = "品牌", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tBrandService.deleteTBrandByIds(ids));
    }
}
