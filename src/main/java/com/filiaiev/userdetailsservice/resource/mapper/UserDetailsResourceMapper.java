package com.filiaiev.userdetailsservice.resource.mapper;

import com.filiaiev.userdetailsservice.model.UserDetails;
import com.filiaiev.userdetailsservice.resource.user.UserDetailsRO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserDetailsResourceMapper {

    UserDetailsRO mapUserDetailsToUserDetailsRO(UserDetails userDetails);

    @Mapping(target = "createdAt", expression = "java(java.time.Instant.now())")
    UserDetails mapUserDetailsROToUserDetails(UserDetailsRO userDetailsRO);
}
