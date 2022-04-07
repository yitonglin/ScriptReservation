package com.script.scriptreservation.po;

import javax.persistence.*;

@Table(name = "order")
public class Order {
    /**
     * 订单表主键ID
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
     * 房间号
     */
    @Column(name = "room_id")
    private String roomId;

    /**
     * 预约标志(0:拼场1:包场)
     */
    @Column(name = "order_flag")
    private Integer orderFlag;

    /**
     * 订单编号
     */
    @Column(name = "order_number")
    private String orderNumber;

    /**
     * 预约人数
     */
    @Column(name = "forward_num")
    private Integer forwardNum;

    /**
     * 预约日期
     */
    @Column(name = "forward_date")
    private Long forwardDate;

    /**
     * 预约实际付款
     */
    @Column(name = "order_money")
    private Integer orderMoney;

    /**
     * 订单创建时间
     */
    @Column(name = "create_time")
    private Long createTime;

    /**
     * 订单退款时间
     */
    @Column(name = "refund_time")
    private Long refundTime;

    /**
     * 订单状态(0:拼场[预约成功]1:已退款2:拼场[该场次已有*人，还差*人拼场成功]3:包场[预约成功]4:拼场[预约失败，已自动退款])
     */
    @Column(name = "order_status")
    private Integer orderStatus;

    /**
     * 获取订单表主键ID
     *
     * @return id - 订单表主键ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置订单表主键ID
     *
     * @param id 订单表主键ID
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
     * 获取房间号
     *
     * @return room_id - 房间号
     */
    public String getRoomId() {
        return roomId;
    }

    /**
     * 设置房间号
     *
     * @param roomId 房间号
     */
    public void setRoomId(String roomId) {
        this.roomId = roomId == null ? null : roomId.trim();
    }

    /**
     * 获取预约标志(0:拼场1:包场)
     *
     * @return order_flag - 预约标志(0:拼场1:包场)
     */
    public Integer getOrderFlag() {
        return orderFlag;
    }

    /**
     * 设置预约标志(0:拼场1:包场)
     *
     * @param orderFlag 预约标志(0:拼场1:包场)
     */
    public void setOrderFlag(Integer orderFlag) {
        this.orderFlag = orderFlag;
    }

    /**
     * 获取订单编号
     *
     * @return order_number - 订单编号
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * 设置订单编号
     *
     * @param orderNumber 订单编号
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    /**
     * 获取预约人数
     *
     * @return forward_num - 预约人数
     */
    public Integer getForwardNum() {
        return forwardNum;
    }

    /**
     * 设置预约人数
     *
     * @param forwardNum 预约人数
     */
    public void setForwardNum(Integer forwardNum) {
        this.forwardNum = forwardNum;
    }

    public Long getForwardDate() {
        return forwardDate;
    }

    public void setForwardDate(Long forwardDate) {
        this.forwardDate = forwardDate;
    }

    /**
     * 获取预约实际付款
     *
     * @return order_money - 预约实际付款
     */
    public Integer getOrderMoney() {
        return orderMoney;
    }

    /**
     * 设置预约实际付款
     *
     * @param orderMoney 预约实际付款
     */
    public void setOrderMoney(Integer orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Long refundTime) {
        this.refundTime = refundTime;
    }

    /**
     * 获取订单状态(0:拼场[预约成功]1:已退款2:拼场[该场次已有*人，还差*人拼场成功]3:包场[预约成功]4:拼场[预约失败，已自动退款])
     *
     * @return order_status - 订单状态(0:拼场[预约成功]1:已退款2:拼场[该场次已有*人，还差*人拼场成功]3:包场[预约成功]4:拼场[预约失败，已自动退款])
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * 设置订单状态(0:拼场[预约成功]1:已退款2:拼场[该场次已有*人，还差*人拼场成功]3:包场[预约成功]4:拼场[预约失败，已自动退款])
     *
     * @param orderStatus 订单状态(0:拼场[预约成功]1:已退款2:拼场[该场次已有*人，还差*人拼场成功]3:包场[预约成功]4:拼场[预约失败，已自动退款])
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
}