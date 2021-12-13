package com.javaclimb.club.domain.form;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class ActiveUserForm {
    /**
     * id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 活动id
     */
    private Integer activeId;

    /**
     * 报名时间
     */
    private Date crtTime;

    /**
     * 是否退出，1是，0否
     */
    private String back;
}