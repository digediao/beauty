package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TProductStore;

/**
 * 商品店家Service接口
 * 
 * @author ruoyi
 * @date 2024-01-16
 */
public interface ITProductStoreService 
{
    /**
     * 查询商品店家
     * 
     * @param id 商品店家主键
     * @return 商品店家
     */
    public TProductStore selectTProductStoreById(Long id);

    /**
     * 查询商品店家列表
     * 
     * @param tProductStore 商品店家
     * @return 商品店家集合
     */
    public List<TProductStore> selectTProductStoreList(TProductStore tProductStore);

    /**
     * 新增商品店家
     * 
     * @param tProductStore 商品店家
     * @return 结果
     */
    public int insertTProductStore(TProductStore tProductStore);

    /**
     * 修改商品店家
     * 
     * @param tProductStore 商品店家
     * @return 结果
     */
    public int updateTProductStore(TProductStore tProductStore);

    /**
     * 批量删除商品店家
     * 
     * @param ids 需要删除的商品店家主键集合
     * @return 结果
     */
    public int deleteTProductStoreByIds(Long[] ids);

    /**
     * 删除商品店家信息
     * 
     * @param id 商品店家主键
     * @return 结果
     */
    public int deleteTProductStoreById(Long id);
}
