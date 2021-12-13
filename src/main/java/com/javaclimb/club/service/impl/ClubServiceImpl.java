package com.javaclimb.club.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaclimb.club.dao.ClubMapper;
import com.javaclimb.club.dao.ClubMapperJpa;
import com.javaclimb.club.domain.Club;
import com.javaclimb.club.domain.SysUser;
import com.javaclimb.club.domain.form.ClubForm;
import com.javaclimb.club.domain.vo.ClubVO;
import com.javaclimb.club.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class ClubServiceImpl {

    @Autowired
    private ClubMapper clubMapper;

    @Autowired
    private ClubMapperJpa clubMapperJpa;

    // 添加社团
    public RetResult addClub(Club club) {
        RetResult retResult = new RetResult();
        club.setStop("0");
        club.setCrtTime(new Date());
        clubMapperJpa.save(club);
        return retResult;
    }

    // 更新社团
    public RetResult updateClub(Club club) {
        RetResult retResult = new RetResult();
        Club club1 = clubMapperJpa.getOne(club.getId());
        if (null == club1) {
            retResult.setCode(RetCode.FAIL);
            retResult.setMsg("社团不存在，请刷新重试");
            return retResult;
        }
        club1.setName(club.getName());
        club1.setContent(club.getContent());
        clubMapperJpa.save(club1);
        return retResult;
    }

    // 删除社团
    public RetResult deleteClub(Club club) {
        RetResult retResult = new RetResult();
        Club club1 = clubMapperJpa.getOne(club.getId());
        if (null == club1) {
            retResult.setCode(RetCode.FAIL);
            retResult.setMsg("社团不存在，请刷新重试");
            return retResult;
        }
        clubMapperJpa.deleteById(club1.getId());
        return retResult;
    }

    // 启用停止社团
    public RetResult stopClub(Club club) {
        RetResult retResult = new RetResult();
        Club club1 = clubMapperJpa.getOne(club.getId());
        if (null == club1) {
            retResult.setCode(RetCode.FAIL);
            retResult.setMsg("社团不存在，请刷新重试");
            return retResult;
        }
        club1.setStop(club.getStop());
        clubMapperJpa.save(club1);
        return retResult;
    }

    // 获取社团列表
    public RetResult getClubList(ClubForm clubForm, PageQuery pageQuery) {
        RetResult retResult = new RetResult();
        // 当前登录用户id（用于查找当前登录用户是否加入该社团）
        SysUser sysUser = AuthUser.getLoginUser();
        clubForm.setUserId(sysUser.getId());
        // 开启分页
        PageHelper.startPage(pageQuery.getPage(), pageQuery.getLimit());
        Page<ClubVO> page = (Page<ClubVO>) clubMapper.getClubList(clubForm);
        PageInfo<ClubVO> info = page.toPageInfo();
        retResult.setData(new PageResult(info.getTotal(), info.getList()));
        return retResult;
    }

    // 获取我加入的社团
    public RetResult getMyClubList(ClubForm clubForm, PageQuery pageQuery) {
        RetResult retResult = new RetResult();
        // 当前登录用户id（
        SysUser sysUser = AuthUser.getLoginUser();
        clubForm.setUserId(sysUser.getId());
        // 开启分页
        PageHelper.startPage(pageQuery.getPage(), pageQuery.getLimit());
        Page<ClubVO> page = (Page<ClubVO>) clubMapper.getMyClubList(clubForm);
        PageInfo<ClubVO> info = page.toPageInfo();
        retResult.setData(new PageResult(info.getTotal(), info.getList()));
        return retResult;
    }
}
