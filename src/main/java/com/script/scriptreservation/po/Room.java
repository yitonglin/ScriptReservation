package com.script.scriptreservation.po;

import javax.persistence.*;

@Table(name = "room")
public class Room {
    /**
     * 房间表主键ID
     */
    @Id
    private String id;

    /**
     * 已有人数
     */
    @Column(name = "has_number")
    private Integer hasNumber;

    /**
     * 所需人数
     */
    @Column(name = "need_number")
    private Integer needNumber;

    /**
     * 获取房间表主键ID
     *
     * @return id - 房间表主键ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置房间表主键ID
     *
     * @param id 房间表主键ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取已有人数
     *
     * @return has_number - 已有人数
     */
    public Integer getHasNumber() {
        return hasNumber;
    }

    /**
     * 设置已有人数
     *
     * @param hasNumber 已有人数
     */
    public void setHasNumber(Integer hasNumber) {
        this.hasNumber = hasNumber;
    }

    /**
     * 获取所需人数
     *
     * @return need_number - 所需人数
     */
    public Integer getNeedNumber() {
        return needNumber;
    }

    /**
     * 设置所需人数
     *
     * @param needNumber 所需人数
     */
    public void setNeedNumber(Integer needNumber) {
        this.needNumber = needNumber;
    }
}