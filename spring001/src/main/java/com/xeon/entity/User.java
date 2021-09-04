package com.xeon.entity;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {
    @Value("1")
    private Integer id;
    @Value("Xeon")
    private String name;
    @Value("28")
    private Integer age;

}
