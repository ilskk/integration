package com.kk.service;

import com.kk.mapper.UserMapper;
import com.kk.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Administrator
 * @Date: 2019/7/31 20:16
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper mapper;

    @Override
    public User queryByUName(String username) {
        return mapper.queryByUName(username);
    }
}
