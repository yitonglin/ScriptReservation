package com.script.scriptreservation.vo;

import com.script.scriptreservation.po.Script;

public class ScriptVo extends Script {

    //评分
    private Double fraction;

    //好评数
    private Integer goodCount;
    //差评数
    private Integer poorCount;
    //评论总数
    private Integer count;

    public Double getFraction() {
        return fraction;
    }

    public void setFraction(Double fraction) {
        this.fraction = fraction;
    }

    public Integer getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(Integer goodCount) {
        this.goodCount = goodCount;
    }

    public Integer getPoorCount() {
        return poorCount;
    }

    public void setPoorCount(Integer poorCount) {
        this.poorCount = poorCount;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
