package com.javaclimb.club.utils;

/**
 * @author
 * @Description: 响应码枚举，参考HTTP状态码的语义
 * @date 2021/6
 */
public enum RetCode {

    // 成功
    SUCCESS(1,"操作成功"),

    // 失败
    FAIL(0,"请求失败");

    public int code;

    public String msg;

    RetCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
