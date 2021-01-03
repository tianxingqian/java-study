package com.mashibing.springioc.mysql;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class TestMysql {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc-mysql.xml");

        DruidDataSource datasource = context.getBean("datasource", DruidDataSource.class);
        System.out.println(datasource);

        System.out.println("=======datasource2=======");
        DruidDataSource datasource2 = context.getBean("datasource2", DruidDataSource.class);
        try {
            datasource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(datasource2);

    }
}
