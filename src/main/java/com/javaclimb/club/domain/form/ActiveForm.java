package com.javaclimb.club.domain.form;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class ActiveForm {
    /**
     * id
     */
    private Integer id;

    /**
     * 活动名称
     */
    private String name;

    /**
     * id
     */
    private Integer userId;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 活动内容
     */
    private String content;

    /**
     * 活动时间
     */
    private String activeTime;

    /**
     * 创建人id
     */
    private String crtId;

    /**
     * 创建人姓名
     */
    private String crtName;

    /**
     * 创建时间
     */
    private Date crtTime;
}