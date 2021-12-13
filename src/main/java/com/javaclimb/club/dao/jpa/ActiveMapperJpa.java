package com.javaclimb.club.dao.jpa;

import com.javaclimb.club.domain.Active;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ActiveMapperJpa extends JpaRepository<Active, Integer>,
        JpaSpecificationExecutor<Active> {

}
