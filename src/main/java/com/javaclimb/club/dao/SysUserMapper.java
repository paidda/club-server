package com.javaclimb.club.dao;

import com.javaclimb.club.domain.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMapper {

    SysUser verifyPassword(String no, String password);

    List<SysUser> getUserList(SysUser sysUser);
}
