package com.ruoyi.system.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.system.domain.TProduct;
import com.ruoyi.system.domain.dto.AllItemDto;
import com.ruoyi.system.domain.dto.ProductDto;
import com.ruoyi.system.domain.dto.TypeSortDto;
import org.apache.ibatis.annotations.Param;

/**
 * 商品Mapper接口
 *
 * @author ruoyi
 * @date 2024-01-16
 */
public interface TProductMapper extends BaseMapper<TProduct>
{
    /**
     * 查询商品
     *
     * @param id 商品主键
     * @return 商品
     */
    public TProduct selectTProductById(Long id);

    /**
     * 查询商品列表
     *
     * @param tProduct 商品
     * @return 商品集合
     */
    public List<TProduct> selectTProductList(TProduct tProduct);

    /**
     * 新增商品
     *
     * @param tProduct 商品
     * @return 结果
     */
    public int insertTProduct(TProduct tProduct);

    /**
     * 修改商品
     *
     * @param tProduct 商品
     * @return 结果
     */
    public int updateTProduct(TProduct tProduct);

    /**
     * 删除商品
     *
     * @param id 商品主键
     * @return 结果
     */
    public int deleteTProductById(Long id);

    /**
     * 批量删除商品
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTProductByIds(Long[] ids);

    List<ProductDto> selectProductDtoList();

    IPage<ProductDto> selectProductDtoPage(Page<?> page, @Param("typeSortDto") TypeSortDto typeSortDto);
}
