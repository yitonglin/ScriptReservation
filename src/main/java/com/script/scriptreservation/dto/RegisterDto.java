package com.script.scriptreservation.dto;

import lombok.Data;
import javax.activation.*;

@Data
public class RegisterDto {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;
}
