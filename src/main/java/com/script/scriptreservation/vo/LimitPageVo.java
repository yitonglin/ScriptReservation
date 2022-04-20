package com.script.scriptreservation.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class LimitPageVo<T> implements Serializable {
    //查询信息  可用于传递剧本名称和用户ID
    private String filed;

    //需要查询的页数
    private Integer pageNum;

    //拼接模糊查询信息
    private String likeFiled;

    //页数总数
    private Integer count;

    //分类ID 传则分类 不传则不分类
    private String categoryId;

    //应该查询开始的行数
    private Integer pageCount;

    //分页的条数
    private Integer len;

    //数据信息
    private T listData;

}
