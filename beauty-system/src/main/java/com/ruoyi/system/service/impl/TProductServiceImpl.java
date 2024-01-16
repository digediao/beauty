package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TProductMapper;
import com.ruoyi.system.domain.TProduct;
import com.ruoyi.system.service.ITProductService;

/**
 * 商品Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-01-16
 */
@Service
public class TProductServiceImpl implements ITProductService 
{
    @Autowired
    private TProductMapper tProductMapper;

    /**
     * 查询商品
     * 
     * @param id 商品主键
     * @return 商品
     */
    @Override
    public TProduct selectTProductById(Long id)
    {
        return tProductMapper.selectTProductById(id);
    }

    /**
     * 查询商品列表
     * 
     * @param tProduct 商品
     * @return 商品
     */
    @Override
    public List<TProduct> selectTProductList(TProduct tProduct)
    {
        return tProductMapper.selectTProductList(tProduct);
    }

    /**
     * 新增商品
     * 
     * @param tProduct 商品
     * @return 结果
     */
    @Override
    public int insertTProduct(TProduct tProduct)
    {
        tProduct.setCreateTime(DateUtils.getNowDate());
        return tProductMapper.insertTProduct(tProduct);
    }

    /**
     * 修改商品
     * 
     * @param tProduct 商品
     * @return 结果
     */
    @Override
    public int updateTProduct(TProduct tProduct)
    {
        tProduct.setUpdateTime(DateUtils.getNowDate());
        return tProductMapper.updateTProduct(tProduct);
    }

    /**
     * 批量删除商品
     * 
     * @param ids 需要删除的商品主键
     * @return 结果
     */
    @Override
    public int deleteTProductByIds(Long[] ids)
    {
        return tProductMapper.deleteTProductByIds(ids);
    }

    /**
     * 删除商品信息
     * 
     * @param id 商品主键
     * @return 结果
     */
    @Override
    public int deleteTProductById(Long id)
    {
        return tProductMapper.deleteTProductById(id);
    }
}
