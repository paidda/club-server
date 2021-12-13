package com.javaclimb.club.domain.form;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class ClubUserForm {

    private Integer clubId;

    private String userName;
}