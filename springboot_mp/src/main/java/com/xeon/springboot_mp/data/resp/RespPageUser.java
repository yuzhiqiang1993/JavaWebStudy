package com.xeon.springboot_mp.data.resp;

import com.xeon.springboot_mp.dao.User;
import lombok.Data;

import java.util.List;

@Data
public class RespPageUser {
    private long total;
    private List<User> userList;
}
