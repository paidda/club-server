package com.javaclimb.club.controller;

import com.javaclimb.club.service.impl.IndexServiceImpl;
import com.javaclimb.club.utils.RetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private IndexServiceImpl indexService;

    // 首页数量
    @RequestMapping(value = "/getAllNum", method = RequestMethod.POST)
    public RetResult getAllNum() {
        return indexService.getAllNum();
    }
}






















