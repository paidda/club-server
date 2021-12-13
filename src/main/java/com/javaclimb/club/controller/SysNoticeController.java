package com.javaclimb.club.controller;

import com.javaclimb.club.domain.SysNotice;
import com.javaclimb.club.service.impl.SysNoticeServiceImpl;
import com.javaclimb.club.utils.PageQuery;
import com.javaclimb.club.utils.RetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("notice")
public class SysNoticeController {

    @Autowired
    private SysNoticeServiceImpl sysNoticeService;

    // 获取公告列表
    @RequestMapping(value = "/getNoticeList", method = RequestMethod.POST)
    public RetResult getNoticeList(SysNotice sysNotice, PageQuery pageQuery) {
        return sysNoticeService.getNoticeList(sysNotice, pageQuery);
    }

    // 添加公告
    @RequestMapping(value = "/addNotice", method = RequestMethod.POST)
    public RetResult addNotice(SysNotice sysNotice) {
        return sysNoticeService.addNotice(sysNotice);
    }

    // 更新公告
    @RequestMapping(value = "/updateNotice", method = RequestMethod.POST)
    public RetResult updateNotice(SysNotice sysNotice) {
        return sysNoticeService.updateNotice(sysNotice);
    }

    // 删除公告
    @RequestMapping(value = "/deleteNotice", method = RequestMethod.POST)
    public RetResult deleteNotice(SysNotice sysNotice) {
        return sysNoticeService.deleteNotice(sysNotice);
    }

    // 发布或取消发布公告
    @RequestMapping(value = "/publishNotice", method = RequestMethod.POST)
    public RetResult publishNotice(SysNotice sysNotice) {
        return sysNoticeService.publishNotice(sysNotice);
    }
}






















