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
import com.ruoyi.system.domain.TOrderHistory;
import com.ruoyi.system.service.ITOrderHistoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单历史Controller
 * 
 * @author ruoyi
 * @date 2024-01-16
 */
@RestController
@RequestMapping("/beauty/history")
public class TOrderHistoryController extends BaseController
{
    @Autowired
    private ITOrderHistoryService tOrderHistoryService;

    /**
     * 查询订单历史列表
     */
    @PreAuthorize("@ss.hasPermi('beauty:history:list')")
    @GetMapping("/list")
    public TableDataInfo list(TOrderHistory tOrderHistory)
    {
        startPage();
        List<TOrderHistory> list = tOrderHistoryService.selectTOrderHistoryList(tOrderHistory);
        return getDataTable(list);
    }

    /**
     * 导出订单历史列表
     */
    @PreAuthorize("@ss.hasPermi('beauty:history:export')")
    @Log(title = "订单历史", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TOrderHistory tOrderHistory)
    {
        List<TOrderHistory> list = tOrderHistoryService.selectTOrderHistoryList(tOrderHistory);
        ExcelUtil<TOrderHistory> util = new ExcelUtil<TOrderHistory>(TOrderHistory.class);
        util.exportExcel(response, list, "订单历史数据");
    }

    /**
     * 获取订单历史详细信息
     */
    @PreAuthorize("@ss.hasPermi('beauty:history:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tOrderHistoryService.selectTOrderHistoryById(id));
    }

    /**
     * 新增订单历史
     */
    @PreAuthorize("@ss.hasPermi('beauty:history:add')")
    @Log(title = "订单历史", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TOrderHistory tOrderHistory)
    {
        return toAjax(tOrderHistoryService.insertTOrderHistory(tOrderHistory));
    }

    /**
     * 修改订单历史
     */
    @PreAuthorize("@ss.hasPermi('beauty:history:edit')")
    @Log(title = "订单历史", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TOrderHistory tOrderHistory)
    {
        return toAjax(tOrderHistoryService.updateTOrderHistory(tOrderHistory));
    }

    /**
     * 删除订单历史
     */
    @PreAuthorize("@ss.hasPermi('beauty:history:remove')")
    @Log(title = "订单历史", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tOrderHistoryService.deleteTOrderHistoryByIds(ids));
    }
}
