package com.xeon.springboot_mp.dao.data.request;


import lombok.Data;

@Data
public class RequestPage {
    private int pageSize=20;
    private int pageNum = 1;
}
