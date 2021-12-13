package com.javaclimb.club.utils;

import lombok.Data;

@Data
public class PageResult<T> {
    private long count;
    private T data;

    public PageResult(long count, T data) {
        this.count = count;
        this.data = data;
    }
}
