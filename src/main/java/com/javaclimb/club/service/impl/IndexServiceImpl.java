package com.javaclimb.club.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaclimb.club.dao.ClubMapper;
import com.javaclimb.club.dao.ClubMapperJpa;
import com.javaclimb.club.dao.jpa.ActiveMapperJpa;
import com.javaclimb.club.dao.jpa.SysNoticeMapperJpa;
import com.javaclimb.club.dao.jpa.SysUserMapperJpa;
import com.javaclimb.club.domain.Club;
import com.javaclimb.club.domain.SysUser;
import com.javaclimb.club.domain.form.ClubForm;
import com.javaclimb.club.domain.vo.ClubVO;
import com.javaclimb.club.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class IndexServiceImpl {

    @Autowired
    private ClubMapperJpa clubMapperJpa;

    @Autowired
    private SysUserMapperJpa sysUserMapperJpa;

    @Autowired
    private SysNoticeMapperJpa sysNoticeMapperJpa;

    @Autowired
    private ActiveMapperJpa activeMapperJpa;

    // 首页数量
    public RetResult getAllNum() {
        RetResult retResult = new RetResult();
        Map<String, Object> map = new HashMap<>();
        map.put("userCount", sysUserMapperJpa.count());
        map.put("clubCount", clubMapperJpa.count());
        map.put("noticeCount", sysNoticeMapperJpa.count());
        map.put("activeCount", activeMapperJpa.count());
        retResult.setData(map);
        return retResult;
    }
}
