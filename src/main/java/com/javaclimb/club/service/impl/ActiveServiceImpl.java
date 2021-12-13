package com.javaclimb.club.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaclimb.club.dao.ActiveMapper;
import com.javaclimb.club.dao.jpa.ActiveMapperJpa;
import com.javaclimb.club.domain.Active;
import com.javaclimb.club.domain.Club;
import com.javaclimb.club.domain.SysUser;
import com.javaclimb.club.domain.form.ActiveForm;
import com.javaclimb.club.domain.vo.ActiveVO;
import com.javaclimb.club.domain.vo.ClubVO;
import com.javaclimb.club.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Transactional
public class ActiveServiceImpl {

    @Autowired
    private ActiveMapper activeMapper;

    @Autowired
    private ActiveMapperJpa activeMapperJpa;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    // 获取活动列表
    public RetResult getActiveList(ActiveForm activeForm, PageQuery pageQuery) {
        RetResult retResult = new RetResult();
        // 当前登录用户id（用于查找当前登录用户是否加入该社团）
        SysUser sysUser = AuthUser.getLoginUser();
        activeForm.setUserId(sysUser.getId());
        // 开启分页
        PageHelper.startPage(pageQuery.getPage(), pageQuery.getLimit());
        Page<ActiveVO> page = (Page<ActiveVO>) activeMapper.getActiveList(activeForm);
        PageInfo<ActiveVO> info = page.toPageInfo();
        retResult.setData(new PageResult(info.getTotal(), info.getList()));
        return retResult;
    }

    // 添加活动
    public RetResult addActive(ActiveForm activeForm) {
        RetResult retResult = new RetResult();
        SysUser sysUser = AuthUser.getLoginUser();
        Active active = new Active();
        active.setId(activeForm.getId());
        active.setName(activeForm.getName());
        active.setContent(activeForm.getContent());
        try {
            active.setActiveTime(format.parse(activeForm.getActiveTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        active.setCrtId(sysUser.getId());
        active.setCrtName(sysUser.getName());
        active.setCrtTime(new Date());
        activeMapperJpa.save(active);
        return retResult;
    }

    // 更新活动
    public RetResult updateActive(ActiveForm activeForm) {
        RetResult retResult = new RetResult();
        Active active1 = activeMapperJpa.getOne(activeForm.getId());
        if (null == active1) {
            retResult.setCode(RetCode.FAIL);
            retResult.setMsg("活动不存在，请刷新重试");
            return retResult;
        }
        active1.setName(activeForm.getName());
        active1.setContent(activeForm.getContent());
        try {
            active1.setActiveTime(format.parse(activeForm.getActiveTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        activeMapperJpa.save(active1);
        return retResult;
    }

    // 删除活动
    public RetResult deleteActive(Active active) {
        RetResult retResult = new RetResult();
        Active active1 = activeMapperJpa.getOne(active.getId());
        if (null == active1) {
            retResult.setCode(RetCode.FAIL);
            retResult.setMsg("活动不存在，请刷新重试");
            return retResult;
        }
        activeMapperJpa.deleteById(active1.getId());
        return retResult;
    }
}
