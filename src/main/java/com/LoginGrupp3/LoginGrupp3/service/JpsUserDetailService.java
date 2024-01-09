package com.LoginGrupp3.LoginGrupp3.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.LoginGrupp3.LoginGrupp3.model.UserDto;
import com.LoginGrupp3.LoginGrupp3.repository.UserRepository;

@Service
public class JpsUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public JpsUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByUsername(username)
                .map(UserDto::new)
                .orElseThrow(() -> new UsernameNotFoundException("Error"));
    }

}
