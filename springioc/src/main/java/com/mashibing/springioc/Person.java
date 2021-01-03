package com.mashibing.springioc;

import org.springframework.beans.factory.BeanNameAware;

import java.util.*;

public class Person implements BeanNameAware {

    private Integer id;
    private String name;
    private String gender;
    private Integer age;

    private String[] favs;
    private Address address;

    public Person(Address address1) {
        this.address = address1;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", favs=" + Arrays.toString(favs) +
                ", address=" + address +
                ", addressList=" + addressList +
                ", children=" + children +
                ", score=" + score +
                ", properties=" + properties +
                '}';
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    private List<Address> addressList;
    private Set<String> children;
    private Map<String, Object> score;
    private Properties properties;

    public Person() {
    }

    public Person(Integer id, String name, String gender, Integer age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Person(Integer id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public Person(String name, String gender, Integer age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getFavs() {
        return favs;
    }

    public void setFavs(String[] favs) {
        this.favs = favs;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public Set<String> getChildren() {
        return children;
    }

    public void setChildren(Set<String> children) {
        this.children = children;
    }

    public Map<String, Object> getScore() {
        return score;
    }

    public void setScore(Map<String, Object> score) {
        this.score = score;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setBeanName(String s) {
        System.out.println("beanname=" + s);
    }

    public void init() {
        System.out.println("初始化Person bean");
    }

    public void destroy() {
        System.out.println("销毁Person bean");
    }
}
