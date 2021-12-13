package com.javaclimb.club.dao;

import com.javaclimb.club.domain.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClubMapperJpa extends JpaRepository<Club, Integer>,
        JpaSpecificationExecutor<Club> {

}
