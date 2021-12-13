package com.javaclimb.club.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaclimb.club.dao.SysNoticeMapper;
import com.javaclimb.club.dao.jpa.SysNoticeMapperJpa;
import com.javaclimb.club.domain.SysNotice;
import com.javaclimb.club.domain.SysUser;
import com.javaclimb.club.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class SysNoticeServiceImpl {

    @Autowired
    private SysNoticeMapper sysNoticeMapper;

    @Autowired
    private SysNoticeMapperJpa sysNoticeMapperJpa;

    // 获取公告列表
    public RetResult getNoticeList(SysNotice sysNotice, PageQuery pageQuery) {
        RetResult retResult = new RetResult();
        // 开启分页
        PageHelper.startPage(pageQuery.getPage(), pageQuery.getLimit());
        Page<SysNotice> page = (Page<SysNotice>) sysNoticeMapper.getNoticeList(sysNotice);
        PageInfo<SysNotice> info = page.toPageInfo();
        retResult.setData(new PageResult(info.getTotal(), info.getList()));
        return retResult;
    }

    // 添加公告
    public RetResult addNotice(SysNotice sysNotice) {
        RetResult retResult = new RetResult();
        sysNotice.setCrtTime(new Date());
        sysNoticeMapperJpa.save(sysNotice);
        return retResult;
    }

    // 更新公告
    public RetResult updateNotice(SysNotice sysNotice) {
        RetResult retResult = new RetResult();
        SysNotice notice = sysNoticeMapperJpa.getOne(sysNotice.getId());
        if (null == notice) {
            retResult.setCode(RetCode.FAIL);
            retResult.setMsg("公告不存在，请刷新重试");
            return retResult;
        }
        notice.setTitle(sysNotice.getTitle());
        notice.setPublish(sysNotice.getPublish());
        sysNoticeMapperJpa.save(notice);
        return retResult;
    }

    // 删除公告
    public RetResult deleteNotice(SysNotice sysNotice) {
        RetResult retResult = new RetResult();
        sysNoticeMapperJpa.deleteById(sysNotice.getId());
        return retResult;
    }

    // 发布或取消发布公告
    public RetResult publishNotice(SysNotice sysNotice) {
        RetResult retResult = new RetResult();
        SysNotice notice = sysNoticeMapperJpa.getOne(sysNotice.getId());
        if (null == notice) {
            retResult.setCode(RetCode.FAIL);
            retResult.setMsg("公告不存在，请刷新重试");
            return retResult;
        }
        notice.setPublish(sysNotice.getPublish());
        sysNoticeMapperJpa.save(notice);
        return retResult;
    }
}
