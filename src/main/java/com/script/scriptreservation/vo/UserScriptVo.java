package com.script.scriptreservation.vo;

public class UserScriptVo {
    //点赞状态  点赞为0  点踩为1
    private Integer goodStatus;
    //收藏状态  0为未收藏 非0为收藏
    private Integer collectionStatus;

    private String userId;

    private String scriptId;

    public Integer getGoodStatus() {
        return goodStatus;
    }

    public void setGoodStatus(Integer goodStatus) {
        this.goodStatus = goodStatus;
    }

    public Integer getCollectionStatus() {
        return collectionStatus;
    }

    public void setCollectionStatus(Integer collectionStatus) {
        this.collectionStatus = collectionStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getScriptId() {
        return scriptId;
    }

    public void setScriptId(String scriptId) {
        this.scriptId = scriptId;
    }
}
