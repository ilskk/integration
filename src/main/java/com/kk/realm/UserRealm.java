package com.kk.realm;

import com.kk.pojo.User;
import com.kk.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther: Administrator
 * @Date: 2019/7/31 16:26
 * @Description:
 */
public class UserRealm  extends AuthorizingRealm {

    @Autowired
    private UserService service;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //为资源进行授权
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();

        //添加资源的授权字符串
//        info.addStringPermission("user:add");

        //获取当前用户
        Subject subject= SecurityUtils.getSubject();
        User principal = (User)subject.getPrincipal();
        User user = service.queryByUName(principal.getUsername());
        info.addStringPermission(user.getPerms());

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;

        User user = service.queryByUName(token.getUsername());

        if(null==user){
            return null;
        }

        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user,user.getPassword(),"");

        return info;
    }
}
