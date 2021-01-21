package com.shantom.dao;

import com.shantom.pojo.Teacher;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
    List<Teacher> getTeacherList1();

    List<Teacher> getTeacherList2();

}
