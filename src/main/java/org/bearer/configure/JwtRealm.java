package org.bearer.configure;

import lombok.SneakyThrows;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.bearer.entity.po.User;
import org.bearer.entity.pojo.JwtToken;
import org.bearer.mapper.RoleMapper;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/4/7 13:24
 */
@Component
public class JwtRealm extends AuthorizingRealm {
    private final RoleMapper roleMapper;

    public JwtRealm(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        User user = (User) SecurityUtils.getSubject().getPrincipal();

        Set<String> roles = roleMapper.selectRolesByUserId(user.getId());

        info.setRoles(roles);

        return info;
    }

    @SneakyThrows
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {

        return new SimpleAuthenticationInfo(authenticationToken, authenticationToken, getName());
    }
}