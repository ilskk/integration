package com.kk.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * @Auther: Administrator
 * @Date: 2019/7/17 10:32
 * @Description:
 */
@Setter
@Getter
@Component
public class Person {

    private Integer id;
    private String name;
    private Integer age;

    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void aop(){System.out.println("AOP test");}
}
