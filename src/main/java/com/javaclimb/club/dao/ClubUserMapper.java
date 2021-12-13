package com.javaclimb.club.dao;

import com.javaclimb.club.domain.ClubUser;
import com.javaclimb.club.domain.form.ClubUserForm;
import com.javaclimb.club.domain.vo.ClubUserVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubUserMapper {

    void deleteOldLeader(Integer clubId);

    List<ClubUserVO> getClubUserList(ClubUserForm clubUserForm);
}
