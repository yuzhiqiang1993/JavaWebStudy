package com.xeon.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private String orgId = "";
    private String defaultCompanyCode = "";
    private String name = "";
    private String gid = "";
    private Integer id;


    public User() {
    }

    public User(String org_id, String default_company_code, String name, String gid, Integer id) {
        this.orgId = org_id;
        this.defaultCompanyCode = default_company_code;
        this.name = name;
        this.gid = gid;
        this.id = id;
    }

    public User(String ord_id, String default_company_code, String name, String gid) {
        this.orgId = ord_id;
        this.defaultCompanyCode = default_company_code;
        this.name = name;
        this.gid = gid;
    }
}
