package com.hy.ssmp.util;

import com.hy.ssmp.pojo.Student;
import lombok.Data;

import java.util.List;

@Data
public class LayuiData {

    private Integer code;
    private String msg;
    private Integer count;
    private List<Student> data;
}
