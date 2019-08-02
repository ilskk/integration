package com.kk.controller;

import com.kk.pojo.Person;
import com.kk.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Administrator
 * @Date: 2019/7/17 10:35
 * @Description:
 */
@RestController
public class PersonController {

    @Autowired
    PersonService service;

    @RequestMapping("/getPerson/{id}")
    public Person getPersonById(@PathVariable("id") Integer id) {
        return service.getPersonById(id);
    }

    @RequestMapping("/addPerson")
    public String addPerson(Person person){
        service.addPerson(person);
        return "add person success";
    }

    @RequestMapping("/updatePerson")
    public Person updatePerson(Person person){
         service.updatePerson(person);
         return person;
    }

    @RequestMapping("/deletePerson/{id}")
    public String deletePerson(@PathVariable("id") Integer id){
        service.deletePerson(id);
        return "delete person success";
    }

    @RequestMapping("/deleteCache/{id}")
    public String deleteCache(@PathVariable("id") Integer id){
        if(id!=null && id!=-1)
            return service.deleteCacheById(id);
        else
            return service.deleteCacheAll();
    }

}
