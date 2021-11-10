package com.xeon.springboot_mp.data.request;


import lombok.Data;

@Data
public class RequestPage {
    private int pageSize=20;
    private int pageNum = 1;
}
