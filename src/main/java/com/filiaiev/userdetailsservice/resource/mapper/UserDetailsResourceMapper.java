package com.filiaiev.userdetailsservice.resource.mapper;

import com.filiaiev.userdetailsservice.model.UserDetails;
import com.filiaiev.userdetailsservice.resource.user.UserDetailsRO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDetailsResourceMapper {

    UserDetailsRO mapUserDetailsToUserDetailsRO(UserDetails userDetails);
}
