package com.javaclimb.club.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "club_user")
public class ClubUser {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 社团id
     */
    @Column(name = "club_id")
    private Integer clubId;

    /**
     * 是否通过审核，1是2否
     */
    @Column(name = "pass")
    private String pass;

    /**
     * 申请时间
     */
    @Column(name = "crt_time")
    private Date crtTime;

    /**
     * 是否退出，1是，0否
     */
    @Column(name = "back")
    private String back;

    /**
     * 是否领导，1是，0否
     */
    @Column(name = "leader")
    private String leader;
}