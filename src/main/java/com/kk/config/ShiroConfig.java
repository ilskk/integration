package com.kk.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.kk.realm.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Auther: Administrator
 * @Date: 2019/7/31 16:25
 * @Description:
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Autowired DefaultWebSecurityManager manager){
        ShiroFilterFactoryBean factoryBean=new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(manager);
        //设置shiro过滤器
        Map<String,String> filterMap=new LinkedHashMap<>();
        /*filterMap.put("/shiro/add","authc");
        filterMap.put("/shiro/update","authc");*/
        filterMap.put("/shiro/login","anon");
        filterMap.put("/logout","logout");
        //设置授权过滤器
        filterMap.put("/shiro/add","perms[user:add]");
        filterMap.put("/shiro/update","perms[user:update]");
        //设置未授权页面
        factoryBean.setLoginUrl("/shiro/login");
        factoryBean.setUnauthorizedUrl("/shiro/unauth");
        filterMap.put("/**","authc");
        factoryBean.setFilterChainDefinitionMap(filterMap);
        return factoryBean;
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Autowired UserRealm userRealm){
        DefaultWebSecurityManager manager=new DefaultWebSecurityManager();
        manager.setRealm(userRealm);
        return manager;
    }

    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

    //用于thymeleaf配合shiro标签
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }

}
