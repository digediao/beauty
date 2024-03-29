package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.system.domain.dto.AllItemDto;
import com.ruoyi.system.domain.dto.GoodsTypesDto;
import com.ruoyi.system.domain.dto.TypeSortDto;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TMenu;
import com.ruoyi.system.service.ITMenuService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 分类菜单Controller
 *
 * @author ruoyi
 * @date 2024-01-18
 */
@RestController
@RequestMapping("/beauty/menu")
public class TMenuController extends BaseController
{
    @Autowired
    private ITMenuService tMenuService;

    /**
     * 获取类别：品牌、分类、妆效、功效等，筛选：销量、价格高低、好评
     * @return
     */
    @GetMapping("/getTypes")
    public R getTypes() {
        GoodsTypesDto list = tMenuService.getTypes();
        return R.ok(list);
    }

    /**
     * 根据类型、排序等筛选：销量、价格高低、好评
     */
    @PostMapping("/getItemsByType")
    public AjaxResult getItemsByType(@RequestBody TypeSortDto typeSortDto) {
        AllItemDto result = tMenuService.getItemsByType(typeSortDto);
        return AjaxResult.success(result);
    }


    /*==============================================*/

    /**
     * 查询分类菜单列表
     */
    @PreAuthorize("@ss.hasPermi('beauty:menu:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMenu tMenu)
    {
        startPage();
        List<TMenu> list = tMenuService.selectTMenuList(tMenu);
        return getDataTable(list);
    }

    /**
     * 导出分类菜单列表
     */
    @PreAuthorize("@ss.hasPermi('beauty:menu:export')")
    @Log(title = "分类菜单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TMenu tMenu)
    {
        List<TMenu> list = tMenuService.selectTMenuList(tMenu);
        ExcelUtil<TMenu> util = new ExcelUtil<TMenu>(TMenu.class);
        util.exportExcel(response, list, "分类菜单数据");
    }

    /**
     * 获取分类菜单详细信息
     */
    @PreAuthorize("@ss.hasPermi('beauty:menu:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tMenuService.selectTMenuById(id));
    }

    /**
     * 新增分类菜单
     */
    @PreAuthorize("@ss.hasPermi('beauty:menu:add')")
    @Log(title = "分类菜单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMenu tMenu)
    {
        return toAjax(tMenuService.insertTMenu(tMenu));
    }

    /**
     * 修改分类菜单
     */
    @PreAuthorize("@ss.hasPermi('beauty:menu:edit')")
    @Log(title = "分类菜单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMenu tMenu)
    {
        return toAjax(tMenuService.updateTMenu(tMenu));
    }

    /**
     * 删除分类菜单
     */
    @PreAuthorize("@ss.hasPermi('beauty:menu:remove')")
    @Log(title = "分类菜单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tMenuService.deleteTMenuByIds(ids));
    }
}
