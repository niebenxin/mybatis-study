package com.hy.ssm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String id;
    private String name;
    private String sex;
    private Integer classno;
    private String mgr;
    private Date bdate;
    private String img;
    private Classes classes;
}
