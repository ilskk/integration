package com.kk.service;

import com.kk.pojo.Person;
import org.springframework.cache.annotation.CacheEvict;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2019/7/17 10:45
 * @Description:
 */
public interface PersonService {

    Person getPersonById(Integer id);

    void  addPerson(Person person);

    Person updatePerson(Person person);

    void deletePerson(Integer id);

    List<Person> getPersonAll();

    @CacheEvict(cacheNames = "person",key = "#id",beforeInvocation = true)
    default String deleteCacheById(Integer id){
        return "清除"+id+"号缓存";
    }

    @CacheEvict(cacheNames = "person",allEntries = true,beforeInvocation = true)
    default String deleteCacheAll(){
        return "清除当前所有缓存";
    }

}
