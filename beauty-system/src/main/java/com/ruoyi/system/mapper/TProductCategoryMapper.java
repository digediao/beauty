package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TProductCategory;

/**
 * 商品分类Mapper接口
 * 
 * @author ruoyi
 * @date 2024-01-16
 */
public interface TProductCategoryMapper 
{
    /**
     * 查询商品分类
     * 
     * @param id 商品分类主键
     * @return 商品分类
     */
    public TProductCategory selectTProductCategoryById(Long id);

    /**
     * 查询商品分类列表
     * 
     * @param tProductCategory 商品分类
     * @return 商品分类集合
     */
    public List<TProductCategory> selectTProductCategoryList(TProductCategory tProductCategory);

    /**
     * 新增商品分类
     * 
     * @param tProductCategory 商品分类
     * @return 结果
     */
    public int insertTProductCategory(TProductCategory tProductCategory);

    /**
     * 修改商品分类
     * 
     * @param tProductCategory 商品分类
     * @return 结果
     */
    public int updateTProductCategory(TProductCategory tProductCategory);

    /**
     * 删除商品分类
     * 
     * @param id 商品分类主键
     * @return 结果
     */
    public int deleteTProductCategoryById(Long id);

    /**
     * 批量删除商品分类
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTProductCategoryByIds(Long[] ids);
}
