package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TBrandMapper;
import com.ruoyi.system.domain.TBrand;
import com.ruoyi.system.service.ITBrandService;

/**
 * 品牌Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-01-16
 */
@Service
public class TBrandServiceImpl implements ITBrandService 
{
    @Autowired
    private TBrandMapper tBrandMapper;

    /**
     * 查询品牌
     * 
     * @param id 品牌主键
     * @return 品牌
     */
    @Override
    public TBrand selectTBrandById(Long id)
    {
        return tBrandMapper.selectTBrandById(id);
    }

    /**
     * 查询品牌列表
     * 
     * @param tBrand 品牌
     * @return 品牌
     */
    @Override
    public List<TBrand> selectTBrandList(TBrand tBrand)
    {
        return tBrandMapper.selectTBrandList(tBrand);
    }

    /**
     * 新增品牌
     * 
     * @param tBrand 品牌
     * @return 结果
     */
    @Override
    public int insertTBrand(TBrand tBrand)
    {
        tBrand.setCreateTime(DateUtils.getNowDate());
        return tBrandMapper.insertTBrand(tBrand);
    }

    /**
     * 修改品牌
     * 
     * @param tBrand 品牌
     * @return 结果
     */
    @Override
    public int updateTBrand(TBrand tBrand)
    {
        tBrand.setUpdateTime(DateUtils.getNowDate());
        return tBrandMapper.updateTBrand(tBrand);
    }

    /**
     * 批量删除品牌
     * 
     * @param ids 需要删除的品牌主键
     * @return 结果
     */
    @Override
    public int deleteTBrandByIds(Long[] ids)
    {
        return tBrandMapper.deleteTBrandByIds(ids);
    }

    /**
     * 删除品牌信息
     * 
     * @param id 品牌主键
     * @return 结果
     */
    @Override
    public int deleteTBrandById(Long id)
    {
        return tBrandMapper.deleteTBrandById(id);
    }
}
