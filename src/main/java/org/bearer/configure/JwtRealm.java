package org.bearer.configure;

import lombok.SneakyThrows;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.bearer.entity.po.User;
import org.bearer.entity.pojo.JwtToken;
import org.bearer.mapper.RoleMapper;
import org.bearer.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/4/7 13:24
 */
@Component
public class JwtRealm extends AuthorizingRealm {
    private final RoleMapper rolesMapper;
    private final UserMapper userMapper;

    public JwtRealm(RoleMapper rolesMapper, UserMapper userMapper) {
        this.rolesMapper = rolesMapper;
        this.userMapper = userMapper;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        User user = (User) principalCollection.getPrimaryPrincipal();

        Set<String> roles = rolesMapper.selectRolesByUserId(user.getId());

        info.setRoles(roles);

        return info;
    }

    @SneakyThrows
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        String id = (String) authenticationToken.getPrincipal();

        if (id == null) {
            throw new AccountException("JWT Token参数异常！");
        }

        User user = userMapper.selectById(id);

        if (user == null) {
            throw new UnknownAccountException("用户不存在！");
        }

        if (user.getLocked()) {
            throw new LockedAccountException("账户被锁定！");
        }

        return new SimpleAuthenticationInfo(user, null, "jwtRealm");
    }
}