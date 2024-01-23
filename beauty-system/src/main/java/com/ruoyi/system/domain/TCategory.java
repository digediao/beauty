package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品分类对象 t_category
 * 
 * @author ruoyi
 * @date 2024-01-18
 */
public class TCategory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 商品分类名称 */
    @Excel(name = "商品分类名称")
    private String name;

    /** 0存在 1删除 */
    private Long delFlag;

    /** 0显示 1隐藏 */
    @Excel(name = "0显示 1隐藏")
    private Long status;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    /** $column.columnComment */
    private String createUser;

    /** $column.columnComment */
    private String updateUser;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setDelFlag(Long delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Long getDelFlag() 
    {
        return delFlag;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
    }
    public void setCreateUser(String createUser) 
    {
        this.createUser = createUser;
    }

    public String getCreateUser() 
    {
        return createUser;
    }
    public void setUpdateUser(String updateUser) 
    {
        this.updateUser = updateUser;
    }

    public String getUpdateUser() 
    {
        return updateUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("delFlag", getDelFlag())
            .append("status", getStatus())
            .append("sort", getSort())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createUser", getCreateUser())
            .append("updateUser", getUpdateUser())
            .toString();
    }
}
