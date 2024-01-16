package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TProductCategoryMapper;
import com.ruoyi.system.domain.TProductCategory;
import com.ruoyi.system.service.ITProductCategoryService;

/**
 * 商品分类Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-01-16
 */
@Service
public class TProductCategoryServiceImpl implements ITProductCategoryService 
{
    @Autowired
    private TProductCategoryMapper tProductCategoryMapper;

    /**
     * 查询商品分类
     * 
     * @param id 商品分类主键
     * @return 商品分类
     */
    @Override
    public TProductCategory selectTProductCategoryById(Long id)
    {
        return tProductCategoryMapper.selectTProductCategoryById(id);
    }

    /**
     * 查询商品分类列表
     * 
     * @param tProductCategory 商品分类
     * @return 商品分类
     */
    @Override
    public List<TProductCategory> selectTProductCategoryList(TProductCategory tProductCategory)
    {
        return tProductCategoryMapper.selectTProductCategoryList(tProductCategory);
    }

    /**
     * 新增商品分类
     * 
     * @param tProductCategory 商品分类
     * @return 结果
     */
    @Override
    public int insertTProductCategory(TProductCategory tProductCategory)
    {
        tProductCategory.setCreateTime(DateUtils.getNowDate());
        return tProductCategoryMapper.insertTProductCategory(tProductCategory);
    }

    /**
     * 修改商品分类
     * 
     * @param tProductCategory 商品分类
     * @return 结果
     */
    @Override
    public int updateTProductCategory(TProductCategory tProductCategory)
    {
        tProductCategory.setUpdateTime(DateUtils.getNowDate());
        return tProductCategoryMapper.updateTProductCategory(tProductCategory);
    }

    /**
     * 批量删除商品分类
     * 
     * @param ids 需要删除的商品分类主键
     * @return 结果
     */
    @Override
    public int deleteTProductCategoryByIds(Long[] ids)
    {
        return tProductCategoryMapper.deleteTProductCategoryByIds(ids);
    }

    /**
     * 删除商品分类信息
     * 
     * @param id 商品分类主键
     * @return 结果
     */
    @Override
    public int deleteTProductCategoryById(Long id)
    {
        return tProductCategoryMapper.deleteTProductCategoryById(id);
    }
}
