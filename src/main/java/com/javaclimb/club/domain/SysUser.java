package com.javaclimb.club.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "sys_user")
public class SysUser implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 姓名
     */
    @Column(name = "name")
    private String name;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 标识位，1：管理员，2：学生
     */
    @Column(name = "flag")
    private String flag;

    /**
     * 宿舍地址
     */
    @Column(name = "addr")
    private String addr;

    /**
     * 学院
     */
    @Column(name = "college")
    private String college;

    /**
     * 班级
     */
    @Column(name = "stude_class")
    private String studeClass;

    /**
     * 手机
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 学号
     */
    @Column(name = "no")
    private String no;
}
