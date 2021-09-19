package com.xeon.entity;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Integer age;

    public User() {
    }
}
