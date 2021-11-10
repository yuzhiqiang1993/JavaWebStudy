package com.xeon.springboot_mp.data.resp;

import lombok.Data;

@Data
public class BaseResp<T> {
    private int status;
    private String message;
    private T data;
}
