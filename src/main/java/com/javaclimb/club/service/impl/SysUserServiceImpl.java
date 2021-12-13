package com.javaclimb.club.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaclimb.club.dao.SysUserMapper;
import com.javaclimb.club.dao.jpa.SysUserMapperJpa;
import com.javaclimb.club.domain.SysUser;
import com.javaclimb.club.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SysUserServiceImpl {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserMapperJpa sysUserMapperJpa;

    // 登录校验接口
    public SysUser verifyPassword(String no, String password) {
        if (StringUtils.isEmpty(no) || StringUtils.isEmpty(password)) {
            return null;
        }
        // 查找用户信息
        return sysUserMapper.verifyPassword(no, password);
    }

    // 获取用户列表
    public RetResult getUserList(SysUser sysUser, PageQuery pageQuery) {
        RetResult retResult = new RetResult();
        // 开启分页
        PageHelper.startPage(pageQuery.getPage(), pageQuery.getLimit());
        Page<SysUser> page = (Page<SysUser>) sysUserMapper.getUserList(sysUser);
        PageInfo<SysUser> info = page.toPageInfo();
        retResult.setData(new PageResult(info.getTotal(), info.getList()));
        System.out.println(AuthUser.getLoginUser());
        return retResult;
    }

    // 添加用户
    public RetResult addUser(SysUser sysUser) {
        RetResult retResult = new RetResult();
        // 判重复
        SysUser query = new SysUser();
        query.setNo(sysUser.getNo());
        Example example = Example.of(query);
        long count = sysUserMapperJpa.count(example);
        if (count != 0) {
            retResult.setCode(RetCode.FAIL);
            retResult.setMsg("学号已存在，请检查");
            return retResult;
        }
        // 保存到数据库
        sysUserMapperJpa.save(sysUser);
        return retResult;
    }

    // 更新用户
    public RetResult updateUser(SysUser sysUser) {
        RetResult retResult = new RetResult();
        SysUser user = sysUserMapperJpa.getOne(sysUser.getId());
        if (null == user) {
            retResult.setCode(RetCode.FAIL);
            retResult.setMsg("用户不存在，请刷新重试");
            return retResult;
        }
        user.setAddr(sysUser.getAddr());
        user.setCollege(sysUser.getCollege());
        user.setFlag(sysUser.getFlag());
        user.setStudeClass(sysUser.getStudeClass());
        user.setPhone(sysUser.getPhone());
        user.setPassword(sysUser.getPassword());
        // 保存到数据库
        sysUserMapperJpa.save(user);
        return retResult;
    }

    // 删除用户
    public RetResult deleteUser(SysUser sysUser) {
        RetResult retResult = new RetResult();
        // 删除数据库用户数据
        sysUserMapperJpa.deleteById(sysUser.getId());
        return retResult;
    }

    // 重置密码
    public RetResult restPassword(SysUser sysUser) {
        RetResult retResult = new RetResult();
        SysUser user = sysUserMapperJpa.getOne(sysUser.getId());
        if (null == user) {
            retResult.setCode(RetCode.FAIL);
            retResult.setMsg("用户不存在，请刷新重试");
            return retResult;
        }
        user.setPassword(Consts.REST_PASSWORD);
        // 保存到数据库
        sysUserMapperJpa.save(user);
        return retResult;
    }

    // 修改密码
    public RetResult updatePassword(SysUser sysUser) {
        RetResult retResult = new RetResult();
        SysUser user = sysUserMapperJpa.getOne(sysUser.getId());
        if (null == user) {
            retResult.setCode(RetCode.FAIL);
            retResult.setMsg("用户不存在，请刷新重试");
            return retResult;
        }
        user.setPassword(sysUser.getPassword());
        // 保存到数据库
        sysUserMapperJpa.save(user);
        return retResult;
    }
}
