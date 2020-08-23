package cn.codesheep.service;

import cn.codesheep.entity.Role;
import cn.codesheep.entity.UserRole;
import cn.codesheep.repository.RoleRepository;
import cn.codesheep.repository.UserRepository;
import cn.codesheep.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Component
public class SheepUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        cn.codesheep.entity.User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("用户" + username + "不存在" );
        }
        List<UserRole> userRoles = userRoleRepository.findByUserId(user.getId());
        Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();
        for (UserRole userRole: userRoles) {
            Optional<Role> optional = roleRepository.findById(userRole.getRoleId());
            collection.add(new SimpleGrantedAuthority(optional.get().getName()));
        }
        return new User(username,
                passwordEncoder.encode(user.getPassword()), collection);
    }
}
