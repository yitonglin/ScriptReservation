package com.script.scriptreservation.service;

import com.script.scriptreservation.vo.LimitPageVo;
import com.script.scriptreservation.vo.Result;

public interface IcommentsService {
    Result scriptComments(LimitPageVo limitPageVo);
}
