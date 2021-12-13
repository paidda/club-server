package com.javaclimb.club.controller;

import com.javaclimb.club.domain.SysUser;
import com.javaclimb.club.service.impl.SysUserServiceImpl;
import com.javaclimb.club.utils.Consts;
import com.javaclimb.club.utils.PageQuery;
import com.javaclimb.club.utils.RetCode;
import com.javaclimb.club.utils.RetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("user")
public class SysUserController {

    @Autowired
    private SysUserServiceImpl sysUserService;

    // 获取用户列表
    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    public RetResult getUserList(SysUser sysUser, PageQuery pageQuery) {
        return sysUserService.getUserList(sysUser, pageQuery);
    }

    // 添加用户
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public RetResult addUser(SysUser sysUser) {
        return sysUserService.addUser(sysUser);
    }

    // 更新用户
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public RetResult updateUser(SysUser sysUser) {
        return sysUserService.updateUser(sysUser);
    }

    // 删除用户
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public RetResult deleteUser(SysUser sysUser) {
        return sysUserService.deleteUser(sysUser);
    }

    // 重置密码
    @RequestMapping(value = "/restPassword", method = RequestMethod.POST)
    public RetResult restPassword(SysUser sysUser) {
        return sysUserService.restPassword(sysUser);
    }

    // 修改密码
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public RetResult updatePassword(SysUser sysUser) {
        return sysUserService.updatePassword(sysUser);
    }
}






















