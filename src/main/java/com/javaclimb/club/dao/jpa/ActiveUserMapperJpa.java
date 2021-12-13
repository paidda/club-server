package com.javaclimb.club.dao.jpa;

import com.javaclimb.club.domain.ActiveUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ActiveUserMapperJpa extends JpaRepository<ActiveUser, Integer>,
        JpaSpecificationExecutor<ActiveUser> {

}
