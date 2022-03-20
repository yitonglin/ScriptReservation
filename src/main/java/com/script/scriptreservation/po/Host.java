package com.script.scriptreservation.po;

import javax.persistence.*;

@Table(name = "host")
public class Host {
    /**
     * 主持人主键ID
     */
    @Id
    private String id;

    /**
     * 主持人名称
     */
    @Column(name = "host_name")
    private String hostName;

    /**
     * 主持人擅长类型
     */
    @Column(name = "host_category_like")
    private String hostCategoryLike;

    /**
     * 获取主持人主键ID
     *
     * @return id - 主持人主键ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主持人主键ID
     *
     * @param id 主持人主键ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取主持人名称
     *
     * @return host_name - 主持人名称
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * 设置主持人名称
     *
     * @param hostName 主持人名称
     */
    public void setHostName(String hostName) {
        this.hostName = hostName == null ? null : hostName.trim();
    }

    /**
     * 获取主持人擅长类型
     *
     * @return host_category_like - 主持人擅长类型
     */
    public String getHostCategoryLike() {
        return hostCategoryLike;
    }

    /**
     * 设置主持人擅长类型
     *
     * @param hostCategoryLike 主持人擅长类型
     */
    public void setHostCategoryLike(String hostCategoryLike) {
        this.hostCategoryLike = hostCategoryLike == null ? null : hostCategoryLike.trim();
    }
}