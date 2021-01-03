package com.mashibing.spring.annotation.dao;

import org.springframework.stereotype.Repository;

@Repository
public class PersonDao {

    public void save() {
        System.out.println("save in dao");
    }
}
