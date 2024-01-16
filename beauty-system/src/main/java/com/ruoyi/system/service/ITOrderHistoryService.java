package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TOrderHistory;

/**
 * 订单历史Service接口
 * 
 * @author ruoyi
 * @date 2024-01-16
 */
public interface ITOrderHistoryService 
{
    /**
     * 查询订单历史
     * 
     * @param id 订单历史主键
     * @return 订单历史
     */
    public TOrderHistory selectTOrderHistoryById(Long id);

    /**
     * 查询订单历史列表
     * 
     * @param tOrderHistory 订单历史
     * @return 订单历史集合
     */
    public List<TOrderHistory> selectTOrderHistoryList(TOrderHistory tOrderHistory);

    /**
     * 新增订单历史
     * 
     * @param tOrderHistory 订单历史
     * @return 结果
     */
    public int insertTOrderHistory(TOrderHistory tOrderHistory);

    /**
     * 修改订单历史
     * 
     * @param tOrderHistory 订单历史
     * @return 结果
     */
    public int updateTOrderHistory(TOrderHistory tOrderHistory);

    /**
     * 批量删除订单历史
     * 
     * @param ids 需要删除的订单历史主键集合
     * @return 结果
     */
    public int deleteTOrderHistoryByIds(Long[] ids);

    /**
     * 删除订单历史信息
     * 
     * @param id 订单历史主键
     * @return 结果
     */
    public int deleteTOrderHistoryById(Long id);
}
