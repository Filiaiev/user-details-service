package com.filiaiev.userdetailsservice.service;

import com.filiaiev.userdetailsservice.model.UserDetails;
import com.filiaiev.userdetailsservice.repository.UserDetailsRepository;
import com.filiaiev.userdetailsservice.repository.user.UserDetailsDO;
import com.filiaiev.userdetailsservice.service.mapper.UserDetailsMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;
    private final UserDetailsMapper userDetailsMapper;

    public UserDetails getUserDetails(Long id) {
        UserDetailsDO userDetailsDO = userDetailsRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return userDetailsMapper.mapUserDetailsDOToUserDetails(userDetailsDO);
    }

    public void createUserDetails(UserDetails createUserDetails) {
        UserDetailsDO createUserDetailsDO =
                userDetailsMapper.mapUserDetailsToUserDetailsDO(createUserDetails);

        userDetailsRepository.save(createUserDetailsDO);
    }
}
