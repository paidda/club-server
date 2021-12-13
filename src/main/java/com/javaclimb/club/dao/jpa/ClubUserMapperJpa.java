package com.javaclimb.club.dao.jpa;

import com.javaclimb.club.domain.ClubUser;
import com.javaclimb.club.domain.SysNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClubUserMapperJpa extends JpaRepository<ClubUser, Integer>,
        JpaSpecificationExecutor<ClubUser> {

}
