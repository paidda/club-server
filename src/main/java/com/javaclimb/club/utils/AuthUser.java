package com.javaclimb.club.utils;

import com.javaclimb.club.domain.SysUser;
import lombok.Data;

import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;

// 登录用户信息
@Data
public class AuthUser {

    // 这个是线程安全的
    private static ConcurrentHashMap<String, SysUser> userMap = new ConcurrentHashMap<String, SysUser>();

    // 插入一条数据
    public static void insert(SysUser luser) {
// 预防一些意外的重复执行，加了一个线程锁
        synchronized (SysUser.class) {
            userMap.put("user", luser);
        }
    }


    // 得到用户登录信息
    public static SysUser getLoginUser() {
        SysUser lu = new SysUser();
        lu = userMap.get("user");
        return lu;
    }
}
