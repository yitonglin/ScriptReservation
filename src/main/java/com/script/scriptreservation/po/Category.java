package com.script.scriptreservation.po;

import javax.persistence.*;

@Table(name = "category")
public class Category {
    /**
     * 分类表主键ID
     */
    @Id
    private String id;

    /**
     * 分类数
     */
    @Column(name = "category_status")
    private Integer categoryStatus;

    /**
     * 分类名
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * 获取分类表主键ID
     *
     * @return id - 分类表主键ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置分类表主键ID
     *
     * @param id 分类表主键ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取分类数
     *
     * @return category_status - 分类数
     */
    public Integer getCategoryStatus() {
        return categoryStatus;
    }

    /**
     * 设置分类数
     *
     * @param categoryStatus 分类数
     */
    public void setCategoryStatus(Integer categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    /**
     * 获取分类名
     *
     * @return category_name - 分类名
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置分类名
     *
     * @param categoryName 分类名
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }
}