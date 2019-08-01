package com.kk.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: Administrator
 * @Date: 2019/7/31 20:13
 * @Description:
 */
@Setter
@Getter
public class User {

    private Integer id;
    private String username,password,perms;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }
}
