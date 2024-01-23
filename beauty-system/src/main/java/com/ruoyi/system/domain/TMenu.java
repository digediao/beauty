package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 分类菜单对象 t_menu
 * 
 * @author ruoyi
 * @date 2024-01-18
 */
public class TMenu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 菜单名称 */
    @Excel(name = "菜单名称")
    private String name;

    /** 父级id */
    @Excel(name = "父级id")
    private Long pid;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    /** 0存在 1 删除 */
    private Long delFlag;

    /** $column.columnComment */
    private String createUser;

    /** $column.columnComment */
    private Date updateUser;

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
    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
    }
    public void setDelFlag(Long delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Long getDelFlag() 
    {
        return delFlag;
    }
    public void setCreateUser(String createUser) 
    {
        this.createUser = createUser;
    }

    public String getCreateUser() 
    {
        return createUser;
    }
    public void setUpdateUser(Date updateUser) 
    {
        this.updateUser = updateUser;
    }

    public Date getUpdateUser() 
    {
        return updateUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("pid", getPid())
            .append("sort", getSort())
            .append("delFlag", getDelFlag())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createUser", getCreateUser())
            .append("updateUser", getUpdateUser())
            .toString();
    }
}
