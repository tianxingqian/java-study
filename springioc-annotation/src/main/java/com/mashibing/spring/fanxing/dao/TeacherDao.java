package com.mashibing.spring.fanxing.dao;

import com.mashibing.spring.fanxing.model.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherDao extends BaseDao<Teacher> {
    public void save() {
        System.out.println("保存Teacher");
    }
}
