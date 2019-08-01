package com.kk.service;

import com.kk.mapper.PersonMapper;
import com.kk.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2019/7/17 11:00
 * @Description:
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonMapper mapper;

    @Cacheable(cacheNames = "person",key = "#id",condition = "#id>1")
    @Override
    public Person getPersonById(Integer id) {
        return mapper.getPersonById(id);
    }

    @Override
    public void addPerson(Person person) {
        mapper.addPerson(person);
    }

    @CachePut(cacheNames = "person",key = "#result.id")
    @Override
    public Person updatePerson(Person person) {
         mapper.updatePerson(person);
         return person;
    }

    @Override
    public void deletePerson(Integer id) {
        mapper.deletePerson(id);
    }

    @Override
    public List<Person> getPersonAll() {
        return mapper.getPersonAll();
    }
}
