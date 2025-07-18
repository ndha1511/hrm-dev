package com.dev.hrm_api.services.user;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dev.hrm_api.configs.auth.UserConfig;
import com.dev.hrm_api.dtos.user.UserPermDto;
import com.dev.hrm_api.models.User;
import com.dev.hrm_api.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

        private final UserRepository userRepository;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                User user = userRepository.findByUsername(username)
                                .orElseThrow(() -> new UsernameNotFoundException(
                                                "User not found with username: " + username));
                List<UserPermDto> userPerms = userRepository.findRawPermsByUsername(username);

                return new UserConfig(
                                user.getUsername(),
                                user.getPasswordHash(),
                                userPerms.stream()
                                                .map(perm -> new SimpleGrantedAuthority(
                                                                // Permission example: "READ:appCode"
                                                                new StringBuilder()
                                                                                .append(perm.getPassword())
                                                                                .append(":")
                                                                                .append(perm.getAppCode()).toString()
                                                                                .toLowerCase()))
                                                .toList());

        }

}
