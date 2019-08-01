package com.kk.mapper;

import com.kk.pojo.Person;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2019/7/17 10:37
 * @Description:
 */
@Mapper
public interface PersonMapper {

    @Select("select * from person where id = #{id}")
    Person getPersonById(Integer id);

    @Insert("insert into person(id,name,age) values (default ,#{name},#{age})")
    void  addPerson(Person person);

    @Update("update person set name = #{name} where id = #{id}")
    void updatePerson(Person person);

    @Delete("delete from person where id = #{id}")
    void deletePerson(Integer id);

    @Select("select * from person")
    List<Person> getPersonAll();

}
