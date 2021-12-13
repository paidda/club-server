package com.javaclimb.club.utils;

/**
 * @author
 * @Description: 返回对象实体
 * @date 2021/6
 */
public class RetResult<T> {

    public int code = RetCode.SUCCESS.code;

    private String msg = RetCode.SUCCESS.msg;

    private T data;

    public RetResult<T> setCode(RetCode retCode) {
        this.code = retCode.code;
        this.msg = retCode.msg;
        return this;
    }

    public int getCode() {
        return code;
    }

    public RetResult<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RetResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public RetResult<T> setData(T data) {
        this.data = data;
        return this;
    }

}
