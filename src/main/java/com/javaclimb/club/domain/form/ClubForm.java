package com.javaclimb.club.domain.form;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class ClubForm {
    /**
     * 社团名称
     */
    private String name;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 社团状态,1已停止，0未停止
     */
    private String stop;
}