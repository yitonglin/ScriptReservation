package com.script.scriptreservation.enums;

import lombok.Getter;

@Getter
public enum ApplicationEnum {

    SUCCESS("200","业务执行成功"),
    FAIT("500","业务执行失败"),
    USER_NAME_PERETITION("4001","用户名已存在"),
    USRR_OR_PWD_ERR("4002","用户名或密码错误"),
    NO_LOGIN("4003","未登录"),
    YES_LOGIN("4004","已登录"),
    REQUEST_FREQUENTLY("4005","请求太过频繁");

    /**
     * 设计原则
     * 2xxx 业务执行成功
     * 4xxx 由于用户导致的错误，比如注册时，重复注册导致的注册失败
     * 5xxx 由于系统原因导致的错误
     */
    private String code;

    private String message;

    ApplicationEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}