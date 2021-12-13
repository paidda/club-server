package com.javaclimb.club.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "sys_notice")
public class SysNotice {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 内容
     */
    @Column(name = "content")
    private String content;

    /**
     * 是否发布
     */
    @Column(name = "publish")
    private String publish;

    /**
     * 创建时间
     */
    @Column(name = "crt_time")
    private Date crtTime;
}