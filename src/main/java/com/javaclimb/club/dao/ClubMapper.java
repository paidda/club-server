package com.javaclimb.club.dao;

import com.javaclimb.club.domain.Club;
import com.javaclimb.club.domain.form.ClubForm;
import com.javaclimb.club.domain.vo.ClubVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubMapper {

    // 获取社团列表
    List<ClubVO> getClubList(ClubForm clubForm);

    List<ClubVO> getMyClubList(ClubForm clubForm);
}
