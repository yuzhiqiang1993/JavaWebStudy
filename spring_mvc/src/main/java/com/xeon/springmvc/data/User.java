package com.xeon.springmvc.data;


import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
public class User {

    private String name;
    private Integer id;
    private Integer age;

    public User() {
    }
}
