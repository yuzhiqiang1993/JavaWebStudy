package com.xeon.springboot_mp.dao.data.request;


import lombok.Data;

@Data
public class RequestPage {
    private int pageSize;
    private int pageNum = 20;
}
