package com.citystartravel.backend.security;

import com.citystartravel.backend.entity.user.User;
import com.citystartravel.backend.entity.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * About: CustomUserDetailsService
 * The custom UserDetailsService loads a user’s data given its username.
 * The first method loadUserByUsername() is used by Spring security. Notice the use of findByUsernameOrEmail method. This allows users to log in using either username or email.
 * The second method loadUserById() will be used by JWTAuthenticationFilter
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    // loadUserByUsername() is used by Spring security. Notice the use of findByUsernameOrEmail method. This allows users to log in using either username or email.
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        // Let people login with either username or email
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
                );
        return UserPrincipal.create(user);
    }

    // This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        return UserPrincipal.create(user);
    }
}
