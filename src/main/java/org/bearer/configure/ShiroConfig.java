package org.bearer.configure;

import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SessionStorageEvaluator;
import org.apache.shiro.mgt.SubjectDAO;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.config.ShiroConfiguration;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.bearer.filter.JwtFilter;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPoolConfig;

import javax.servlet.Filter;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/4/7 13:23
 */
@Configuration
public class ShiroConfig extends ShiroConfiguration {
    private final AuthorizingRealm myRealm;
    private final JedisPoolConfig jedisPoolConfig;

    public ShiroConfig(AuthorizingRealm myRealm, JedisPoolConfig jedisPoolConfig) {
        this.myRealm = myRealm;
        this.jedisPoolConfig = jedisPoolConfig;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(mySecurityManager());
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator app = new DefaultAdvisorAutoProxyCreator();
        app.setProxyTargetClass(true);
        return app;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(mySecurityManager());

        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("jwtFilter", new JwtFilter());
        factoryBean.setFilters(filterMap);

        Map<String, String> urls = new LinkedHashMap<>();
        urls.put("/login/**", "anon");
        urls.put("/swagger-ui/**", "anon");
        urls.put("/swagger-resources/**", "anon");
        urls.put("/v2/**", "anon");

        urls.put("/logout", "logout");
        urls.put("/**", "jwtFilter,authc");
        factoryBean.setFilterChainDefinitionMap(urls);
        return factoryBean;
    }

    @Bean
    public DefaultWebSecurityManager mySecurityManager() {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(myRealm());
        defaultWebSecurityManager.setSubjectDAO(subjectDAO());
        defaultWebSecurityManager.setSessionManager(sessionManager());
        defaultWebSecurityManager.setAuthenticator(authenticator());
        defaultWebSecurityManager.setCacheManager(cacheManager());
        return defaultWebSecurityManager;
    }

    public Realm myRealm() {
        HashedCredentialsMatcher matcher = new MyHashedCredentialsMatcher("MD5");
        matcher.setHashIterations(10);
        myRealm.setCredentialsMatcher(matcher);
        return myRealm;
    }

    @Override
    protected SubjectDAO subjectDAO() {
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        subjectDAO.setSessionStorageEvaluator(sessionStorageEvaluator());
        return subjectDAO;
    }

    @Override
    public SessionStorageEvaluator sessionStorageEvaluator() {
        DefaultSessionStorageEvaluator sessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        sessionStorageEvaluator.setSessionStorageEnabled(true);
        return sessionStorageEvaluator;
    }

    @Override
    protected Authenticator authenticator() {
        ModularRealmAuthenticator modularRealmAuthenticator = new ModularRealmAuthenticator();
        modularRealmAuthenticator.setRealms(Collections.singletonList(myRealm()));
        modularRealmAuthenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        return modularRealmAuthenticator;
    }

    @Override
    protected SessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(sessionDAO());
        sessionManager.setCacheManager(cacheManager());
        return sessionManager;
    }

    @Override
    protected SessionDAO sessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        redisSessionDAO.setExpire(60 * 60 * 24);
        return redisSessionDAO;
    }

    @Bean
    public CacheManager cacheManager() {
        RedisCacheManager cacheManager = new RedisCacheManager();
        cacheManager.setRedisManager(redisManager());
        cacheManager.setPrincipalIdFieldName("username");
        cacheManager.setExpire(60 * 60 * 24);
        return cacheManager;
    }

    @Bean
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setJedisPoolConfig(jedisPoolConfig);
        return redisManager;
    }
}