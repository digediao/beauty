package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TMenu;

/**
 * 分类菜单Service接口
 * 
 * @author ruoyi
 * @date 2024-01-18
 */
public interface ITMenuService 
{
    /**
     * 查询分类菜单
     * 
     * @param id 分类菜单主键
     * @return 分类菜单
     */
    public TMenu selectTMenuById(Long id);

    /**
     * 查询分类菜单列表
     * 
     * @param tMenu 分类菜单
     * @return 分类菜单集合
     */
    public List<TMenu> selectTMenuList(TMenu tMenu);

    /**
     * 新增分类菜单
     * 
     * @param tMenu 分类菜单
     * @return 结果
     */
    public int insertTMenu(TMenu tMenu);

    /**
     * 修改分类菜单
     * 
     * @param tMenu 分类菜单
     * @return 结果
     */
    public int updateTMenu(TMenu tMenu);

    /**
     * 批量删除分类菜单
     * 
     * @param ids 需要删除的分类菜单主键集合
     * @return 结果
     */
    public int deleteTMenuByIds(Long[] ids);

    /**
     * 删除分类菜单信息
     * 
     * @param id 分类菜单主键
     * @return 结果
     */
    public int deleteTMenuById(Long id);
}
