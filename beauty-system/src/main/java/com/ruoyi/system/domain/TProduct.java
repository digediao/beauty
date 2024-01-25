package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品对象 t_product
 *
 * @author ruoyi
 * @date 2024-01-16
 */
public class TProduct
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String title;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 品牌 */
    @Excel(name = "品牌")
    private Long brandId;

    @Excel(name = "分类")
    private Long categoryId;

    @Excel(name = "商店")
    private Long storeId;

    @Excel(name = "订单成交数")
    private Integer orderNum;

    /** 图片 */
    @Excel(name = "图片")
    private String img;

    /** 描述 */
    @Excel(name = "描述")
    private String desc;

    /** 重量 */
    @Excel(name = "重量")
    private BigDecimal height;

    /** 商品数量 */
    @Excel(name = "商品数量")
    private Long num;

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

    private Date createTime;

    private Date updateTime;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public BigDecimal getPrice()
    {
        return price;
    }
    public void setBrandId(Long brandId)
    {
        this.brandId = brandId;
    }

    public Long getBrandId()
    {
        return brandId;
    }
    public void setImg(String img)
    {
        this.img = img;
    }

    public String getImg()
    {
        return img;
    }
    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public String getDesc()
    {
        return desc;
    }
    public void setHeight(BigDecimal height)
    {
        this.height = height;
    }

    public BigDecimal getHeight()
    {
        return height;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public void setNum(Long num)
    {
        this.num = num;
    }

    public Long getNum()
    {
        return num;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("price", getPrice())
            .append("brandId", getBrandId())
            .append("img", getImg())
            .append("desc", getDesc())
            .append("height", getHeight())
            .append("num", getNum())
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
