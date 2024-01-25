package com.ruoyi.system.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.dto.AllItemDto;
import com.ruoyi.system.domain.dto.GoodsTypesDto;
import com.ruoyi.system.domain.dto.ProductDto;
import com.ruoyi.system.domain.dto.TypeSortDto;
import com.ruoyi.system.domain.mapping.ProductMenuMapping;
import com.ruoyi.system.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.service.ITMenuService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 分类菜单Service业务层处理
 *
 * @author ruoyi
 * @date 2024-01-18
 */
@Service
public class TMenuServiceImpl implements ITMenuService
{
    @Autowired
    private TMenuMapper tMenuMapper;
    @Autowired
    private TBrandMapper brandMapper;
    @Autowired
    private TCategoryMapper categoryMapper;
    @Autowired
    private TProductMapper productMapper;
    @Autowired
    private TProductStoreMapper productStoreMapper;

    /**
     * 查询分类菜单
     *
     * @param id 分类菜单主键
     * @return 分类菜单
     */
    @Override
    public TMenu selectTMenuById(Long id)
    {
        return tMenuMapper.selectTMenuById(id);
    }

    /**
     * 查询分类菜单列表
     *
     * @param tMenu 分类菜单
     * @return 分类菜单
     */
    @Override
    public List<TMenu> selectTMenuList(TMenu tMenu)
    {
        return tMenuMapper.selectTMenuList(tMenu);
    }

    /**
     * 新增分类菜单
     *
     * @param tMenu 分类菜单
     * @return 结果
     */
    @Override
    public int insertTMenu(TMenu tMenu)
    {
        tMenu.setCreateTime(DateUtils.getNowDate());
        return tMenuMapper.insertTMenu(tMenu);
    }

    /**
     * 修改分类菜单
     *
     * @param tMenu 分类菜单
     * @return 结果
     */
    @Override
    public int updateTMenu(TMenu tMenu)
    {
        tMenu.setUpdateTime(DateUtils.getNowDate());
        return tMenuMapper.updateTMenu(tMenu);
    }

    /**
     * 批量删除分类菜单
     *
     * @param ids 需要删除的分类菜单主键
     * @return 结果
     */
    @Override
    public int deleteTMenuByIds(Long[] ids)
    {
        return tMenuMapper.deleteTMenuByIds(ids);
    }

    /**
     * 删除分类菜单信息
     *
     * @param id 分类菜单主键
     * @return 结果
     */
    @Override
    public int deleteTMenuById(Long id)
    {
        return tMenuMapper.deleteTMenuById(id);
    }



    @Override
    public GoodsTypesDto getTypes() {
        List<TBrand> brandList = brandMapper.selectTBrandList(null);
        List<TCategory> categoryList = categoryMapper.selectTCategoryList(null);
        List<TMenu> menuList = tMenuMapper.selectTMenuList(null);
        Map<String, List<TMenu>> menuMap = new HashMap<>();

        for (TMenu menu : menuList) {
            Long pid = menu.getPid();
            if (pid == 0 && !menuMap.containsKey(menu.getName())) {
                // 如果是一级菜单，创建一个新的空列表
                menuMap.put(menu.getName(), new ArrayList<>());
            } else {
                // 如果是二级菜单，找到对应的一级菜单，将其添加到对应的列表中
                TMenu parentMenu = getParentMenu(menuList, pid);
                if (parentMenu != null) {
                    List<TMenu> childList = menuMap.computeIfAbsent(parentMenu.getName(), k -> new ArrayList<>());
                    childList.add(menu);
                    menuMap.put(parentMenu.getName(),childList);
                }
            }
        }

        GoodsTypesDto goodsTypesDto = GoodsTypesDto.builder()
                .brandList(brandList)
                .categoryList(categoryList)
                .menuMap(menuMap)
                .build();

        return goodsTypesDto;
    }
    private TMenu getParentMenu(List<TMenu> menuList, Long pid) {
        for (TMenu menu : menuList) {
            if (menu.getId().equals(pid)) {
                return menu;
            }
        }
        return null;
    }

    /**
     * 根据类型、排序等筛选：销量、价格高低、好评
     * 结果集：商品列表、总数
     */
    @Override
    public AllItemDto getItemsByType(TypeSortDto typeSortDto) {
        // 查询所有产品集合
        List<TProduct> productList = productMapper.selectTProductList(null);
        List<ProductDto> prouctDtoList = productMapper.selectProductDtoList();
        List<Long> productIds = new ArrayList<>();

        // 根据类型筛选
        productList.stream().filter(product -> {
            if (typeSortDto.getBrandId() != null && !typeSortDto.getBrandId().equals(product.getBrandId())) {
                return false;
            }
            if (typeSortDto.getCategoryId() != null && !typeSortDto.getCategoryId().equals(product.getCategoryId())) {
                return false;
            }
            /*判断商品菜单集合中是否全部包含菜单类型*/
            if (!productList.isEmpty() &&  typeSortDto.getMenuIdList() != null && !typeSortDto.getMenuIdList().isEmpty()) {
                List<ProductMenuMapping> menuList = tMenuMapper.selectMenuListByProductId(product.getId());
                if(!menuFilter(menuList, typeSortDto)){
                    return false;
                }
            }
            productIds.add(product.getId());
            return true;
        }).collect(Collectors.toList());

        List<ProductDto> resultList = prouctDtoList.stream().filter(productDto -> {
            return productIds.contains(productDto.getId());
        }).collect(Collectors.toList());

        // 排序
        if(typeSortDto.getSort() != null){
            switch (typeSortDto.getSort()){
                case "sales":
                    resultList.sort(Comparator.comparing(ProductDto::getOrderNum).reversed());
                    break;
                case "priceAsc":
                    resultList.sort(Comparator.comparing(ProductDto::getPrice));
                    break;
                case "priceDesc":
                    resultList.sort(Comparator.comparing(ProductDto::getPrice).reversed());
                    break;
                case "default":
                default: break;
            }
        }

        // 分页
        int fromIndex = (typeSortDto.getPageNum() - 1) * typeSortDto.getPageSize();
        int toIndex = Math.min(fromIndex + typeSortDto.getPageSize(), resultList.size());
        resultList = resultList.subList(fromIndex, toIndex);

        // 封装结果集
        AllItemDto allItemDto = AllItemDto.builder()
                .productDtoList(resultList)
                .total(resultList.size()).build();


        return allItemDto;
    }
    // 判断商品菜单集合中是否全部包含菜单类型
    private boolean menuFilter(List<ProductMenuMapping> menuList, TypeSortDto typeSortDto){
        Set<Long> menuIds = menuList.stream()
                .map(ProductMenuMapping::getMenuId)
                .collect(Collectors.toSet());
        return menuIds.containsAll(typeSortDto.getMenuIdList());
    }
}
