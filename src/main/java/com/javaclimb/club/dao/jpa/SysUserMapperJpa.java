package com.javaclimb.club.dao.jpa;

import com.javaclimb.club.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SysUserMapperJpa extends JpaRepository<SysUser,Integer>,
        JpaSpecificationExecutor<SysUser> {

}
