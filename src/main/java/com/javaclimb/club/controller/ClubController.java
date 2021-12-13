package com.javaclimb.club.controller;

import com.javaclimb.club.domain.Club;
import com.javaclimb.club.domain.SysNotice;
import com.javaclimb.club.domain.form.ClubForm;
import com.javaclimb.club.service.impl.ClubServiceImpl;
import com.javaclimb.club.service.impl.SysNoticeServiceImpl;
import com.javaclimb.club.utils.PageQuery;
import com.javaclimb.club.utils.RetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("club")
public class ClubController {

    @Autowired
    private ClubServiceImpl clubService;

    // 获取社团列表
    @RequestMapping(value = "/getClubList", method = RequestMethod.POST)
    public RetResult getClubList(ClubForm clubForm, PageQuery pageQuery) {
        return clubService.getClubList(clubForm, pageQuery);
    }

    // 获取我加入的社团列表
    @RequestMapping(value = "/getMyClubList", method = RequestMethod.POST)
    public RetResult getMyClubList(ClubForm clubForm, PageQuery pageQuery) {
        return clubService.getMyClubList(clubForm, pageQuery);
    }

    // 添加社团
    @RequestMapping(value = "/addClub", method = RequestMethod.POST)
    public RetResult addNotice(Club club) {
        return clubService.addClub(club);
    }

    // 更新社团
    @RequestMapping(value = "/updateClub", method = RequestMethod.POST)
    public RetResult updateClub(Club club) {
        return clubService.updateClub(club);
    }

    // 删除社团
    @RequestMapping(value = "/deleteClub", method = RequestMethod.POST)
    public RetResult deleteClub(Club club) {
        return clubService.deleteClub(club);
    }

    // 启用停止社团
    @RequestMapping(value = "/stopClub", method = RequestMethod.POST)
    public RetResult stopClub(Club club) {
        return clubService.stopClub(club);
    }

}






















