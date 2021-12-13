package com.javaclimb.club.controller;

import com.javaclimb.club.domain.ActiveUser;
import com.javaclimb.club.domain.form.ActiveUserForm;
import com.javaclimb.club.service.impl.ActiveUserServiceImpl;
import com.javaclimb.club.utils.PageQuery;
import com.javaclimb.club.utils.RetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("active")
public class ActiveUserController {

    @Autowired
    private ActiveUserServiceImpl activeUserService;

    // 活动人员列表
    @RequestMapping(value = "/getActiveUserList", method = RequestMethod.POST)
    public RetResult getActiveUserList(ActiveUserForm activeUserForm, PageQuery pageQuery) {
        return activeUserService.getActiveUserList(activeUserForm, pageQuery);
    }

    // 我的活动列表
    @RequestMapping(value = "/myActiveUserList", method = RequestMethod.POST)
    public RetResult myActiveUserList(ActiveUserForm activeUserForm, PageQuery pageQuery) {
        return activeUserService.myActiveUserList(activeUserForm, pageQuery);
    }

    // 加入活动
    @RequestMapping(value = "/addActiveUser", method = RequestMethod.POST)
    public RetResult addActiveUser(ActiveUser activeUser) {
        return activeUserService.addActiveUser(activeUser);
    }

    // 退出活动
    @RequestMapping(value = "/deleteActiveUser", method = RequestMethod.POST)
    public RetResult deleteActiveUser(ActiveUser activeUser) {
        return activeUserService.deleteActiveUser(activeUser);
    }

}






















