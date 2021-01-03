package com.mashibing.spring.fanxing.dao;

import com.mashibing.spring.fanxing.model.Student;
import org.springframework.stereotype.Repository;

import javax.sound.midi.Soundbank;

@Repository
public class StudentDao extends BaseDao<Student> {


    public void save() {
        System.out.println("保存Student");
    }
}
