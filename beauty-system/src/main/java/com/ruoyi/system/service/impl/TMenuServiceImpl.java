package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TMenuMapper;
import com.ruoyi.system.domain.TMenu;
import com.ruoyi.system.service.ITMenuService;

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
}
