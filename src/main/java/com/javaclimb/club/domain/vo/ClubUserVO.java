package com.javaclimb.club.domain.vo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class ClubUserVO {
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 社团id
     */
    private Integer clubId;

    /**
     * 是否通过审核，1是2否
     */
    private String pass;

    /**
     * 申请时间
     */
    private Date crtTime;

    /**
     * 是否退出，1是，0否
     */
    private String back;

    /**
     * 是否领导，1是，0否
     */
    private String leader;

    /**
     * 姓名
     */
    private String name;


    /**
     * 标识位，1：管理员，2：学生
     */
    private String flag;

    /**
     * 宿舍地址
     */
    private String addr;

    /**
     * 学院
     */
    private String college;

    /**
     * 班级
     */
    private String studeClass;

    /**
     * 手机
     */
    private String phone;

    /**
     * 学号
     */
    private String no;
}