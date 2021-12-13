package com.javaclimb.club.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaclimb.club.dao.ActiveUserMapper;
import com.javaclimb.club.dao.jpa.ActiveUserMapperJpa;
import com.javaclimb.club.domain.ActiveUser;
import com.javaclimb.club.domain.SysUser;
import com.javaclimb.club.domain.form.ActiveUserForm;
import com.javaclimb.club.domain.vo.ActiveUserVO;
import com.javaclimb.club.domain.vo.MyActiveVO;
import com.javaclimb.club.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class ActiveUserServiceImpl {

    @Autowired
    private ActiveUserMapper activeUserMapper;

    @Autowired
    private ActiveUserMapperJpa activeUserMapperJpa;

    // 加入活动
    public RetResult addActiveUser(ActiveUser activeUser) {
        RetResult retResult = new RetResult();
        SysUser sysUser = AuthUser.getLoginUser();
        activeUser.setUserId(sysUser.getId());
        activeUser.setCrtTime(new Date());
        activeUserMapperJpa.save(activeUser);
        return retResult;
    }

    // 退出活动
    public RetResult deleteActiveUser(ActiveUser activeUser) {
        RetResult retResult = new RetResult();
        ActiveUser activeUser1 = activeUserMapperJpa.getOne(activeUser.getId());
        if (null == activeUser1) {
            retResult.setCode(RetCode.FAIL);
            retResult.setMsg("活动不存在，请刷新重试");
            return retResult;
        }
        activeUserMapperJpa.deleteById(activeUser1.getId());
        return retResult;
    }

    // 我的活动列表
    public RetResult myActiveUserList(ActiveUserForm activeUserForm, PageQuery pageQuery) {
        RetResult retResult = new RetResult();
        // 当前登录用户id（用于查找当前登录用户是否加入该社团）
        SysUser sysUser = AuthUser.getLoginUser();
        activeUserForm.setUserId(sysUser.getId());
        // 开启分页
        PageHelper.startPage(pageQuery.getPage(), pageQuery.getLimit());
        Page<MyActiveVO> page = (Page<MyActiveVO>) activeUserMapper.myActiveUserList(activeUserForm);
        PageInfo<MyActiveVO> info = page.toPageInfo();
        retResult.setData(new PageResult(info.getTotal(), info.getList()));
        return retResult;
    }

    // 活动人员列表
    public RetResult getActiveUserList(ActiveUserForm activeUserForm, PageQuery pageQuery) {
        RetResult retResult = new RetResult();
        // 开启分页
        PageHelper.startPage(pageQuery.getPage(), pageQuery.getLimit());
        Page<ActiveUserVO> page = (Page<ActiveUserVO>) activeUserMapper.getActiveUserList(activeUserForm);
        PageInfo<ActiveUserVO> info = page.toPageInfo();
        retResult.setData(new PageResult(info.getTotal(), info.getList()));
        return retResult;
    }
}
