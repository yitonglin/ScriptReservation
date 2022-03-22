package com.script.scriptreservation.vo;

import com.script.scriptreservation.enums.ApplicationEnum;

public class FailResult extends Result{

    private static final long serialVersionUID = -6073157176763840816L;

    public FailResult(){
        setStatus(true);
        setCode(ApplicationEnum.FAIT.getCode());
        setMsg(ApplicationEnum.FAIT.getMessage());
    }

    public FailResult(ApplicationEnum applicationEnum){
        setStatus(false);
        setCode(applicationEnum.getCode());
        setMsg(applicationEnum.getMessage());
    }
}
