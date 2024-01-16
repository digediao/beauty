package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品店家对象 t_product_store
 * 
 * @author ruoyi
 * @date 2024-01-16
 */
public class TProductStore extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 店家名称 */
    @Excel(name = "店家名称")
    private String name;

    /** 品牌 */
    @Excel(name = "品牌")
    private Long brandId;

    /** 详情页图片 */
    @Excel(name = "详情页图片")
    private String detailsImg;

    /** 粉丝数 */
    @Excel(name = "粉丝数")
    private Long fans;

    /** 成交订单数 */
    @Excel(name = "成交订单数")
    private Long orderNum;

    /** 图片 */
    @Excel(name = "图片")
    private String img;

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
    public void setBrandId(Long brandId) 
    {
        this.brandId = brandId;
    }

    public Long getBrandId() 
    {
        return brandId;
    }
    public void setDetailsImg(String detailsImg) 
    {
        this.detailsImg = detailsImg;
    }

    public String getDetailsImg() 
    {
        return detailsImg;
    }
    public void setFans(Long fans) 
    {
        this.fans = fans;
    }

    public Long getFans() 
    {
        return fans;
    }
    public void setOrderNum(Long orderNum) 
    {
        this.orderNum = orderNum;
    }

    public Long getOrderNum() 
    {
        return orderNum;
    }
    public void setImg(String img) 
    {
        this.img = img;
    }

    public String getImg() 
    {
        return img;
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
            .append("brandId", getBrandId())
            .append("detailsImg", getDetailsImg())
            .append("fans", getFans())
            .append("orderNum", getOrderNum())
            .append("img", getImg())
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
