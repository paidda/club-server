package com.javaclimb.club.utils;

import lombok.Data;

@Data
public class PageQuery {
    private int page = 1;
    private int limit = 10;
}
