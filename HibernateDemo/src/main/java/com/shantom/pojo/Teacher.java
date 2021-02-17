package com.shantom.pojo;

import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class Teacher {
    private int id;
    private String name;
    private Set<Student> students;

    @Override
    public String toString() {
//        return "";
        StringBuilder ss = new StringBuilder();
        for (Student student : students) {
            ss.append(student.getName());
        }
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + ss +
                '}';
    }
}
