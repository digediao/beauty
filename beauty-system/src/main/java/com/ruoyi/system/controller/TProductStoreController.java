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
import com.ruoyi.system.domain.TProductStore;
import com.ruoyi.system.service.ITProductStoreService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品店家Controller
 * 
 * @author ruoyi
 * @date 2024-01-16
 */
@RestController
@RequestMapping("/beauty/store")
public class TProductStoreController extends BaseController
{
    @Autowired
    private ITProductStoreService tProductStoreService;

    /**
     * 查询商品店家列表
     */
    @PreAuthorize("@ss.hasPermi('beauty:store:list')")
    @GetMapping("/list")
    public TableDataInfo list(TProductStore tProductStore)
    {
        startPage();
        List<TProductStore> list = tProductStoreService.selectTProductStoreList(tProductStore);
        return getDataTable(list);
    }

    /**
     * 导出商品店家列表
     */
    @PreAuthorize("@ss.hasPermi('beauty:store:export')")
    @Log(title = "商品店家", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TProductStore tProductStore)
    {
        List<TProductStore> list = tProductStoreService.selectTProductStoreList(tProductStore);
        ExcelUtil<TProductStore> util = new ExcelUtil<TProductStore>(TProductStore.class);
        util.exportExcel(response, list, "商品店家数据");
    }

    /**
     * 获取商品店家详细信息
     */
    @PreAuthorize("@ss.hasPermi('beauty:store:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tProductStoreService.selectTProductStoreById(id));
    }

    /**
     * 新增商品店家
     */
    @PreAuthorize("@ss.hasPermi('beauty:store:add')")
    @Log(title = "商品店家", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TProductStore tProductStore)
    {
        return toAjax(tProductStoreService.insertTProductStore(tProductStore));
    }

    /**
     * 修改商品店家
     */
    @PreAuthorize("@ss.hasPermi('beauty:store:edit')")
    @Log(title = "商品店家", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TProductStore tProductStore)
    {
        return toAjax(tProductStoreService.updateTProductStore(tProductStore));
    }

    /**
     * 删除商品店家
     */
    @PreAuthorize("@ss.hasPermi('beauty:store:remove')")
    @Log(title = "商品店家", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tProductStoreService.deleteTProductStoreByIds(ids));
    }
}
