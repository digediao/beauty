package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TBrand;

/**
 * 品牌Mapper接口
 * 
 * @author ruoyi
 * @date 2024-01-16
 */
public interface TBrandMapper 
{
    /**
     * 查询品牌
     * 
     * @param id 品牌主键
     * @return 品牌
     */
    public TBrand selectTBrandById(Long id);

    /**
     * 查询品牌列表
     * 
     * @param tBrand 品牌
     * @return 品牌集合
     */
    public List<TBrand> selectTBrandList(TBrand tBrand);

    /**
     * 新增品牌
     * 
     * @param tBrand 品牌
     * @return 结果
     */
    public int insertTBrand(TBrand tBrand);

    /**
     * 修改品牌
     * 
     * @param tBrand 品牌
     * @return 结果
     */
    public int updateTBrand(TBrand tBrand);

    /**
     * 删除品牌
     * 
     * @param id 品牌主键
     * @return 结果
     */
    public int deleteTBrandById(Long id);

    /**
     * 批量删除品牌
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTBrandByIds(Long[] ids);
}
