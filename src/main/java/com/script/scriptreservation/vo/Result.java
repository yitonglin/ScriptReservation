package com.script.scriptreservation.vo;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private static final long seriaVersionUID = 3149361523750900688L;

    /**
     * true:业务执行成功  false:业务执行失败
     */
    private Boolean status;

    /**
     * 状态码
     */
    private String code;

    /**
     * 消息
     */
    private String msg;

    /**
     * 结果数据
     */
    private T data;

    public static long getSeriaVersionUID() {
        return seriaVersionUID;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
