package com.javaclimb.club.dao;

import com.javaclimb.club.domain.SysNotice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysNoticeMapper {

    // 获取公告列表
    List<SysNotice> getNoticeList(SysNotice sysNotice);
}
