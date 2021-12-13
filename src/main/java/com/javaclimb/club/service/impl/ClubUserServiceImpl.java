package com.javaclimb.club.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaclimb.club.dao.ClubMapperJpa;
import com.javaclimb.club.dao.ClubUserMapper;
import com.javaclimb.club.dao.jpa.ClubUserMapperJpa;
import com.javaclimb.club.domain.Club;
import com.javaclimb.club.domain.ClubUser;
import com.javaclimb.club.domain.SysUser;
import com.javaclimb.club.domain.form.ClubUserForm;
import com.javaclimb.club.domain.vo.ClubUserVO;
import com.javaclimb.club.domain.vo.ClubVO;
import com.javaclimb.club.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class ClubUserServiceImpl {

    @Autowired
    private ClubUserMapper clubUserMapper;

    @Autowired
    private ClubUserMapperJpa clubUserMapperJpa;

    @Autowired
    private ClubMapperJpa clubMapperJpa;

    // 加入社团
    public RetResult addClubUser(ClubUser clubUser) {
        RetResult retResult = new RetResult();
        Club club1 = clubMapperJpa.getOne(clubUser.getClubId());
        if (null == club1) {
            retResult.setCode(RetCode.FAIL);
            retResult.setMsg("社团不存在，请刷新重试");
            return retResult;
        }
        SysUser sysUser = AuthUser.getLoginUser();
        clubUser.setPass("2");
        clubUser.setLeader("0");
        clubUser.setUserId(sysUser.getId());
        clubUser.setCrtTime(new Date());
        clubUserMapperJpa.save(clubUser);
        return retResult;
    }

    // 设置社长
    public RetResult updateClubUser(ClubUser clubUser) {
        RetResult retResult = new RetResult();
        Club club1 = clubMapperJpa.getOne(clubUser.getClubId());
        if (null == club1) {
            retResult.setCode(RetCode.FAIL);
            retResult.setMsg("社团不存在，请刷新重试");
            return retResult;
        }
        // 去除旧社长
        clubUserMapper.deleteOldLeader(clubUser.getClubId());
        // 更新新社长
        ClubUser clubUser1 = clubUserMapperJpa.getOne(clubUser.getId());
        clubUser1.setLeader(clubUser.getLeader());
        clubUserMapperJpa.save(clubUser1);
        return retResult;
    }

    // 退出社团
    public RetResult deleteClubUser(ClubUser clubUser) {
        RetResult retResult = new RetResult();
        clubUserMapperJpa.deleteById(clubUser.getId());
        return retResult;
    }

    // 审批社团成员
    public RetResult passClubUser(ClubUser clubUser) {
        RetResult retResult = new RetResult();
        ClubUser clubUser1 = clubUserMapperJpa.getOne(clubUser.getId());
        clubUser1.setPass(clubUser.getPass());
        clubUserMapperJpa.save(clubUser1);
        return retResult;
    }

    // 获取社团用户列表
    public RetResult getClubUserList(ClubUserForm clubUserForm, PageQuery pageQuery) {
        RetResult retResult = new RetResult();
        // 开启分页
        PageHelper.startPage(pageQuery.getPage(), pageQuery.getLimit());
        Page<ClubUserVO> page = (Page<ClubUserVO>) clubUserMapper.getClubUserList(clubUserForm);
        PageInfo<ClubUserVO> info = page.toPageInfo();
        retResult.setData(new PageResult(info.getTotal(), info.getList()));
        return retResult;
    }
}
