package com.javaclimb.club.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "active_user")
public class ActiveUser {
    /**
     * id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 活动id
     */
    @Column(name = "active_id")
    private Integer activeId;

    /**
     * 报名时间
     */
    @Column(name = "crt_time")
    private Date crtTime;

    /**
     * 是否退出，1是，0否
     */
    @Column(name = "back")
    private String back;
}