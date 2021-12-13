package com.javaclimb.club.domain.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ClubVO {
    /**
     * id
     */
    private Integer id;

    /**
     * 社团名称
     */
    private String name;

    /**
     * 社团简介
     */
    private String content;

    /**
     * 社团状态,1已停止，0未停止
     */
    private String stop;

    /**
     * 创建时间
     */
    private Date crtTime;

    /**
     * 社长id
     */
    private String userId;

    /**
     * 社长名称
     */
    private String userName;

    /**
     * 登录用户是否加入该社团
     */
    private String flag;

    /**
     * 是否社长
     */
    private String leader;

    /**
     * 审批状态
     */
    private String pass;
}