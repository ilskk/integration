package com.kk.service;
/**
 * @Auther: Administrator
 * @Date: 2019/7/31 20:16
 * @Description:
 */

import com.kk.pojo.User;

/**
 *
 *
 * @author
 * @date 2019/7/31 20:16
 */
public interface UserService {

    public User queryByUName(String username);

}
