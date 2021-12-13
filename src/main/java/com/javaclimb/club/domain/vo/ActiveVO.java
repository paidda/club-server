package com.javaclimb.club.domain.vo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class ActiveVO {
    /**
     * id
     */
    private Integer id;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 活动内容
     */
    private String content;

    /**
     * 活动时间
     */
    private Date activeTime;

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

    /**
     * 登录人员是否参加
     */
    private String flag;
}