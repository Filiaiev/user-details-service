package com.filiaiev.userdetailsservice.resource;

import com.filiaiev.userdetailsservice.model.UserDetails;
import com.filiaiev.userdetailsservice.resource.mapper.UserDetailsResourceMapper;
import com.filiaiev.userdetailsservice.resource.user.UserDetailsRO;
import com.filiaiev.userdetailsservice.service.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserDetailsController {

//    @Value("${authentication-service.base-url}")
//    private final String authenticationServiceUrl;

    private final UserDetailsService userDetailsService;
    private final UserDetailsResourceMapper userDetailsResourceMapper;

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('MANAGER', 'ADMIN') or hasRole('CUSTOMER') and principal == #id")
    public UserDetailsRO getUserDetails(@PathVariable Long id) {
        UserDetails userDetails = userDetailsService.getUserDetails(id);
        return userDetailsResourceMapper.mapUserDetailsToUserDetailsRO(userDetails);
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:8080/")
    @PreAuthorize("hasRole('CUSTOMER')")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUserDetails(@RequestBody UserDetailsRO createUserDetailsRO) {
        UserDetails createUserDetails =
                userDetailsResourceMapper.mapUserDetailsROToUserDetails(createUserDetailsRO);

        userDetailsService.createUserDetails(createUserDetails);
    }
}
