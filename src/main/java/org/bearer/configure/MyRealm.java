package org.bearer.configure;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.bearer.entity.po.User;
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
public class MyRealm extends AuthorizingRealm {

    private final UserMapper userMapper;
    private final RoleMapper roleMapper;

    public MyRealm(UserMapper userMapper, RoleMapper roleMapper) {
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        User user = (User) principalCollection.getPrimaryPrincipal();

        Set<String> roles = roleMapper.selectRolesByUserId(user.getId());

        info.setRoles(roles);

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        String account = (String) authenticationToken.getPrincipal();

        User user = userMapper.selectOne(account);

        if (user == null) {
            throw new UnknownAccountException("用户不存在！");
        }

        if (user.getLocked()) {
            throw new LockedAccountException("账号已被锁定！");
        }

        ByteSource byteSource = ByteSource.Util.bytes(user.getSalt());

        return new SimpleAuthenticationInfo(user, user.getPassword(), byteSource, "myRealm");
    }
}