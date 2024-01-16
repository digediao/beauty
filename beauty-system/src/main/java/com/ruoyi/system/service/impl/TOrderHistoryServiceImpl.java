package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TOrderHistoryMapper;
import com.ruoyi.system.domain.TOrderHistory;
import com.ruoyi.system.service.ITOrderHistoryService;

/**
 * 订单历史Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-01-16
 */
@Service
public class TOrderHistoryServiceImpl implements ITOrderHistoryService 
{
    @Autowired
    private TOrderHistoryMapper tOrderHistoryMapper;

    /**
     * 查询订单历史
     * 
     * @param id 订单历史主键
     * @return 订单历史
     */
    @Override
    public TOrderHistory selectTOrderHistoryById(Long id)
    {
        return tOrderHistoryMapper.selectTOrderHistoryById(id);
    }

    /**
     * 查询订单历史列表
     * 
     * @param tOrderHistory 订单历史
     * @return 订单历史
     */
    @Override
    public List<TOrderHistory> selectTOrderHistoryList(TOrderHistory tOrderHistory)
    {
        return tOrderHistoryMapper.selectTOrderHistoryList(tOrderHistory);
    }

    /**
     * 新增订单历史
     * 
     * @param tOrderHistory 订单历史
     * @return 结果
     */
    @Override
    public int insertTOrderHistory(TOrderHistory tOrderHistory)
    {
        tOrderHistory.setCreateTime(DateUtils.getNowDate());
        return tOrderHistoryMapper.insertTOrderHistory(tOrderHistory);
    }

    /**
     * 修改订单历史
     * 
     * @param tOrderHistory 订单历史
     * @return 结果
     */
    @Override
    public int updateTOrderHistory(TOrderHistory tOrderHistory)
    {
        tOrderHistory.setUpdateTime(DateUtils.getNowDate());
        return tOrderHistoryMapper.updateTOrderHistory(tOrderHistory);
    }

    /**
     * 批量删除订单历史
     * 
     * @param ids 需要删除的订单历史主键
     * @return 结果
     */
    @Override
    public int deleteTOrderHistoryByIds(Long[] ids)
    {
        return tOrderHistoryMapper.deleteTOrderHistoryByIds(ids);
    }

    /**
     * 删除订单历史信息
     * 
     * @param id 订单历史主键
     * @return 结果
     */
    @Override
    public int deleteTOrderHistoryById(Long id)
    {
        return tOrderHistoryMapper.deleteTOrderHistoryById(id);
    }
}
