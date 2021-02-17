package com.shantom.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private Teacher teacher;

    @Override
    public String toString() {
//        return "";
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher=" + teacher.getName() +
                '}';
    }
}
