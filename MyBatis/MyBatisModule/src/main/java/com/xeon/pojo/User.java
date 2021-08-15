package com.xeon.pojo;

import lombok.Data;

@Data
public class User {

    private String org_id = "";
    private String default_company_code = "";
    private String name = "";
    private String gid = "";
    private Integer id;


    public User() {
    }

    public User(String org_id, String default_company_code, String name, String gid, Integer id) {
        this.org_id = org_id;
        this.default_company_code = default_company_code;
        this.name = name;
        this.gid = gid;
        this.id = id;
    }

    public User(String ord_id, String default_company_code, String name, String gid) {
        this.org_id = ord_id;
        this.default_company_code = default_company_code;
        this.name = name;
        this.gid = gid;
    }
}
