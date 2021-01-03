package com.mashibing.springioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public void test() {

    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
        Person person = (Person) context.getBean("person1");
        Person person2 = (Person) context.getBean("person1");

        System.out.println(person);
        System.out.println(person == person2);

        System.out.println("===============使用类型获取bean=============");
        // 使用类型获取bean, 使用类型获取bean时，容器中不能出现两个一样的类型的bean，不然会报错
        // Person person1 = context.getBean(Person.class);
        Person person1 = context.getBean("person2", Person.class);
        System.out.println(person1);

        // 使用构造器给bean对象赋值
        System.out.println("=========使用构造器为属性赋值===========");
        Person person3 = context.getBean("person3", Person.class);
        System.out.println(person3);
        Person person4 = context.getBean("person4", Person.class);
        System.out.println(person4);

        Person person5 = context.getBean("person5", Person.class);
        System.out.println(person5);

        Person person6 = context.getBean("person6", Person.class);
        System.out.println(person6);

        // 使用命名空间赋值
        System.out.println("=====使用命名空间赋值=====");
        Person person7 = context.getBean("person7", Person.class);
        System.out.println(person7);


        // 复杂类型赋值
        System.out.println("=====复杂类型赋值======");
        Person person8 = context.getBean("person8", Person.class);
        System.out.println(person8);

        // 级联属性赋值
        System.out.println("=====级联属性赋值======");
        Person person9 = context.getBean("person9", Person.class);
        System.out.println(person9);

        // util命名空间的集合属性
        System.out.println("======util名称空间创建集合类型的bean======");
        System.out.println(context.getBean("list"));
        System.out.println(context.getBean("map"));

        // 继承关系
        System.out.println("===========继承==========");
        // System.out.println(context.getBean("parent"));  // abstract不能实例化
        System.out.println(context.getBean("xman"));

        // bean的作用域  scope  singleton、prototype
        System.out.println("=========bean的作用域===========");
        Person person10 = context.getBean("person10", Person.class);
        Person person101 = context.getBean("person10", Person.class);
        System.out.println("scope=prototype: " + (person10 == person101));

        Person person11 = context.getBean("person11", Person.class);
        Person person111 = context.getBean("person11", Person.class);
        System.out.println("scope=singleton: " + (person11 == person111));

        // 静态工厂
        System.out.println("=======静态工厂===========");
        Person person12 = context.getBean("person12", Person.class);
        Person person121 = context.getBean("person12", Person.class);
        System.out.println(person12 == person121);

        // 实例工厂方法
        System.out.println("=======实例工厂===========");
        Person person13 = context.getBean("person13", Person.class);
        Person person131 = context.getBean("person13", Person.class);
        System.out.println(person13 == person131);

        // 实现FactoryBean
        System.out.println("========实现FactoryBean===========");
        Person person14 = context.getBean("person14", Person.class);
        Person person141 = context.getBean("person14", Person.class);
        System.out.println(person14 == person141);

        // 初始化方法、销毁方法
        System.out.println("========初始化方法=======");
        Person person15 = context.getBean("person15", Person.class);
        System.out.println(person15);

        // SpEL表达式
        System.out.println("=======SpEL表达式");
        Person person16 = context.getBean("person16", Person.class);
        System.out.println(person16);

        // 关闭context
        context.close();
    }
}
