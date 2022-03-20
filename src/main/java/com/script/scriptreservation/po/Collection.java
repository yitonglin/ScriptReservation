package com.script.scriptreservation.po;

import javax.persistence.*;

@Table(name = "collection")
public class Collection {
    /**
     * 收藏ID
     */
    @Id
    private String id;

    /**
     * 剧本ID
     */
    @Column(name = "script_id")
    private String scriptId;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 获取收藏ID
     *
     * @return id - 收藏ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置收藏ID
     *
     * @param id 收藏ID
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