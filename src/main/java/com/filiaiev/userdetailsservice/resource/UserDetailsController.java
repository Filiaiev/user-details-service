package com.filiaiev.userdetailsservice.resource;

import com.filiaiev.userdetailsservice.model.UserDetails;
import com.filiaiev.userdetailsservice.resource.mapper.UserDetailsResourceMapper;
import com.filiaiev.userdetailsservice.resource.user.UserDetailsRO;
import com.filiaiev.userdetailsservice.service.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserDetailsController {

    private final UserDetailsService userDetailsService;
    private final UserDetailsResourceMapper userDetailsResourceMapper;

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('MANAGER', 'ADMIN') or hasAuthority('CUSTOMER') and principal == #id")
    public UserDetailsRO getUserDetails(@PathVariable Long id) {
        UserDetails userDetails = userDetailsService.getUserDetails(id);
        return userDetailsResourceMapper.mapUserDetailsToUserDetailsRO(userDetails);
    }
}
