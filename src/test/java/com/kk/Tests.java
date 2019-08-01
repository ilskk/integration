package com.kk;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kk.destination.Queue_Produce;
import com.kk.pojo.Person;
import com.kk.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Tests {

    @Autowired
    ApplicationContext context;

    @Autowired
    PersonService service;

    @Autowired
    Person person;

    @Test
    public void contextLoads() {
//        System.out.println(service.getPersonById(1));
//        person.aop();
        //在查询之前传入当前页，然后多少记录
        PageHelper.startPage(0,2);
        //startPage后紧跟的这个查询就是分页查询
        List<Person> persons = service.getPersonAll();
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo<Person> pageInfo = new PageInfo<>(persons,5);
        //pageINfo封装了分页的详细信息，也可以指定连续显示的页数
        for (Person person : pageInfo.getList()) {
            System.out.println(person);
        }
    }

    @Autowired(required = false)
    Queue_Produce produce;

    @Test
    public void mqTest()throws Exception{
        produce.produceMsg();
    }

}
