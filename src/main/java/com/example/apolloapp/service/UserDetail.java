package com.example.apolloapp.service;

import com.example.apolloapp.model.RoleModel;
import com.example.apolloapp.model.UserModel;
import com.example.apolloapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

// jest to klasa łącząca naszą bazę danych ze stroną logowania

@Service
@RequiredArgsConstructor
public class UserDetail implements UserDetailsService {

    private final UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepo.findByUsernameOrEmail(username, username);  // rozważyć opakowanie w Optional + try-catch

        if (user == null) {
            throw new UsernameNotFoundException("User not exists by Username");
        }
        RoleModel rm = user.getRole();
        GrantedAuthority authorithy = new SimpleGrantedAuthority(user.getRole().getTypeName());
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(authorithy);

        return new User(username, user.getPassword(), authorities);
    }
}
