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
     * 房间号
     */
    @Column(name = "room_id")
    private String roomId;

    /**
     * 剧本ID
     */
    @Column(name = "script")
    private String script;

    /**
     * 房间创建时间
     */
    @Column(name = "create_time")
    private Long createTime;

    /**
     * 已有人数
     */
    @Column(name = "has_number")
    private Integer hasNumber;

    /**
     * 拼团成功状态
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 主持人ID
     */
    @Column(name = "host_id")
    private String hostId;

    /**
     * 所需人数
     */
    @Column(name = "need_number")
    private Integer needNumber;

    /**
     * 剧本开始时间
     */
    @Column(name = "start_time")
    private Integer startTime;

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

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }
}