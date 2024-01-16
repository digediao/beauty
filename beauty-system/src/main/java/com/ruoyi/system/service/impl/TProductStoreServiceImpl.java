package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TProductStoreMapper;
import com.ruoyi.system.domain.TProductStore;
import com.ruoyi.system.service.ITProductStoreService;

/**
 * 商品店家Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-01-16
 */
@Service
public class TProductStoreServiceImpl implements ITProductStoreService 
{
    @Autowired
    private TProductStoreMapper tProductStoreMapper;

    /**
     * 查询商品店家
     * 
     * @param id 商品店家主键
     * @return 商品店家
     */
    @Override
    public TProductStore selectTProductStoreById(Long id)
    {
        return tProductStoreMapper.selectTProductStoreById(id);
    }

    /**
     * 查询商品店家列表
     * 
     * @param tProductStore 商品店家
     * @return 商品店家
     */
    @Override
    public List<TProductStore> selectTProductStoreList(TProductStore tProductStore)
    {
        return tProductStoreMapper.selectTProductStoreList(tProductStore);
    }

    /**
     * 新增商品店家
     * 
     * @param tProductStore 商品店家
     * @return 结果
     */
    @Override
    public int insertTProductStore(TProductStore tProductStore)
    {
        tProductStore.setCreateTime(DateUtils.getNowDate());
        return tProductStoreMapper.insertTProductStore(tProductStore);
    }

    /**
     * 修改商品店家
     * 
     * @param tProductStore 商品店家
     * @return 结果
     */
    @Override
    public int updateTProductStore(TProductStore tProductStore)
    {
        tProductStore.setUpdateTime(DateUtils.getNowDate());
        return tProductStoreMapper.updateTProductStore(tProductStore);
    }

    /**
     * 批量删除商品店家
     * 
     * @param ids 需要删除的商品店家主键
     * @return 结果
     */
    @Override
    public int deleteTProductStoreByIds(Long[] ids)
    {
        return tProductStoreMapper.deleteTProductStoreByIds(ids);
    }

    /**
     * 删除商品店家信息
     * 
     * @param id 商品店家主键
     * @return 结果
     */
    @Override
    public int deleteTProductStoreById(Long id)
    {
        return tProductStoreMapper.deleteTProductStoreById(id);
    }
}
