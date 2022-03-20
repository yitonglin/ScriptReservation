package com.script.scriptreservation.po;

import javax.persistence.*;

@Table(name = "comments")
public class Comments {
    /**
     * 评论主键ID
     */
    @Id
    private String id;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 剧本ID
     */
    @Column(name = "script_id")
    private String scriptId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论时间
     */
    private String time;

    /**
     * 获取评论主键ID
     *
     * @return id - 评论主键ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置评论主键ID
     *
     * @param id 评论主键ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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
     * 获取评论内容
     *
     * @return content - 评论内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置评论内容
     *
     * @param content 评论内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取评论时间
     *
     * @return time - 评论时间
     */
    public String getTime() {
        return time;
    }

    /**
     * 设置评论时间
     *
     * @param time 评论时间
     */
    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }
}