package com.script.scriptreservation.service;

import com.script.scriptreservation.vo.Result;

public interface IHostService {

    Result selectFreeHost(Long startTime);
    Result selectHostById(String id);
    Result selectIndexHost();
}
