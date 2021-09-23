package com.xeon.springboot_mp.dao.data.resp;

import com.xeon.springboot_mp.dao.data.User;
import lombok.Data;

import java.util.List;

@Data
public class RespPageUser {
    private long total;
    private List<User> userList;
}
