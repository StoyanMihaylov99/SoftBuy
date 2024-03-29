package com.example.softwareecommers.security;

import com.example.softwareecommers.models.entities.UserEntity;
import com.example.softwareecommers.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findFirstByUserName(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
       return user.map(MyUserDetails::new).get();
    }
}
