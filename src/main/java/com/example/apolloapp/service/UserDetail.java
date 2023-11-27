package com.example.apolloapp.service;

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

import java.util.Set;
import java.util.stream.Collectors;

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
        Set<GrantedAuthority> authorities = user.getRoles().stream()
                .map((role) -> new SimpleGrantedAuthority(role.getTypeName()))
                .collect(Collectors.toSet());
        return new User(username, user.getPassword(), authorities);
        // co się dzieje w return?
        // org.springframework.security.core.userdetails. ---> to jest import klasy
        // User klasa za Spring Security i na podstawie tej klasy ściągamy informacje jakie role ma użytkownia
    }
}
