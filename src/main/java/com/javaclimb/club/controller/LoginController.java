package com.javaclimb.club.controller;

import com.alibaba.fastjson.JSONObject;
import com.javaclimb.club.domain.SysUser;
import com.javaclimb.club.service.impl.SysUserServiceImpl;
import com.javaclimb.club.utils.AuthUser;
import com.javaclimb.club.utils.Consts;
import com.javaclimb.club.utils.RetCode;
import com.javaclimb.club.utils.RetResult;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    private SysUserServiceImpl adminService;

    //    判断是否登录成功
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public RetResult loginStatus(HttpServletRequest request, HttpSession session) {
        RetResult retResult = new RetResult();
        String no = request.getParameter("no");
        String password = request.getParameter("password");
        SysUser sysUser = adminService.verifyPassword(no, password);
        if (null != sysUser) {
            retResult.setCode(RetCode.SUCCESS);
            retResult.setMsg("登录成功");
            session.setAttribute(Consts.NO, sysUser.getNo());
            session.setAttribute(Consts.NAME, sysUser.getName());
            session.setAttribute("user", sysUser);
            // 保存登录信息至本地
            retResult.setData(sysUser);
            return retResult;
        }
        retResult.setCode(RetCode.FAIL);
        retResult.setMsg("用户名或密码错误");
        return retResult;
    }
}






















