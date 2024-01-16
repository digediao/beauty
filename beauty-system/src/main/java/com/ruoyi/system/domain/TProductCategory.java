package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品分类对象 t_product_category
 * 
 * @author ruoyi
 * @date 2024-01-16
 */
public class TProductCategory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 商品分类名称 */
    @Excel(name = "商品分类名称")
    private String name;

    /** 父id */
    @Excel(name = "父id")
    private Long pid;

    /** 商品形态 */
    @Excel(name = "商品形态")
    private String state;

    /** 妆效 */
    @Excel(name = "妆效")
    private String effection;

    /** 类别 */
    @Excel(name = "类别")
    private String category;

    /** 0存在 1删除 */
    private Long delFlag;

    /** 0显示 1隐藏 */
    @Excel(name = "0显示 1隐藏")
    private Long status;

    /** 排序 */
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
    public void setPid(Long pid) 
    {
        this.pid = pid;
    }

    public Long getPid() 
    {
        return pid;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setEffection(String effection) 
    {
        this.effection = effection;
    }

    public String getEffection() 
    {
        return effection;
    }
    public void setCategory(String category) 
    {
        this.category = category;
    }

    public String getCategory() 
    {
        return category;
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
            .append("pid", getPid())
            .append("state", getState())
            .append("effection", getEffection())
            .append("category", getCategory())
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
