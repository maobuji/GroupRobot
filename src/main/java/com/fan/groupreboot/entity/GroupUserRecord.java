package com.fan.groupreboot.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Administrator on 2018/6/27.
 */
public class GroupUserRecord {

    public GroupUserRecord() {

    }

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    // 用户名
    private String name;

    // 所属群名
    private String groupName;

    // 格式为 YYYYMMDD,每天一条记录
    private String recordDate;

    //
    private int activeCount;

}
