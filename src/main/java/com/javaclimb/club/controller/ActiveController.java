package com.javaclimb.club.controller;

import com.javaclimb.club.domain.Active;
import com.javaclimb.club.domain.form.ActiveForm;
import com.javaclimb.club.domain.form.ClubForm;
import com.javaclimb.club.service.impl.ActiveServiceImpl;
import com.javaclimb.club.utils.PageQuery;
import com.javaclimb.club.utils.RetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("active")
public class ActiveController {

    @Autowired
    private ActiveServiceImpl activeService;

    // 获取活动列表
    @RequestMapping(value = "/getActiveList", method = RequestMethod.POST)
    public RetResult getActiveList(ActiveForm activeForm, PageQuery pageQuery) {
        return activeService.getActiveList(activeForm, pageQuery);
    }

    // 添加活动
    @RequestMapping(value = "/addActive", method = RequestMethod.POST)
    public RetResult addActive(ActiveForm activeForm) {
        return activeService.addActive(activeForm);
    }

    // 更新活动
    @RequestMapping(value = "/updateActive", method = RequestMethod.POST)
    public RetResult updateActive(ActiveForm activeForm) {
        return activeService.updateActive(activeForm);
    }


    // 删除活动
    @RequestMapping(value = "/deleteActive", method = RequestMethod.POST)
    public RetResult deleteActive(Active active) {
        return activeService.deleteActive(active);
    }

}






















