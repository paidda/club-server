package com.javaclimb.club.controller;

import com.javaclimb.club.domain.ClubUser;
import com.javaclimb.club.domain.form.ClubUserForm;
import com.javaclimb.club.service.impl.ClubUserServiceImpl;
import com.javaclimb.club.utils.PageQuery;
import com.javaclimb.club.utils.RetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("club")
public class ClubUserController {

    @Autowired
    private ClubUserServiceImpl clubUserService;

    // 获取社团用户列表
    @RequestMapping(value = "/getClubUserList", method = RequestMethod.POST)
    public RetResult getClubUserList(ClubUserForm clubUserForm, PageQuery pageQuery) {
        return clubUserService.getClubUserList(clubUserForm, pageQuery);
    }

    // 加入社团（普通用户报名）
    @RequestMapping(value = "/addClubUser", method = RequestMethod.POST)
    public RetResult addClubUser(ClubUser clubUser) {
        return clubUserService.addClubUser(clubUser);
    }

    // 设置社长
    @RequestMapping(value = "/updateClubUser", method = RequestMethod.POST)
    public RetResult updateClubUser(ClubUser clubUser) {
        return clubUserService.updateClubUser(clubUser);
    }

    // 退出社团
    @RequestMapping(value = "/deleteClubUser", method = RequestMethod.POST)
    public RetResult deleteClubUser(ClubUser clubUser) {
        return clubUserService.deleteClubUser(clubUser);
    }

    // 审批社团成员
    @RequestMapping(value = "/passClubUser", method = RequestMethod.POST)
    public RetResult passClubUser(ClubUser clubUser) {
        return clubUserService.passClubUser(clubUser);
    }

}






















