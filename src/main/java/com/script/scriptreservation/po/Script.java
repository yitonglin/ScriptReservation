package com.script.scriptreservation.po;

import javax.persistence.*;

@Table(name = "script")
public class Script {
    /**
     * 剧本主键ID
     */
    @Id
    private String id;

    /**
     * 分类ID
     */
    @Column(name = "category_id")
    private String categoryId;

    /**
     * 剧本名
     */
    @Column(name = "script_name")
    private String scriptName;

    /**
     * 剧本介绍
     */
    @Column(name = "script_context")
    private String scriptContext;

    /**
     * 浏览量
     */
    @Column(name = "look_number")
    private Integer lookNumber;

    /**
     * 评论数
     */
    @Column(name = "reply_number")
    private Integer replyNumber;

    /**
     * 购入时间
     */
    @Column(name = "pay_time")
    private Long payTime;

    /**
     * 图片地址
     */
    @Column(name = "photo_adress")
    private String photoAdress;

    /**
     * 剧本所需人数
     */
    @Column(name = "person_number")
    private Integer personNumber;

    /**
     * 游戏时长
     */
    @Column(name = "game_time")
    private String gameTime;

    /**
     * 剧本标签
     */
    private String lable;

    /**
     * 已拼场次
     */
    private Integer salenum;

    /**
     * 剧本价格
     */
    @Column(name = "script_money")
    private Integer scriptMoney;

    /**
     * 剧本难度
     */
    private Integer level;

    //评分
    private Double fraction;

    //好评数
    private Integer goodCount;
    //差评数
    private Integer poorCount;
    //评论总数
    private Integer count;

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

    /**
     * 点赞数
     */
    private Integer greatNum;

    //剧本亮点
    private String scriptSunPoint;

    //剧本发行人
    private String createUser;

    /**
     * 点踩数
     */
    private Integer stepNum;

    //剧本亮点
    private String scriptSun;

    //发行人
    private String createName;

    public String getScriptSunPoint() {
        return scriptSunPoint;
    }

    public Double getFraction() {
        return fraction;
    }

    public void setFraction(Double fraction) {
        this.fraction = fraction;
    }

    public void setScriptSunPoint(String scriptSunPoint) {
        this.scriptSunPoint = scriptSunPoint;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getScriptSun() {
        return scriptSun;
    }

    public void setScriptSun(String scriptSun) {
        this.scriptSun = scriptSun;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Integer getGreatNum() {
        return greatNum;
    }

    public void setGreatNum(Integer greatNum) {
        this.greatNum = greatNum;
    }

    public Integer getStepNum() {
        return stepNum;
    }

    public void setStepNum(Integer stepNum) {
        this.stepNum = stepNum;
    }

    /**
     * 获取剧本主键ID
     *
     * @return id - 剧本主键ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置剧本主键ID
     *
     * @param id 剧本主键ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取分类ID
     *
     * @return category_id - 分类ID
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * 设置分类ID
     *
     * @param categoryId 分类ID
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    /**
     * 获取剧本名
     *
     * @return script_name - 剧本名
     */
    public String getScriptName() {
        return scriptName;
    }

    /**
     * 设置剧本名
     *
     * @param scriptName 剧本名
     */
    public void setScriptName(String scriptName) {
        this.scriptName = scriptName == null ? null : scriptName.trim();
    }

    /**
     * 获取剧本介绍
     *
     * @return script_context - 剧本介绍
     */
    public String getScriptContext() {
        return scriptContext;
    }

    /**
     * 设置剧本介绍
     *
     * @param scriptContext 剧本介绍
     */
    public void setScriptContext(String scriptContext) {
        this.scriptContext = scriptContext == null ? null : scriptContext.trim();
    }

    /**
     * 获取浏览量
     *
     * @return look_number - 浏览量
     */
    public Integer getLookNumber() {
        return lookNumber;
    }

    /**
     * 设置浏览量
     *
     * @param lookNumber 浏览量
     */
    public void setLookNumber(Integer lookNumber) {
        this.lookNumber = lookNumber;
    }

    /**
     * 获取评论数
     *
     * @return reply_number - 评论数
     */
    public Integer getReplyNumber() {
        return replyNumber;
    }

    /**
     * 设置评论数
     *
     * @param replyNumber 评论数
     */
    public void setReplyNumber(Integer replyNumber) {
        this.replyNumber = replyNumber;
    }

    public Long getPayTime() {
        return payTime;
    }

    public void setPayTime(Long payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取图片地址
     *
     * @return photo_adress - 图片地址
     */
    public String getPhotoAdress() {
        return photoAdress;
    }

    /**
     * 设置图片地址
     *
     * @param photoAdress 图片地址
     */
    public void setPhotoAdress(String photoAdress) {
        this.photoAdress = photoAdress == null ? null : photoAdress.trim();
    }

    /**
     * 获取剧本所需人数
     *
     * @return person_number - 剧本所需人数
     */
    public Integer getPersonNumber() {
        return personNumber;
    }

    /**
     * 设置剧本所需人数
     *
     * @param personNumber 剧本所需人数
     */
    public void setPersonNumber(Integer personNumber) {
        this.personNumber = personNumber;
    }

    /**
     * 获取游戏时长
     *
     * @return game_time - 游戏时长
     */
    public String getGameTime() {
        return gameTime;
    }

    /**
     * 设置游戏时长
     *
     * @param gameTime 游戏时长
     */
    public void setGameTime(String gameTime) {
        this.gameTime = gameTime == null ? null : gameTime.trim();
    }

    /**
     * 获取剧本标签
     *
     * @return lable - 剧本标签
     */
    public String getLable() {
        return lable;
    }

    /**
     * 设置剧本标签
     *
     * @param lable 剧本标签
     */
    public void setLable(String lable) {
        this.lable = lable == null ? null : lable.trim();
    }

    /**
     * 获取已拼场次
     *
     * @return salenum - 已拼场次
     */
    public Integer getSalenum() {
        return salenum;
    }

    /**
     * 设置已拼场次
     *
     * @param salenum 已拼场次
     */
    public void setSalenum(Integer salenum) {
        this.salenum = salenum;
    }

    /**
     * 获取剧本价格
     *
     * @return script_money - 剧本价格
     */
    public Integer getScriptMoney() {
        return scriptMoney;
    }

    /**
     * 设置剧本价格
     *
     * @param scriptMoney 剧本价格
     */
    public void setScriptMoney(Integer scriptMoney) {
        this.scriptMoney = scriptMoney;
    }

    /**
     * 获取剧本难度
     *
     * @return level - 剧本难度
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置剧本难度
     *
     * @param level 剧本难度
     */
    public void setLevel(Integer level) {
        this.level = level;
    }
}