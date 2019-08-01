package com.kk.mapper;

import com.kk.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Auther: Administrator
 * @Date: 2019/7/31 20:13
 * @Description:
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username}")
    public User queryByUName(String username);

}
