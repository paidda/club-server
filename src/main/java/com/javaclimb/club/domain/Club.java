package com.javaclimb.club.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "club")
public class Club {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 社团名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 社团简介
     */
    @Column(name = "content")
    private String content;

    /**
     * 社团状态,1已停止，0未停止
     */
    @Column(name = "stop")
    private String stop;

    /**
     * 创建时间
     */
    @Column(name = "crt_time")
    private Date crtTime;
}