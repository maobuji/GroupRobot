package com.fan.groupreboot.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Administrator on 2018/6/27.
 */
@Entity // 标注为实体
@Table(name = "t_grouprecord")  //表名
public class GroupRecord {

    public GroupRecord() {
    }

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    // 群名称
    private String name;

    // 群拥有者，这里指登录用户
    private String owner;

    // 群人数
    private int peopleNumber;

}
