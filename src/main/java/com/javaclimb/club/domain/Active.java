package com.javaclimb.club.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "active")
public class Active {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 活动名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 活动内容
     */
    @Column(name = "content")
    private String content;

    /**
     * 活动时间
     */
    @Column(name = "active_time")
    private Date activeTime;

    /**
     * 创建人id
     */
    @Column(name = "crt_id")
    private Integer crtId;

    /**
     * 创建人姓名
     */
    @Column(name = "crt_name")
    private String crtName;

    /**
     * 创建时间
     */
    @Column(name = "crt_time")
    private Date crtTime;
}