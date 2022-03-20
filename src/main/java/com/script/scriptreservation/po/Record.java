package com.script.scriptreservation.po;

import javax.persistence.*;

@Table(name = "record")
public class Record {
    /**
     * 主键ID
     */
    @Id
    private String id;

    /**
     * 剧本ID
     */
    @Column(name = "script_id")
    private String scriptId;

    /**
     * 时间记录
     */
    private String time;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取剧本ID
     *
     * @return script_id - 剧本ID
     */
    public String getScriptId() {
        return scriptId;
    }

    /**
     * 设置剧本ID
     *
     * @param scriptId 剧本ID
     */
    public void setScriptId(String scriptId) {
        this.scriptId = scriptId == null ? null : scriptId.trim();
    }

    /**
     * 获取时间记录
     *
     * @return time - 时间记录
     */
    public String getTime() {
        return time;
    }

    /**
     * 设置时间记录
     *
     * @param time 时间记录
     */
    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}